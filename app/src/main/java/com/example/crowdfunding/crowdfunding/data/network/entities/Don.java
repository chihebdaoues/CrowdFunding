package com.example.crowdfunding.crowdfunding.data.network.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Don implements Serializable {
    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("somme")
    @Expose
    public double somme;
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
