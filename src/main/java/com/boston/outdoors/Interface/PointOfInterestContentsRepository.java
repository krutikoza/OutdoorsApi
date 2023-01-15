package com.boston.outdoors.Interface;

import com.boston.outdoors.Models.PointOfInterestContents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PointOfInterestContentsRepository extends JpaRepository<PointOfInterestContents, Long> {

    @Query(value = "SELECT * FROM point_of_interest_contents where point_of_interests = :id", nativeQuery = true)
    List<PointOfInterestContents> findByPointOfInterestsId(@Param("id") Long id);
}
