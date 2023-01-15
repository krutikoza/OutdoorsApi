package com.boston.outdoors.Interface;

import com.boston.outdoors.Models.PointOfInterests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PointOfInterestsRepository extends JpaRepository<PointOfInterests, Long> {
    @Query(value = "SELECT * FROM point_of_interests WHERE chapters_id = :id", nativeQuery = true)
    List<PointOfInterests> findAllByChaptersId(@Param("id") Long id);
}
