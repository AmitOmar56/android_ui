package com.lifeplaytrip.brain_new.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lifeplaytrip.brain_new.R;
import com.lifeplaytrip.brain_new.model.CitySearch;

import java.util.List;

/**
 * Created by LifePlayTrip on 4/2/2018.
 */

public class CitySearchAdapter extends RecyclerView.Adapter<CitySearchAdapter.MyViewHolder> {

    private Context mContext;
    private List<CitySearch> citySearchList;

    //declare interface
    private CitySearchAdapter.CitySearch_OnItemClicked onClick;

    //make interface like this
    public interface CitySearch_OnItemClicked {
        void CitySearch_onItemClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView citySearch_TextView;
        private RelativeLayout citySearch_LinearLayout;

        public MyViewHolder(View view) {
            super(view);
            citySearch_TextView = (TextView) view.findViewById(R.id.citySearch_TextView);
            citySearch_LinearLayout = (RelativeLayout) view.findViewById(R.id.citySearch_LinearLayout);
        }
    }

    public CitySearchAdapter(Context mContext, List<CitySearch> citySearchList) {
        this.mContext = mContext;
        this.citySearchList = citySearchList;
    }

    @Override
    public CitySearchAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_citysearch, parent, false);

        return new CitySearchAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CitySearchAdapter.MyViewHolder holder, final int position) {

        final CitySearch citySearch = citySearchList.get(position);
        holder.citySearch_TextView.setText(citySearch.getCityName());
        Log.d("city_name", citySearch.getCityName() + "");
        holder.citySearch_LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.CitySearch_onItemClick(position);
            }
        });
    }

    public void setOnClick(CitySearchAdapter.CitySearch_OnItemClicked onClick) {
        this.onClick = onClick;
    }

    @Override
    public int getItemCount() {
        return citySearchList.size();
    }
}
