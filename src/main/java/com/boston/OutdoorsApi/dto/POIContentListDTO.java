package com.boston.OutdoorsApi.dto;

import java.util.List;

public class POIContentListDTO {
    private Long id;
    private Long ContentType;
    private String ContentURL;

    public POIContentListDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContentType() {
        return ContentType;
    }

    public void setContentType(Long contentType) {
        ContentType = contentType;
    }

    public String getContentURL() {
        return ContentURL;
    }

    public void setContentURL(String contentURL) {
        ContentURL = contentURL;
    }
}
