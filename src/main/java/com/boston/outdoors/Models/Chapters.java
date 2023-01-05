package com.boston.outdoors.Models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;

@Entity
public class Chapters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", columnDefinition = "bigint")
    private Long id;


    @Column(name = "ThumbnailImageURL", columnDefinition = "varchar")
    private Float ThumbnailImageURL;

    @Column(name = "ImageURL", columnDefinition = "varchar")
    private Float ImageURL;

    @Column(name = "Description", columnDefinition = "varchar")
    private Float Description;

    @Column(name = "Title", columnDefinition = "varchar")
    private Float Title;

    @Column(name = "DateModified", columnDefinition = "Timestamp with time zone")
    private Date DateModified;

    @Column(name = "DateCreated", columnDefinition = "Timestamp with time zone")
    private Date DateCreated;

    @OneToMany
    @JoinColumn(name = "PointOfInterests")
    private HashSet<PointOfInterests> PointOfInterests;






}
