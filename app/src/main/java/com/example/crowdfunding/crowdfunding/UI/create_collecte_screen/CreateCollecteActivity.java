package com.example.crowdfunding.crowdfunding.UI.create_collecte_screen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.crowdfunding.crowdfunding.R;
import com.example.crowdfunding.crowdfunding.data.Repository;
import com.example.crowdfunding.crowdfunding.data.network.CrowdFundingService;
import com.example.crowdfunding.crowdfunding.data.network.entities.Collecte;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class CreateCollecteActivity extends AppCompatActivity {

    private static final int RC_PHOTO_PICKER = 2;

    @BindView(R.id.ib_create_collecte_img_chose)
    ImageButton ibCreateCollecteImgChose;
    @BindView(R.id.tiet_create_collecte_title)
    TextInputEditText tietCreateCollecteTitle;
    @BindView(R.id.tiet_create_collecte_description)
    TextInputEditText tietCreateCollecteDescription;
    @BindView(R.id.et_create_collecte_target)
    EditText etCreateCollecteTarget;
    @BindView(R.id.btn_create_collecte_valider)
    Button btnCreateCollecteValider;
    @BindView(R.id.til_create_collecte_title)
    TextInputLayout tilCreateCollecteTitle;
    @BindView(R.id.til_create_collecte_description)
    TextInputLayout tilCreateCollecteDescription;

    private Uri img_src;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_collecte);
        ButterKnife.bind(this);
        setTitle("Créer une Collecte");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_PHOTO_PICKER && resultCode == RESULT_OK) {
            img_src = data.getData();
            ibCreateCollecteImgChose.setImageURI(img_src);
        }
    }

    @OnClick({R.id.ib_create_collecte_img_chose, R.id.btn_create_collecte_valider})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_create_collecte_img_chose:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(Intent.createChooser(intent, "Complete action using"), RC_PHOTO_PICKER);
                break;
            case R.id.btn_create_collecte_valider:
                send();
                break;
        }
    }

    public void send() {
        String title = tietCreateCollecteTitle.getText().toString();
        String description = tietCreateCollecteDescription.getText().toString();
        String target = etCreateCollecteTarget.getText().toString();

        Collecte collecte = new Collecte();
        collecte.title = title;
        collecte.description = description;
        collecte.target = Double.parseDouble(target);
        if (this.img_src != null)
            collecte.img_src = this.img_src.toString();

        Repository repository = Repository.getInstance(this.getApplicationContext());
        repository.addCollecte(collecte).observe(this, collecte1 -> {
            Log.d("hey", "" + collecte1);
        });
        finish();
    }

}
