package com.example.crowdfunding.crowdfunding.UI.home_screen;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.crowdfunding.crowdfunding.R;
import com.example.crowdfunding.crowdfunding.data.network.CrowdFundingService;
import com.example.crowdfunding.crowdfunding.data.network.entities.Collecte;
import com.example.crowdfunding.crowdfunding.data.network.entities.User;

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

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String message) {
//                Timber.i(message);
//            }
//        });
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
//        File cacheFile = new File(this.getCacheDir(), "okhttp_cache");
//        Cache cache = new Cache(cacheFile, 10 * 1000 * 1000);
//        OkHttpClient okClient = new OkHttpClient.Builder()
//                .addInterceptor(interceptor)
//                .cache(cache)
//                .build();
//        CrowdFundingService service = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okClient)
//                .baseUrl("http://10.0.2.2:6543/")
//                .build().create(CrowdFundingService.class);
//        service.getAllCollectes().enqueue(new Callback<List<Collecte>>() {
//            @Override
//            public void onResponse(Call<List<Collecte>> call, Response<List<Collecte>> response) {
//                Log.d("hey", ""+response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<Collecte>> call, Throwable t) {
//                Log.d("hey", ""+t.getMessage());
//            }
//        });
//
//        service.getCollecteById(1).enqueue(new Callback<Collecte>() {
//            @Override
//            public void onResponse(Call<Collecte> call, Response<Collecte> response) {
//                Log.d("hey", ""+response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Collecte> call, Throwable t) {
//                Log.d("hey", ""+t.getMessage());
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
