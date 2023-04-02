package com.boston.OutdoorsApi.dto;

public class QuotesDTO {

//    private Long id;

    private String quote;

    public QuotesDTO() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "QuotesDTO{" +
//                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }
}
