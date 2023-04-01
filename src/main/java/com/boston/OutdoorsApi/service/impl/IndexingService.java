package com.boston.OutdoorsApi.service.impl;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;

@Service
public class IndexingService {

    private final EntityManager em;

    public IndexingService(EntityManager em) {
        this.em = em;
    }


    public void initiateIndexing() throws InterruptedException {
        FullTextEntityManager fullTextEntityManager =
                Search.getFullTextEntityManager(em);
        fullTextEntityManager.createIndexer().startAndWait();


    }

}
