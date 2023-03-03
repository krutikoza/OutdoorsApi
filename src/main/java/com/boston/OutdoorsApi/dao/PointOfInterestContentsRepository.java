package com.boston.OutdoorsApi.dao;

import com.boston.OutdoorsApi.Models.PointOfInterestContents;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointOfInterestContentsRepository extends PagingAndSortingRepository<PointOfInterestContents, Long> {
}