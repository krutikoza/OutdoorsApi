package com.boston.outdoors.Models.ViewModels;

import com.boston.outdoors.Models.PointOfInterests;

public class PointOfInterestViewModel {
    private Long pointOfInterestID;
    private Float Longitude;
    private Float Latitude;
    private String ThumbnailDefaultontentURL;
    private String DefaultContentURL;
    private String Description;
    private String Title;

    public Long getPointOfInterestID() {
        return pointOfInterestID;
    }

    public void setPointOfInterestID(Long pointOfInterestID) {
        this.pointOfInterestID = pointOfInterestID;
    }

    public Float getLongitude() {
        return Longitude;
    }

    public void setLongitude(Float longitude) {
        Longitude = longitude;
    }

    public Float getLatitude() {
        return Latitude;
    }

    public void setLatitude(Float latitude) {
        Latitude = latitude;
    }

    public String getThumbnailDefaultontentURL() {
        return ThumbnailDefaultontentURL;
    }

    public void setThumbnailDefaultontentURL(String thumbnailDefaultontentURL) {
        ThumbnailDefaultontentURL = thumbnailDefaultontentURL;
    }

    public String getDefaultContentURL() {
        return DefaultContentURL;
    }

    public void setDefaultContentURL(String defaultContentURL) {
        DefaultContentURL = defaultContentURL;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public PointOfInterestViewModel() {
    }

    public PointOfInterestViewModel(PointOfInterests pointOfInterests) {
        this.pointOfInterestID = pointOfInterests.getId();
        Longitude = pointOfInterests.getLongitude();
        Latitude = pointOfInterests.getLatitude();
        ThumbnailDefaultontentURL = pointOfInterests.getThumbnailDefaultontentURL();
        DefaultContentURL = pointOfInterests.getDefaultContentURL();
        Description = pointOfInterests.getDescription();
        Title = pointOfInterests.getTitle();
    }

    @Override
    public String toString() {
        return "PointOfInterestUIModel{" +
                "pointOfInterestID=" + pointOfInterestID +
                ", Longitude=" + Longitude +
                ", Latitude=" + Latitude +
                ", ThumbnailDefaultontentURL='" + ThumbnailDefaultontentURL + '\'' +
                ", DefaultContentURL='" + DefaultContentURL + '\'' +
                ", Description='" + Description + '\'' +
                ", Title='" + Title + '\'' +
                '}';
    }
}
