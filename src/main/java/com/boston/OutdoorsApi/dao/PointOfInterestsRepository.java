package com.boston.OutdoorsApi.dao;

import com.boston.OutdoorsApi.Models.PointOfInterests;
import com.boston.OutdoorsApi.dto.PointOfInterestsDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointOfInterestsRepository extends PagingAndSortingRepository<PointOfInterests, Long> {

    @Query(value = "SELECT * FROM pointofinterests WHERE chapters_id = :id ",nativeQuery = true)
    List<PointOfInterests> findByChapterId(@Value("id") Long id);
}