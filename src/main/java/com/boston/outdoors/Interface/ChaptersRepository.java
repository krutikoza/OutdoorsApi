package com.boston.outdoors.Interface;

import com.boston.outdoors.Controller.Controller;
import com.boston.outdoors.Models.Chapters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChaptersRepository extends JpaRepository<Chapters, Long> {
}
