package com.example.crowdfunding.crowdfunding.UI.home_screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.crowdfunding.crowdfunding.R;
import com.example.crowdfunding.crowdfunding.UI.create_collecte_screen.CreateCollecteActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.context = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CreateCollecteActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        rvCollectesHolder.setHasFixedSize(true);

        // use a linear layout manager
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
//        rvCollectesHolder.setLayoutManager(mLayoutManager);

//         specify an adapter (see also next example)
//        RvAdapter adapter = new RvAdapter(null);
//        rvCollectesHolder.setAdapter(adapter);

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
