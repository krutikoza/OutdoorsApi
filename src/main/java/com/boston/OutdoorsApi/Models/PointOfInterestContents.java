package com.boston.OutdoorsApi.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "PointOfInterestContents")
public class PointOfInterestContents
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "bigint")
    private Long id;


//    @Column(name = "pointofinterestid", columnDefinition = "bigint")
//    private Long PointOfInterestID;

    @Column(name = "sequence", columnDefinition = "bigint")
    private Long Sequence;

    @Column(name = "contenttype", columnDefinition = "int")
    private Long ContentType;

    @Column(name = "thumbnailcontenturl", columnDefinition = "varchar")
    private String ThumbnailContentURL;

    @Column(name = "contenturl", columnDefinition = "varchar")
    private String ContentURL;

    @Column(name = "description", columnDefinition = "varchar")
    private String description;

    @UpdateTimestamp
    @Column(name = "datamodified", columnDefinition = "Timestamp with time zone")
    private Date DataModified;

    @CreationTimestamp
    @Column(name = "datacreated", columnDefinition = "Timestamp with time zone")
    private Date DataCreated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pointofinterests")
    @JsonBackReference
    private PointOfInterests pointOfInterests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getPointOfInterestID() {
//        return PointOfInterestID;
//    }
//
//    public void setPointOfInterestID(Long pointOfInterestID) {
//        PointOfInterestID = pointOfInterestID;
//    }

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

    @Override
    public String toString() {
        return "PointOfInterestContents{" +
                "id=" + id +
                ", Sequence=" + Sequence +
                ", ContentType=" + ContentType +
                ", ThumbnailContentURL='" + ThumbnailContentURL + '\'' +
                ", ContentURL='" + ContentURL + '\'' +
                ", description='" + description + '\'' +
                ", DataModified=" + DataModified +
                ", DataCreated=" + DataCreated +
                ", pointOfInterests=" + pointOfInterests +
                '}';
    }
}
