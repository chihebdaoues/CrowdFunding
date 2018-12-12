package com.example.crowdfunding.crowdfunding.data.network.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Collecte {
    @SerializedName("id")
    @Expose
    public Long id;
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
    public Double target;

    public Collecte(String link, String img_src, String title, String description, User creator, List<Don> don_recu, Double target) {
        this.link = link;
        this.img_src = img_src;
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.don_recu = don_recu;
        this.target = target;
    }

    public Collecte() {

    }

    @Override
    public String toString() {
        return "Collecte{" +
                "id='" + id + '\'' +
                ", link='" + link + '\'' +
                ", img_src='" + img_src + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creator=" + creator +
                ", don_recu=" + don_recu +
                ", target=" + target +
                '}';
    }
}
