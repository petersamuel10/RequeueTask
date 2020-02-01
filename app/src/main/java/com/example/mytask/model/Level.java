package com.example.mytask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Level {
    @SerializedName("level")
    @Expose
    Integer id;

    public Level(Integer i){
        this.id = i;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
