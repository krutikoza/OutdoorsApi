package com.boston.outdoors.Controller;

import com.boston.outdoors.Interface.ChaptersRepository;
import com.boston.outdoors.Interface.PointOfInterestContentsRepository;
import com.boston.outdoors.Interface.PointOfInterestsRepository;
import com.boston.outdoors.Models.Chapters;
import com.boston.outdoors.Models.PointOfInterestContents;
import com.boston.outdoors.Models.PointOfInterests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class Controller {

    @Autowired
    private ChaptersRepository chaptersRepository;

    @Autowired
    private PointOfInterestsRepository pointOfInterestsRepository;

    @Autowired
    private PointOfInterestContentsRepository pointOfInterestContentsRepository;

    @GetMapping("/getchapters")
    public List<Chapters> getChapters(){
        return chaptersRepository.findAll();
    }


    @GetMapping("/getpointofinterest")
    public List<PointOfInterests> getPointOfInterest(@RequestParam Long id){
        return pointOfInterestsRepository.findAllByChaptersId(id);
    }

    @GetMapping("/getpointofinterestcontents")
    public List<PointOfInterestContents> getPointOfInterestContents(@RequestParam Long id){
        return pointOfInterestContentsRepository.findByPointOfInterestsId(id);
    }

}
