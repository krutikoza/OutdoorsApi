package com.boston.OutdoorsApi.controller.impl;

import com.boston.OutdoorsApi.Models.Chapters;
import com.boston.OutdoorsApi.Models.PointOfInterests;
import com.boston.OutdoorsApi.controller.PointOfInterestsController;
import com.boston.OutdoorsApi.dao.PointOfInterestsRepository;
import com.boston.OutdoorsApi.dto.PointOfInterestsDTO;
import com.boston.OutdoorsApi.mapper.PointOfInterestsMapper;
import com.boston.OutdoorsApi.service.PointOfInterestsService;
import com.boston.OutdoorsApi.service.impl.IndexingService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/point-of-interests")
@RestController
public class PointOfInterestsControllerImpl implements PointOfInterestsController {
    private final PointOfInterestsService pointOfInterestsService;
    private final PointOfInterestsMapper pointOfInterestsMapper;
    private final PointOfInterestsRepository pointOfInterestsRepository;

    @Autowired
    IndexingService indexingService;

    private final EntityManager entityManager;

    public PointOfInterestsControllerImpl(PointOfInterestsService pointOfInterestsService, PointOfInterestsMapper pointOfInterestsMapper,
                                          PointOfInterestsRepository pointOfInterestsRepository, EntityManager entityManager) {
        this.pointOfInterestsService = pointOfInterestsService;
        this.pointOfInterestsMapper = pointOfInterestsMapper;
        this.pointOfInterestsRepository = pointOfInterestsRepository;
        this.entityManager = entityManager;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PointOfInterestsDTO save(@RequestBody PointOfInterestsDTO pointOfInterestsDTO) {
        PointOfInterests pointOfInterests = pointOfInterestsMapper.asEntity(pointOfInterestsDTO);
        return pointOfInterestsMapper.asDTO(pointOfInterestsService.save(pointOfInterests));
    }

    @Override
    @GetMapping("/{id}")
    public PointOfInterestsDTO findById(@PathVariable("id") Long id) {
        PointOfInterests pointOfInterests = pointOfInterestsService.findById(id).orElse(null);
        return pointOfInterestsMapper.asDTO(pointOfInterests);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        pointOfInterestsService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<PointOfInterestsDTO> list() {
        return pointOfInterestsMapper.asDTOList(pointOfInterestsService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<PointOfInterestsDTO> pageQuery(Pageable pageable) {
        Page<PointOfInterests> pointOfInterestsPage = pointOfInterestsService.findAll(pageable);
        List<PointOfInterestsDTO> dtoList = pointOfInterestsPage
                .stream()
                .map(pointOfInterestsMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, pointOfInterestsPage.getTotalElements());
    }


    @Override
    @GetMapping("/bychapterid/{id}")
    public List<PointOfInterestsDTO> pageQuery(@PathVariable("id") Long id) {
        List<PointOfInterests> pointOfInterests = pointOfInterestsRepository.findByChapterId(id);

        List<PointOfInterestsDTO> dtoList = pointOfInterests
                .stream()
                .map(pointOfInterestsMapper::asDTO).collect(Collectors.toList());

        return dtoList;
    }




    @Override
    @PutMapping("/{id}")
    public PointOfInterestsDTO update(@RequestBody PointOfInterestsDTO pointOfInterestsDTO, @PathVariable("id") Long id) {
        PointOfInterests pointOfInterests = pointOfInterestsMapper.asEntity(pointOfInterestsDTO);
        return pointOfInterestsMapper.asDTO(pointOfInterestsService.update(pointOfInterests, id));
    }




    @Override
    @GetMapping("/search/{field}")
    public List<PointOfInterestsDTO> search(String field) throws Exception {
        FullTextEntityManager fullTextEntityManager
                = Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.createIndexer().startAndWait();


        indexingService.initiateIndexing();


        QueryBuilder qb = fullTextEntityManager
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(PointOfInterests.class)
                .overridesForField( "Description", "customanalyzer_query1" )
                .overridesForField( "Title", "customanalyzer_query1" )
                .get();

        Query foodQuery = qb.keyword()
                .onFields("Description","Title")
                .matching(field)
                .createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager
                .createFullTextQuery(foodQuery, PointOfInterests.class);



        //Pageable page = PageRequest.of(offset,pagesize);

//        fullTextQuery.setFirstResult(offset);
//        fullTextQuery.setMaxResults(pagesize);

        //Page<Chapters> PageList= new PageImpl<Chapters>(fullTextQuery.getResultList(), page, fullTextQuery.getResultList().size());


        return pointOfInterestsMapper.asDTOList(fullTextQuery.getResultList());

//        return fullTextQuery.getResultList();
    }
}