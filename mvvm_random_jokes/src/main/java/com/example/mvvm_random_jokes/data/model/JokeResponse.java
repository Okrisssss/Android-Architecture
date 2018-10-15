package com.example.mvvm_random_jokes.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JokeResponse {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private List<Joke> joke = null;

    public JokeResponse(String type, List<Joke> joke) {
        this.type = type;
        this.joke = joke;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Joke> getJoke() {
        return joke;
    }

    public void setJoke(List<Joke> joke) {
        this.joke = joke;
    }
}
