package com.boston.outdoors.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PointOfInterestContents
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", columnDefinition = "bigint")
    private Long id;


    @Column(name = "PointOfInterestID", columnDefinition = "bigint")
    private Long PointOfInterestID;

    @Column(name = "Sequence", columnDefinition = "bigint")
    private Long Sequence;

    @Column(name = "ContentType", columnDefinition = "int")
    private Long ContentType;

    @Column(name = "ThumbnailContentURL", columnDefinition = "varchar")
    private String ThumbnailContentURL;

    @Column(name = "ContentURL", columnDefinition = "varchar")
    private String ContentURL;

    @Column(name = "DataModified", columnDefinition = "Timestamp with time zone")
    private Date DataModified;

    @Column(name = "DataCreated", columnDefinition = "Timestamp with time zone")
    private Date DataCreated;




}
