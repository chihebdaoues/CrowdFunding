package com.example.crowdfunding.crowdfunding.data.network.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Don {
    @SerializedName("somme")
    @Expose
    public Double somme;
    @SerializedName("donneur")
    @Expose
    public User donneur;
    @SerializedName("link")
    @Expose
    public String link;

    @Override
    public String toString() {
        return "Don{" +
                "somme=" + somme +
                ", donneur=" + donneur +
                ", link='" + link + '\'' +
                '}';
    }
}
