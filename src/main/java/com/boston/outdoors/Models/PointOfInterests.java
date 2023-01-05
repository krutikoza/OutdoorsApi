package com.boston.outdoors.Models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class PointOfInterests {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", columnDefinition = "bigint")
    private Long id;


    @Column(name = "Longitude", columnDefinition = "float")
    private Float Longitude;

    @Column(name = "Latitude", columnDefinition = "float")
    private Float Latitude;

    @Column(name = "ThumbnailDefaultontentURL", columnDefinition = "varchar")
    private Float ThumbnailDefaultontentURL;

    @Column(name = "DefaultContentURL", columnDefinition = "varchar")
    private Float DefaultContentURL;

    @Column(name = "Description", columnDefinition = "varchar")
    private Float Description;

    @Column(name = "Title", columnDefinition = "varchar")
    private Float Title;

    @Column(name = "DateModified", columnDefinition = "Timestamp with time zone")
    private Date DateModified;

    @Column(name = "DateCreated", columnDefinition = "Timestamp with time zone")
    private Date DateCreated;


    @OneToMany
    @JoinColumn(name = "PointOfInterestContents")
    private Set<PointOfInterestContents> PointOfInterestContents;
}
