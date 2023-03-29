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

    @Override
    public String toString() {
        return "Quotes{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }
}
