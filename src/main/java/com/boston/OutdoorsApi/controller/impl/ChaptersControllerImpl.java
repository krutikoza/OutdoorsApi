package com.boston.OutdoorsApi.controller.impl;

import com.boston.OutdoorsApi.Models.Chapters;
import com.boston.OutdoorsApi.controller.ChaptersController;
import com.boston.OutdoorsApi.dto.ChaptersDTO;
import com.boston.OutdoorsApi.mapper.ChaptersMapper;
import com.boston.OutdoorsApi.service.ChaptersService;
import com.boston.OutdoorsApi.service.impl.IndexingService;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/chapters")
@RestController
public class ChaptersControllerImpl implements ChaptersController {
    private final ChaptersService chaptersService;
    private final ChaptersMapper chaptersMapper;

    @Autowired
    IndexingService indexingService;

    private final EntityManager entityManager;

    public ChaptersControllerImpl(ChaptersService chaptersService, ChaptersMapper chaptersMapper, EntityManager entityManager) {
        this.chaptersService = chaptersService;
        this.chaptersMapper = chaptersMapper;
        this.entityManager = entityManager;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChaptersDTO save(@RequestBody ChaptersDTO chaptersDTO) {
        Chapters chapters = chaptersMapper.asEntity(chaptersDTO);
        return chaptersMapper.asDTO(chaptersService.save(chapters));
    }

    @Override
    @GetMapping("/{id}")
    public ChaptersDTO findById(@PathVariable("id") Long id) {
        Chapters chapters = chaptersService.findById(id).orElse(null);
        return chaptersMapper.asDTO(chapters);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        chaptersService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<ChaptersDTO> list() {
        return chaptersMapper.asDTOList(chaptersService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<ChaptersDTO> pageQuery(Pageable pageable) {
        Page<Chapters> chaptersPage = chaptersService.findAll(pageable);
        List<ChaptersDTO> dtoList = chaptersPage
                .stream()
                .map(chaptersMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, chaptersPage.getTotalElements());
    }



    @Override
    @PutMapping("/{id}")
    public ChaptersDTO update(@RequestBody ChaptersDTO chaptersDTO, @PathVariable("id") Long id) {
        Chapters chapters = chaptersMapper.asEntity(chaptersDTO);
        return chaptersMapper.asDTO(chaptersService.update(chapters, id));
    }

//    @Override
//    @GetMapping("/chapters/search/{offset}/{pagesize}/{field}")
//    public List<Chapters> search(int offset, int pagesize, String field) throws Exception {

    @Override
    @GetMapping("/search/{field}")
    public List<ChaptersDTO> search(String field) throws Exception {




        FullTextEntityManager fullTextEntityManager
                = Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.createIndexer().startAndWait();


        indexingService.initiateIndexing();


        QueryBuilder qb = fullTextEntityManager
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Chapters.class)
                .overridesForField( "Description", "customanalyzer_query" )
                .overridesForField( "Title", "customanalyzer_query" )
                .get();

        Query foodQuery = qb.keyword()
                .onFields("Description","Title")
                .matching(field)
                .createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager
                .createFullTextQuery(foodQuery, Chapters.class);



        //Pageable page = PageRequest.of(offset,pagesize);

//        fullTextQuery.setFirstResult(offset);
//        fullTextQuery.setMaxResults(pagesize);

        //Page<Chapters> PageList= new PageImpl<Chapters>(fullTextQuery.getResultList(), page, fullTextQuery.getResultList().size());

        return chaptersMapper.asDTOList(fullTextQuery.getResultList());
    }
}