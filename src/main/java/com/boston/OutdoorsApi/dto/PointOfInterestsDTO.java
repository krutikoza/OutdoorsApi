package com.boston.OutdoorsApi.dto;

import com.boston.OutdoorsApi.Models.Chapters;
import com.boston.OutdoorsApi.Models.PointOfInterestContents;

import java.util.Date;
import java.util.Set;

public class PointOfInterestsDTO{ // extends AbstractDTO<Long> {
    private Long id;
    private Float Longitude;
    private Float Latitude;
    private String ThumbnailDefaultontentURL;
    private String DefaultContentURL;
    private String Description;
    private String Title;
    private Date DateModified;
    private Date DateCreated;

    private Chapters chapters;
//    private Set<PointOfInterestContents> pointOfInterestContents;

    public PointOfInterestsDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setLongitude(Float Longitude) {
        this.Longitude = Longitude;
    }

    public Float getLongitude() {
        return this.Longitude;
    }

    public void setLatitude(Float Latitude) {
        this.Latitude = Latitude;
    }

    public Float getLatitude() {
        return this.Latitude;
    }

    public void setThumbnailDefaultontentURL(String ThumbnailDefaultontentURL) {
        this.ThumbnailDefaultontentURL = ThumbnailDefaultontentURL;
    }

    public String getThumbnailDefaultontentURL() {
        return this.ThumbnailDefaultontentURL;
    }

    public void setDefaultContentURL(String DefaultContentURL) {
        this.DefaultContentURL = DefaultContentURL;
    }

    public String getDefaultContentURL() {
        return this.DefaultContentURL;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setDateModified(java.util.Date DateModified) {
        this.DateModified = DateModified;
    }

    public java.util.Date getDateModified() {
        return this.DateModified;
    }

    public void setDateCreated(java.util.Date DateCreated) {
        this.DateCreated = DateCreated;
    }

    public java.util.Date getDateCreated() {
        return this.DateCreated;
    }

    public void setChapters(Chapters chapters) {
        this.chapters = chapters;
    }

    public Chapters getChapters() {
        return this.chapters;
    }

//    public void setPointOfInterestContents(java.util.Set<com.boston.OutdoorsApi.Models.PointOfInterestContents> pointOfInterestContents) {
//        this.pointOfInterestContents = pointOfInterestContents;
//    }
//
//    public java.util.Set<com.boston.OutdoorsApi.Models.PointOfInterestContents> getPointOfInterestContents() {
//        return this.pointOfInterestContents;
//    }
}