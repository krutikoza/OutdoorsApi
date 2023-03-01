package com.boston.OutdoorsApi.dao;

import com.boston.OutdoorsApi.Models.Chapters;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChaptersRepository extends PagingAndSortingRepository<Chapters, Long> {
    Chapters save(Chapters entity);

//    Object saveAll(List<Chapters> entities);

    void deleteById(Long id);

    Optional<Chapters> findById(Long id);

    List<Chapters> findAll();
}