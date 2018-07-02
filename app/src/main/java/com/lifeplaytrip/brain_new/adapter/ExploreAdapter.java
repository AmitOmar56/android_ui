package com.lifeplaytrip.brain_new.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lifeplaytrip.brain_new.R;
import com.lifeplaytrip.brain_new.model.Explore;

import java.util.List;

/**
 * Created by Amit OMar on 3/30/2018.
 */

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.MyViewHolder> {

    private Context mContext;
    private List<Explore> exploreList;

    //declare interface
    private ExploreAdapter.Explore_OnItemClicked onClick;

    //make interface like this
    public interface Explore_OnItemClicked {
        void Explore_onItemClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView exploreTextView;
        private ImageView exploreImageView;
        private RelativeLayout exploreLayout;

        public MyViewHolder(View view) {
            super(view);
            exploreTextView = (TextView) view.findViewById(R.id.exploreTextView);
            exploreImageView = (ImageView) view.findViewById(R.id.exploreImageView);
            exploreLayout = (RelativeLayout) view.findViewById(R.id.exploreLayout);
        }
    }

    public ExploreAdapter(Context mContext, List<Explore> exploreList) {
        this.mContext = mContext;
        this.exploreList = exploreList;
    }

    @Override
    public ExploreAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_explore, parent, false);

        return new ExploreAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ExploreAdapter.MyViewHolder holder, final int position) {

        final Explore explore = exploreList.get(position);
        holder.exploreTextView.setText(explore.getExplore_name());
        Glide.with(mContext).load(explore.getExplore_image()).into(holder.exploreImageView);
        Log.d("category", explore.getExplore_image());
        holder.exploreLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.Explore_onItemClick(position);
            }
        });
    }

    public void setOnClick(ExploreAdapter.Explore_OnItemClicked onClick) {
        this.onClick = onClick;
    }

    @Override
    public int getItemCount() {
        return exploreList.size();
    }

}
