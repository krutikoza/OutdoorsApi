package com.boston.OutdoorsApi.dao;

import com.boston.OutdoorsApi.Models.PointOfInterests;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointOfInterestsRepository extends PagingAndSortingRepository<PointOfInterests, Long> {
}