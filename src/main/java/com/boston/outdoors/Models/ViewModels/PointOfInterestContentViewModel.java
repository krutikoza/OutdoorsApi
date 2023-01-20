package com.boston.outdoors.Models.ViewModels;

import com.boston.outdoors.Models.PointOfInterestContents;

public class PointOfInterestContentViewModel {
    private Long pointOfInterestContentId;
    private Long Sequence;
    private Long ContentType;
    private String ThumbnailContentURL;
    private String ContentURL;

    public Long getPointOfInterestContentId() {
        return pointOfInterestContentId;
    }

    public void setPointOfInterestContentId(Long pointOfInterestContentId) {
        this.pointOfInterestContentId = pointOfInterestContentId;
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

    public PointOfInterestContentViewModel(PointOfInterestContents pointOfInterestContents) {
        this.pointOfInterestContentId = pointOfInterestContents.getPointOfInterestID();
        Sequence = pointOfInterestContents.getSequence();
        ContentType = pointOfInterestContents.getContentType();
        ThumbnailContentURL = pointOfInterestContents.getThumbnailContentURL();
        ContentURL = pointOfInterestContents.getContentURL();
    }

    @Override
    public String toString() {
        return "PointOfInterestContentUIModel{" +
                "pointOfInterestContentId=" + pointOfInterestContentId +
                ", Sequence=" + Sequence +
                ", ContentType=" + ContentType +
                ", ThumbnailContentURL='" + ThumbnailContentURL + '\'' +
                ", ContentURL='" + ContentURL + '\'' +
                '}';
    }
}
