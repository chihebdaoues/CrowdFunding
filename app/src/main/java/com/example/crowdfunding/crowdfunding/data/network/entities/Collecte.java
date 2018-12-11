package com.example.crowdfunding.crowdfunding.data.network.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Collecte {
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("img_src")
    @Expose
    public String img_src;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("creator")
    @Expose
    public User creator;
    @SerializedName("don_recu")
    @Expose
    public List<Don> don_recu;
    @SerializedName("target")
    @Expose
    public Float target;

    @Override
    public String toString() {
        return "Collecte{" +
                "link='" + link + '\'' +
                ", img_src='" + img_src + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creator=" + creator +
                ", don_recu=" + don_recu +
                ", target=" + target +
                '}';
    }
}
