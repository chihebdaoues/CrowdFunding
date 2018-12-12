package com.example.crowdfunding.crowdfunding.UI.home_screen;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.crowdfunding.crowdfunding.R;
import com.example.crowdfunding.crowdfunding.UI.collecte_details_screen.CollecteDetailsActivity;
import com.example.crowdfunding.crowdfunding.data.network.entities.Collecte;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private List<Collecte> collectes;
    private Context context;


    public RvAdapter(List<Collecte> collectes, Context context) {
        this.collectes = collectes;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.card_collecte, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Collecte collecte = collectes.get(i);
        viewHolder.tvCardCollecteTitle.setText(collecte.title);
        viewHolder.tvCardCollecteDescription.setText(collecte.description.substring(0, collecte.description.length() < 300 ? collecte.description.length() : 300));
        viewHolder.clCardCollecte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CollecteDetailsActivity.class);
                intent.putExtra("collecte", collecte);
                context.startActivity(intent);
            }
        });
        if (collecte.img_src != null) {
            Picasso picasso = new Picasso.Builder(context)
                    .downloader(new OkHttp3Downloader(new OkHttpClient()))
                    .build();
            picasso.load("http://i.imgur.com/DvpvklR.png").into(viewHolder.ivCardCollecte);
        } else {
            viewHolder.ivCardCollecte.setImageResource(R.drawable.ic_money_bag_with_dollar_symbol);
        }
    }

    public void swapData(List<Collecte> collectes) {
        this.collectes = collectes;
    }

    @Override
    public int getItemCount() {
        if (collectes == null)
            return 0;
        return collectes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_card_collecte)
        ImageView ivCardCollecte;
        @BindView(R.id.tv_card_collecte_title)
        TextView tvCardCollecteTitle;
        @BindView(R.id.tv_card_collecte_description)
        TextView tvCardCollecteDescription;
        @BindView(R.id.cl_card_collecte)
        ConstraintLayout clCardCollecte;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
