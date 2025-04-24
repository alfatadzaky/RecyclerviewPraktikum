package com.example.recyclerviewpraktikum;

public class Model {
    private String title;
    private String description;
    private String creator;
    private String date;

    public Model(String title, String description, String creator, String date) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.date = date;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getCreator() { return creator; }
    public String getDate() { return date; }
}


