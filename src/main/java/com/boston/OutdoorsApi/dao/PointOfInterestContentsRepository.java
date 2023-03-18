package com.boston.OutdoorsApi.dao;

import com.boston.OutdoorsApi.Models.PointOfInterestContents;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointOfInterestContentsRepository extends PagingAndSortingRepository<PointOfInterestContents, Long> {
    @Query(value = "SELECT * FROM point_of_interest_contents WHERE pointofinterests = :id",nativeQuery = true)
    List<PointOfInterestContents> findByPoiId(Long id);
}