package com.example.contributorspisok;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class GitHubAdapter extends RecyclerView.Adapter<GitHubAdapter.ViewHolder> {
    private final static String PHOTO_URL = "https://avatars.githubusercontent.com/u/";
    private List<User> mFlowers;
    private Context mContext;

    GitHubAdapter(List<User> flowers) {
        this.mFlowers = flowers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        User flower = mFlowers.get(position);
        holder.nameTextView.setText(flower.getLogin());
        holder.categoryTV.setText(flower.getType());
        Picasso.with(mContext)
                .load(PHOTO_URL + flower.getId())
                .resize(200, 150)
                .into(holder.flowerImageView);

    }

    @Override
    public int getItemCount() {
        if (mFlowers == null) {
            return 0;
        }
        return mFlowers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView flowerImageView;
        TextView categoryTV;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            flowerImageView = (ImageView) itemView.findViewById(R.id.itemImageView);
            categoryTV = (TextView) itemView.findViewById(R.id.categoryTextView);
        }
    }
}
