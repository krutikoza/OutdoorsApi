package com.boston.outdoors.Models.ViewModels;

import com.boston.outdoors.Models.Chapters;
import com.boston.outdoors.Models.PointOfInterests;

import java.util.List;

public class ChaptersViewModel {

    private Long ChapterID;
    private String Title;
    private String Description;
    private String ThumbnailImageURL;
    private String ImageURL;
    private String DateCreated;
    private List<PointOfInterests> pointOfInterests;


    public Long getChapterID() {
        return ChapterID;
    }

    public void setChapterID(Long chapterID) {
        ChapterID = chapterID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getThumbnailImageURL() {
        return ThumbnailImageURL;
    }

    public void setThumbnailImageURL(String thumbnailImageURL) {
        ThumbnailImageURL = thumbnailImageURL;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(String dateCreated) {
        DateCreated = dateCreated;
    }

    public ChaptersViewModel(String s, String s1) {
    }

//    public List<PointOfInterests> getPointOfInterests() {
//        return pointOfInterests;
//    }
//
//    public void setPointOfInterests(List<PointOfInterests> pointOfInterests) {
//        this.pointOfInterests = pointOfInterests;
//    }

    public ChaptersViewModel(Chapters chapters) {
        setChapterID(chapters.getId());
        setTitle(chapters.getTitle());
        setDescription(chapters.getDescription());
        setThumbnailImageURL(chapters.getThumbnailImageURL());
        setImageURL(chapters.getImageURL());
        setDateCreated("chapters.getDateCreated");
        //setPointOfInterests(null);
    }


    @Override
    public String toString() {
        return "ChaptersUIModel{" +
                "ChapterID=" + ChapterID +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", ThumbnailImageURL='" + ThumbnailImageURL + '\'' +
                ", ImageURL='" + ImageURL + '\'' +
                ", DateCreated='" + DateCreated + '\'' +
                '}';
    }
}
