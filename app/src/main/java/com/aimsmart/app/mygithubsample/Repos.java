package com.aimsmart.app.mygithubsample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repos {
    @SerializedName("name")
    @Expose
    String name = "";

    @SerializedName("description")
    @Expose
    String description = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
