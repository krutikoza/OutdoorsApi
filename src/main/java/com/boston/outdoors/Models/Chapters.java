package com.boston.outdoors.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Chapters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", columnDefinition = "bigint")
    private Long id;


    @Column(name = "ThumbnailImageURL", columnDefinition = "varchar")
    private String ThumbnailImageURL;

    @Column(name = "ImageURL", columnDefinition = "varchar")
    private String ImageURL;

    @Column(name = "Description", columnDefinition = "varchar")
    private String Description;

    @Column(name = "Title", columnDefinition = "varchar")
    private String Title;

    @Column(name = "DateModified", columnDefinition = "Timestamp with time zone")
    private Date DateModified;

    @Column(name = "DateCreated", columnDefinition = "Timestamp with time zone")
    private Date DateCreated;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Chapters_id")
    @JsonManagedReference
    private Set<PointOfInterests> pointOfInterests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDateModified() {
        return DateModified;
    }

    public void setDateModified(Date dateModified) {
        DateModified = dateModified;
    }

    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        DateCreated = dateCreated;
    }

    public Set<PointOfInterests> getPointOfInterests() {
        return pointOfInterests;
    }

    public void setPointOfInterests(Set<PointOfInterests> pointOfInterests) {
        this.pointOfInterests = pointOfInterests;
    }
}
