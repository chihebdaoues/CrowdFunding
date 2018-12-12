package com.example.crowdfunding.crowdfunding.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.example.crowdfunding.crowdfunding.AppExecutors;
import com.example.crowdfunding.crowdfunding.data.network.CrowdFundingService;
import com.example.crowdfunding.crowdfunding.data.network.entities.Collecte;

import java.io.File;
import java.util.List;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class Repository {
    private static final Object LOCK = new Object();
    private static Repository sInstance;


    private CrowdFundingService service;
    private AppExecutors executors;

    private Repository(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        File cacheFile = new File(context.getCacheDir(), "okhttp_cache");
        Cache cache = new Cache(cacheFile, 10 * 1000 * 1000);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .build();
        service = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okClient)
                .baseUrl("http://10.0.2.2:6543/")
                .build().create(CrowdFundingService.class);
        executors = AppExecutors.getInstance();
    }

    public static Repository getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new Repository(context);
            }
        }
        return sInstance;
    }

    public LiveData<Collecte> addCollecte(Collecte collecte) {
        MutableLiveData<Collecte> data = new MutableLiveData<>();
        executors.networkIO().execute(() -> {
            service.addCollecte(collecte).enqueue(new Callback<Collecte>() {
                @Override
                public void onResponse(Call<Collecte> call, Response<Collecte> response) {
                    Log.d("hey", "" + response.body());
                    data.postValue(response.body());
                }

                @Override
                public void onFailure(Call<Collecte> call, Throwable t) {
                    Log.d("hey", "" + t.getMessage());
                }
            });
        });
        return data;
    }

    public LiveData<Collecte> getCollecteById(long id) {
        MutableLiveData<Collecte> data = new MutableLiveData<>();
        executors.networkIO().execute(() -> {
            service.getCollecteById(id).enqueue(new Callback<Collecte>() {
                @Override
                public void onResponse(Call<Collecte> call, Response<Collecte> response) {
                    Log.d("hey", "" + response.body());
                    data.postValue(response.body());
                }

                @Override
                public void onFailure(Call<Collecte> call, Throwable t) {
                    Log.d("hey", "" + t.getMessage());
                }
            });
        });
        return data;
    }

    public LiveData<List<Collecte>> getAllCollectes() {
        MutableLiveData<List<Collecte>> data = new MutableLiveData<>();
        executors.networkIO().execute(() -> {
            service.getAllCollectes().enqueue(new Callback<List<Collecte>>() {
                @Override
                public void onResponse(Call<List<Collecte>> call, Response<List<Collecte>> response) {
                    Log.d("hey", "" + response.body());
                    data.postValue(response.body());
                }

                @Override
                public void onFailure(Call<List<Collecte>> call, Throwable t) {
                    Log.d("hey", "" + t.getMessage());
                }
            });
        });
        return data;
    }



}
