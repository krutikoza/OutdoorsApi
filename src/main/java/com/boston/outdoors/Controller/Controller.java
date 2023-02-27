package com.boston.outdoors.Controller;

import com.boston.outdoors.Interface.ChaptersRepository;
import com.boston.outdoors.Interface.PointOfInterestContentsRepository;
import com.boston.outdoors.Interface.PointOfInterestsRepository;
import com.boston.outdoors.Models.Chapters;
import com.boston.outdoors.Models.PointOfInterestContents;
import com.boston.outdoors.Models.PointOfInterests;
import com.boston.outdoors.Models.ViewModels.ChaptersViewModel;
import com.boston.outdoors.Models.ViewModels.PointOfInterestContentViewModel;
import com.boston.outdoors.Models.ViewModels.PointOfInterestViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@EnableCaching
@RestController
@RequestMapping("/api/v1/")
public class Controller {

    @Autowired
    private ChaptersRepository chaptersRepository;

    @Autowired
    private PointOfInterestsRepository pointOfInterestsRepository;

    @Autowired
    private PointOfInterestContentsRepository pointOfInterestContentsRepository;



    // get all chapters
    @Cacheable(cacheNames = "chaptersCache")
    @PostMapping ("/getchapters")
    public List<ChaptersViewModel> getChapters(){

        List<Chapters> chapters = chaptersRepository.findAll();

        List<ChaptersViewModel> chaptersViewModels = new ArrayList<>();

        for(int i = 0; i < chapters.size(); i++){
            chaptersViewModels.add(new ChaptersViewModel(chapters.get(i)));
        }

        return chaptersViewModels;
    }


    // get all pointofinterests
    @Cacheable(cacheNames = "pointofinterestCache", key = "#id")
    @GetMapping("/getpointofinterest")
    public List<PointOfInterestViewModel> getPointOfInterest(@RequestParam Long id){

        List<PointOfInterests> pointOfInterests = new ArrayList();

        pointOfInterests = pointOfInterestsRepository.findAllByChaptersId(id);

        List<PointOfInterestViewModel> pointOfInterestViewModels = new ArrayList<PointOfInterestViewModel>();

        for(int i = 0; i<pointOfInterests.size(); i++) {
            pointOfInterestViewModels.add(new PointOfInterestViewModel(pointOfInterests.get(i)));
        }

        return pointOfInterestViewModels;

    }

    // get all pointofinterestcontents
    @Cacheable(cacheNames = "pointofinterestcontentCache", key = "#id")
    @GetMapping("/getpointofinterestcontents")
    public List<PointOfInterestContentViewModel> getPointOfInterestContents(@RequestParam Long id){

        List<PointOfInterestContents> pointOfInterestContents = new ArrayList<>();

        pointOfInterestContents = pointOfInterestContentsRepository.findByPointOfInterestsId(id);

        List<PointOfInterestContentViewModel> pointOfInterestContentViewModels = new ArrayList<>();

        for(int i = 0; i < pointOfInterestContents.size(); i++){
            pointOfInterestContentViewModels.add(new PointOfInterestContentViewModel(pointOfInterestContents.get(i)));
        }

        return pointOfInterestContentViewModels;

    }

}
