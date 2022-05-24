package com.spring.AnimeList.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AnimeTitle {
    private int id;
    private String name;
    private List<String> genre;
    private String type;
    private int episodes;
    private float rating;
    private long members;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = Arrays.asList(genre.split("\\s*,\\s*"));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public long getMembers() {
        return members;
    }

    public void setMembers(long members) {
        this.members = members;
    }

}

