package com.boston.OutdoorsApi.controller.impl;


import com.boston.OutdoorsApi.Models.Chapters;
import com.boston.OutdoorsApi.attic.unchecked.*;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.EntityManager;
import java.util.List;

import java.util.stream.Collectors;

@RequestMapping("/api/chapters")
@RestController
public class ChaptersControllerImpl implements ChaptersController {
    private final ChaptersService chaptersService;
    private final ChaptersMapper chaptersMapper;

    Logger logger = LoggerFactory.getLogger(ChaptersControllerImpl.class);

    @Autowired
    IndexingService indexingService;

    private final EntityManager entityManager;

    public ChaptersControllerImpl(ChaptersService chaptersService, ChaptersMapper chaptersMapper, EntityManager entityManager) {
        this.chaptersService = chaptersService;
        this.chaptersMapper = chaptersMapper;
        this.entityManager = entityManager;
    }

    @ApiIgnore
    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChaptersDTO save(@RequestBody ChaptersDTO chaptersDTO) throws Exception {
        logger.info("Api to Save chapter called");
        Chapters chapters;
        try {

            chapters = chaptersMapper.asEntity(chaptersDTO);
            logger.info("ChapterDTO converted to Chapter class");
        }catch (Exception ex){
            logger.error("Failed to map ChaptersDTO to Chapters");
            throw new MappingFailedException("Mapping ChaptersDTO to Chapters failed");
        }
        try{
            logger.info("Saving chapter");
            return chaptersMapper.asDTO(chaptersService.save(chapters));

        }catch (Exception ex){
            logger.error("Failed to save chapter");
            throw new SaveFailedException("Failed to save chapters");
        }

    }

    @ApiIgnore
    @Override
    @GetMapping("/{id}")
    public ChaptersDTO findById(@PathVariable("id") Long id) throws NotFoundException  {

        logger.info("Find chapter by id api called");

        Chapters chapters;


        chapters = chaptersService.findById(id).orElse(null);
        if(chapters == null){
            logger.warn("No chapters with id: "+ id+ " found");
            throw new NotFoundException("Chapter with id: "+ id + " Not Found");
        }

        try{
            logger.info("Returning found chapter");
            return chaptersMapper.asDTO(chapters);
        }catch(Exception ex){
            logger.error("Mapping failed while returning found chapter");
            throw new MappingFailedException("Failed to map chapters to chaptersDTO");
        }
    }
    @ApiIgnore
    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception{
        try{
            logger.info("Deleting chapter");
            chaptersService.deleteById(id);
        }catch(Exception ex) {
            logger.warn("Failed to delete chapter with id: "+ id);
            throw new DeleteFailedException("Failed to delete chapter with id: "+ id);
        }
    }

    @Override
    @GetMapping
    public List<ChaptersDTO> list() throws Exception{
        logger.info("Api to get list of Chapters called");

        List<Chapters> chaptersList = chaptersService.findAll();

        if(chaptersList.isEmpty()){
            logger.warn("No chapters found");
            throw new NotFoundException("No chapters found");
        }

        try{
            logger.info("Returning list of chapters");
            return chaptersMapper.asDTOList(chaptersList);
        }catch(Exception ex){
            logger.error("Failed to map chapters list to chapters list DTO");
            throw new MappingFailedException("Failed to map chapters list to chapters list DTO");
        }
    }

    @ApiIgnore
    @Override
    @GetMapping("/page-query")
    public Page<ChaptersDTO> pageQuery(Pageable pageable) throws Exception{
        logger.info("Api to get paginated chapters called");

        Page<Chapters> chaptersPage = chaptersService.findAll(pageable);

        if(chaptersPage.isEmpty()){
            logger.warn("No paginated chapters data found");
            throw new NotFoundException("No chapters found");
        }

        try{
            logger.info("Converting page of chapters to ChaptersDTO list");
            List<ChaptersDTO> dtoList = chaptersPage
                    .stream()
                    .map(chaptersMapper::asDTO).collect(Collectors.toList());
            return new PageImpl<>(dtoList, pageable, chaptersPage.getTotalElements());

        }catch(Exception ex){
            logger.error("Failed to map chapters page list to chapters page DTO list ");
            throw new MappingFailedException("Failed to map chapters page list to chapters page DTO list");
        }

    }


    @ApiIgnore
    @Override
    @PutMapping("/{id}")
    public ChaptersDTO update(@RequestBody ChaptersDTO chaptersDTO, @PathVariable("id") Long id) throws Exception{

        logger.info("Api to update chapter called");

        Chapters chapters;

        logger.info("Updating chapter with id: "+ id);
        chapters = chaptersMapper.asEntity(chaptersDTO);

        if(chaptersService.update(chapters, id) == null){
            throw new SaveFailedException("Failed to update chapter with id: "+ id + ", Chapter not found.");
        }

        try{
            return chaptersMapper.asDTO(chapters);
        }catch(Exception ex){
            logger.error("Failed to map chapters to chaptersDTO");
            throw new MappingFailedException(ex.getMessage());
        }

    }

//    @Override
//    @GetMapping("/chapters/search/{offset}/{pagesize}/{field}")
//    public List<Chapters> search(int offset, int pagesize, String field) throws Exception {

    @Override
    @GetMapping("/search/{field}")
    public List<ChaptersDTO> search(String field) throws Exception {


            FullTextEntityManager fullTextEntityManager;
            FullTextQuery fullTextQuery;

            try{
                fullTextEntityManager
                        = Search.getFullTextEntityManager(entityManager);
                fullTextEntityManager.createIndexer().startAndWait();

                indexingService.initiateIndexing();
            }catch(Exception ex){
                throw new HibernateSearchFailedException("Hibernate search indexing failed for the field: " + field);
            }


            try{
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

                fullTextQuery = fullTextEntityManager
                        .createFullTextQuery(foodQuery, Chapters.class);
            }catch(Exception ex){
                throw new HibernateSearchFailedException("Hibernate search query failed for the field: " + field);
            }


            if(fullTextQuery.getResultList().isEmpty()){
                throw new NotFoundException("No result found for field: "+ field);
            }

            // Pageable page = PageRequest.of(offset,pagesize);

            // fullTextQuery.setFirstResult(offset);
            // fullTextQuery.setMaxResults(pagesize);

            // Page<Chapters> PageList= new PageImpl<Chapters>(fullTextQuery.getResultList(), page, fullTextQuery.getResultList().size());

            return chaptersMapper.asDTOList(fullTextQuery.getResultList());


    }
}