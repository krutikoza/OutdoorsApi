package com.boston.outdoors.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;

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

    @ManyToOne
    @JoinColumn(name = "PointOfInterests")
    @JsonBackReference
    private PointOfInterests pointOfInterests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPointOfInterestID() {
        return PointOfInterestID;
    }

    public void setPointOfInterestID(Long pointOfInterestID) {
        PointOfInterestID = pointOfInterestID;
    }

    public Long getSequence() {
        return Sequence;
    }

    public void setSequence(Long sequence) {
        Sequence = sequence;
    }

    public Long getContentType() {
        return ContentType;
    }

    public void setContentType(Long contentType) {
        ContentType = contentType;
    }

    public String getThumbnailContentURL() {
        return ThumbnailContentURL;
    }

    public void setThumbnailContentURL(String thumbnailContentURL) {
        ThumbnailContentURL = thumbnailContentURL;
    }

    public String getContentURL() {
        return ContentURL;
    }

    public void setContentURL(String contentURL) {
        ContentURL = contentURL;
    }

    public Date getDataModified() {
        return DataModified;
    }

    public void setDataModified(Date dataModified) {
        DataModified = dataModified;
    }

    public Date getDataCreated() {
        return DataCreated;
    }

    public void setDataCreated(Date dataCreated) {
        DataCreated = dataCreated;
    }

    public PointOfInterests getPointOfInterests() {
        return pointOfInterests;
    }

    public void setPointOfInterests(PointOfInterests pointOfInterests) {
        this.pointOfInterests = pointOfInterests;
    }
}
