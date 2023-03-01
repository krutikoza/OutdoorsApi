package com.boston.OutdoorsApi.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "PointOfInterests")
public class PointOfInterests {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", columnDefinition = "bigint")
    private Long id;


    @Column(name = "Longitude", columnDefinition = "float")
    private Float Longitude;

    @Column(name = "Latitude", columnDefinition = "float")
    private Float Latitude;

    @Column(name = "ThumbnailDefaultontentURL", columnDefinition = "varchar")
    private String ThumbnailDefaultontentURL;

    @Column(name = "DefaultContentURL", columnDefinition = "varchar")
    private String DefaultContentURL;

    @Column(name = "Description", columnDefinition = "varchar")
    private String Description;

    @Column(name = "Title", columnDefinition = "varchar")
    private String Title;

    @Column(name = "DateModified", columnDefinition = "Timestamp with time zone")
    private Date DateModified;

    @Column(name = "DateCreated", columnDefinition = "Timestamp with time zone")
    private Date DateCreated;


    @ManyToOne
    @JoinColumn(name = "Chapters")
    @JsonBackReference
    private Chapters chapters;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "PointOfInterests")
    @JsonManagedReference
    private Set<PointOfInterestContents> pointOfInterestContents;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Chapters getChapters() {
        return chapters;
    }

    public void setChapters(Chapters chapters) {
        this.chapters = chapters;
    }

    public Set<PointOfInterestContents> getPointOfInterestContents() {
        return pointOfInterestContents;
    }

    public void setPointOfInterestContents(Set<PointOfInterestContents> pointOfInterestContents) {
        this.pointOfInterestContents = pointOfInterestContents;
    }
}
