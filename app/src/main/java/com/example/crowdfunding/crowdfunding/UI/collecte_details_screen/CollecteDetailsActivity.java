package com.example.crowdfunding.crowdfunding.UI.collecte_details_screen;

import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.crowdfunding.crowdfunding.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollecteDetailsActivity extends AppCompatActivity {

    @BindView(R.id.iv_detail_collecte_toolbar)
    ImageView ivDetailCollecteToolbar;
    @BindView(R.id.tv_details_collecte_description)
    TextView tvDetailsCollecteDescription;
    @BindView(R.id.tv_detail_somme_collected)
    TextView tvDetailSommeCollected;
    @BindView(R.id.pb_detail_somme_collected)
    ProgressBar pbDetailSommeCollected;
    @BindView(R.id.tv_detail_creator_full_name)
    TextView tvDetailCreatorFullName;
    @BindView(R.id.tv_detail_creator_email)
    TextView tvDetailCreatorEmail;
    @BindView(R.id.fb_detail_donate_bottom)
    FloatingActionButton fbDetailDonateBottom;
    @BindView(R.id.fb_detail_donate_top)
    FloatingActionButton fbDetailDonateTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collecte_details);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fbDetailDonateTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDonateDialog();
            }
        });
        fbDetailDonateBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDonateDialog();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            pbDetailSommeCollected.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary, getTheme()), PorterDuff.Mode.SRC_IN);
        }
        setTitle("collecte A");

    }

    private void showDonateDialog() {
        FragmentManager fm = getSupportFragmentManager();
        DonateFragment donateFragment = DonateFragment.newInstance();
        donateFragment.show(fm, "fragment_diag_start");
    }
}
