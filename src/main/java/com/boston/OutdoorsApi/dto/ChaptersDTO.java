package com.boston.OutdoorsApi.dto;

import com.boston.OutdoorsApi.Models.PointOfInterests;

import java.util.Date;
import java.util.Set;

public class ChaptersDTO extends AbstractDTO<Long> {
    private Long id;
    private String ThumbnailImageURL;
    private String ImageURL;
    private String Description;
    private String Title;
    private Date DateModified;
    private Date DateCreated;
    private Set<PointOfInterests> pointOfInterests;

    public ChaptersDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setThumbnailImageURL(String ThumbnailImageURL) {
        this.ThumbnailImageURL = ThumbnailImageURL;
    }

    public String getThumbnailImageURL() {
        return this.ThumbnailImageURL;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }

    public String getImageURL() {
        return this.ImageURL;
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

    public void setDateModified(Date DateModified) {
        this.DateModified = DateModified;
    }

    public Date getDateModified() {
        return this.DateModified;
    }

    public void setDateCreated(Date DateCreated) {
        this.DateCreated = DateCreated;
    }

    public Date getDateCreated() {
        return this.DateCreated;
    }

    public void setPointOfInterests(Set<com.boston.OutdoorsApi.Models.PointOfInterests> pointOfInterests) {
        this.pointOfInterests = pointOfInterests;
    }

    public Set<com.boston.OutdoorsApi.Models.PointOfInterests> getPointOfInterests() {
        return this.pointOfInterests;
    }
}