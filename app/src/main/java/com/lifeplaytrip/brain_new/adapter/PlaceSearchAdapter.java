package com.lifeplaytrip.brain_new.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lifeplaytrip.brain_new.R;
import com.lifeplaytrip.brain_new.model.PlaceSearch;

import java.util.List;

/**
 * Created by LifePlayTrip on 4/3/2018.
 */

public class PlaceSearchAdapter extends RecyclerView.Adapter<PlaceSearchAdapter.MyViewHolder> {

    private Context mContext;
    private List<PlaceSearch> placeSearchList;

    //declare interface
    private PlaceSearchAdapter.CitySearch_OnItemClicked onClick;

    //make interface like this
    public interface CitySearch_OnItemClicked {
        void CitySearch_onItemClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView placeSearch_PlaceName, placeSearch_CityName, placeSearch_distance;
        private RelativeLayout placeSearch_RelativeLayout;

        public MyViewHolder(View view) {
            super(view);
            placeSearch_PlaceName = (TextView) view.findViewById(R.id.placeSearch_PlaceName);
            placeSearch_CityName = (TextView) view.findViewById(R.id.placeSearch_CityName);
            placeSearch_distance = (TextView) view.findViewById(R.id.placeSearch_distance);
            placeSearch_RelativeLayout = (RelativeLayout) view.findViewById(R.id.placeSearch_RelativeLayout);
        }
    }

    public PlaceSearchAdapter(Context mContext, List<PlaceSearch> placeSearchList) {
        this.mContext = mContext;
        this.placeSearchList = placeSearchList;
    }

    @Override
    public PlaceSearchAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_placesearch, parent, false);

        return new PlaceSearchAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PlaceSearchAdapter.MyViewHolder holder, final int position) {

        final PlaceSearch placeSearch = placeSearchList.get(position);
        holder.placeSearch_CityName.setText(placeSearch.getCityName());
        holder.placeSearch_PlaceName.setText(placeSearch.getPlaceName());
        holder.placeSearch_distance.setText(placeSearch.getDistance());
        Log.d("city_name", placeSearch.getCityName() + "");
        holder.placeSearch_RelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.CitySearch_onItemClick(position);
            }
        });
    }

    public void setOnClick(PlaceSearchAdapter.CitySearch_OnItemClicked onClick) {
        this.onClick = onClick;
    }

    @Override
    public int getItemCount() {
        return placeSearchList.size();
    }
}
