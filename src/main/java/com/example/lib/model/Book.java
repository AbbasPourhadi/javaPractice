package com.example.lib.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    private long id;
    private String title;


    private Genre genre;
   /*
     private Publisher publisher;
    private List<Author> authors;*/


    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "bookIdGenerator", strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
