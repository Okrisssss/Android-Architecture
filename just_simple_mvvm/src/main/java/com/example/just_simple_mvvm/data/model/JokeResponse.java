package com.example.just_simple_mvvm.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JokeResponse {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private Joke joke;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke value) {
        this.joke = value;
    }
}