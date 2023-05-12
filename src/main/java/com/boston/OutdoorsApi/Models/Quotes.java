package com.boston.OutdoorsApi.Models;

import javax.persistence.*;

@Entity
@Table(name = "quotes")
public class Quotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint")
    private Long id;

    @Column(name = "quote", columnDefinition = "varchar")
    private String quote;

    @Column(name = "author", columnDefinition = "varchar")
    private String author;



    public Quotes() {
    }

    public Quotes(String quote) {
        this.quote = quote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
