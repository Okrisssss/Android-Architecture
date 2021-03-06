package com.eparpalac.mvc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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