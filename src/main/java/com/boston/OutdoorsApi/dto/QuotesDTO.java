package com.boston.OutdoorsApi.dto;

public class QuotesDTO {

//    private Long id;

    private String quote;
    private String author;

    public QuotesDTO() {
    }


    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "QuotesDTO{" +
                "quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
