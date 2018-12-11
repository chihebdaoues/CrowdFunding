package com.example.crowdfunding.crowdfunding.data.network.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    @SerializedName("img_src")
    @Expose
    public String img_src;
    @SerializedName("last_name")
    @Expose
    public String last_name;
    @SerializedName("first_name")
    @Expose
    public String first_name;
    @SerializedName("mes_collectes")
    @Expose
    public List<Collecte> mes_collectes;
    @SerializedName("mes_dons")
    @Expose
    public List<Don> mes_dons;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("email")
    @Expose
    public String email;

    @Override
    public String toString() {
        return "User{" +
                "img_src='" + img_src + '\'' +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", mes_collectes=" + mes_collectes +
                ", mes_dons=" + mes_dons +
                ", link='" + link + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
