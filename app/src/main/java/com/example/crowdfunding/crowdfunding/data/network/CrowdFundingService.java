package com.example.crowdfunding.crowdfunding.data.network;

import com.example.crowdfunding.crowdfunding.data.network.entities.Collecte;
import com.example.crowdfunding.crowdfunding.data.network.entities.Don;
import com.example.crowdfunding.crowdfunding.data.network.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CrowdFundingService {
    @GET("collecte")
    Call<List<Collecte>> getAllCollectes();

    @GET("collecte/{collecte_id}")
    Call<Collecte> getCollecteById(@Path("collecte_id") long collecte_id);

    @GET("collecte/{collecte_id}/don")
    Call<List<Don>> getDonByCollectId(@Path("collecte_id") long collecte_id);


    @GET("user/{user_id}")
    Call<User> getUserById(@Path("user_id") long user_id);

}
