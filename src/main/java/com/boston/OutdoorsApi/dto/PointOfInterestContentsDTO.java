package com.boston.OutdoorsApi.dto;

import com.boston.OutdoorsApi.Models.PointOfInterests;

import java.util.Date;
import java.util.List;

public class PointOfInterestContentsDTO{ //extends AbstractDTO<Long> {
    private Long id;
//    private Long PointOfInterestID;
    private Long Sequence;
    private Long ContentType;
    private String ThumbnailContentURL;
    private String ContentURL;
    private Date DataModified;
    private Date DataCreated;

    // private PointOfInterests pointOfInterests;
    private Long pointOfInterestsId;

    public PointOfInterestContentsDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

//    public void setPointOfInterestID(Long PointOfInterestID) {
//        this.PointOfInterestID = PointOfInterestID;
//    }
//
//    public Long getPointOfInterestID() {
//        return this.PointOfInterestID;
//    }

    public void setSequence(Long Sequence) {
        this.Sequence = Sequence;
    }

    public Long getSequence() {
        return this.Sequence;
    }

    public void setContentType(Long ContentType) {
        this.ContentType = ContentType;
    }

    public Long getContentType() {
        return this.ContentType;
    }

    public void setThumbnailContentURL(String ThumbnailContentURL) {
        this.ThumbnailContentURL = ThumbnailContentURL;
    }

    public String getThumbnailContentURL() {
        return this.ThumbnailContentURL;
    }

    public void setContentURL(String ContentURL) {
        this.ContentURL = ContentURL;
    }

    public String getContentURL() {
        return this.ContentURL;
    }

    public void setDataModified(java.util.Date DataModified) {
        this.DataModified = DataModified;
    }

    public java.util.Date getDataModified() {
        return this.DataModified;
    }

    public void setDataCreated(java.util.Date DataCreated) {
        this.DataCreated = DataCreated;
    }

    public java.util.Date getDataCreated() {
        return this.DataCreated;
    }

//    public void setPointOfInterests(PointOfInterests pointOfInterests) {
//        this.pointOfInterests = pointOfInterests;
//    }
//
//    public PointOfInterests getPointOfInterests() {
//        return this.pointOfInterests;
//    }


    public Long getPointOfInterestsId() {
        return pointOfInterestsId;
    }

    public void setPointOfInterestsId(Long pointOfInterestsId) {
        this.pointOfInterestsId = pointOfInterestsId;
    }
}