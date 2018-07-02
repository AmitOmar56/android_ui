package com.lifeplaytrip.brain_new.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.lifeplaytrip.brain_new.R;
import com.lifeplaytrip.brain_new.adapter.CitySearchAdapter;
import com.lifeplaytrip.brain_new.adapter.PlaceSearchAdapter;
import com.lifeplaytrip.brain_new.model.CitySearch;
import com.lifeplaytrip.brain_new.model.PlaceSearch;

import java.util.ArrayList;
import java.util.List;

public class PlaceSearchActivity extends AppCompatActivity implements PlaceSearchAdapter.CitySearch_OnItemClicked {

    private RecyclerView placeSearch_RecyclerView;
    private PlaceSearchAdapter adapter;
    private List<PlaceSearch> placeSearchList;
    private PlaceSearch placeSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_search);
        InitId();
        /*****************(Start) code For Card View*****************/

        placeSearchList = new ArrayList<>();
        adapter = new PlaceSearchAdapter(this, placeSearchList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        placeSearch_RecyclerView.setLayoutManager(mLayoutManager);
        // categoryRecyclerView.addItemDecoration(new utils.GridSpacingItemDecoration(2, dpToPx(this, 10), true));
        placeSearch_RecyclerView.setItemAnimator(new DefaultItemAnimator());
        placeSearch_RecyclerView.setAdapter(adapter);
        adapter.setOnClick(this);
        prepareAlbums();
        /*****************(End) code For Card View Vertical*****************/

    }

    private void InitId() {
        placeSearch_RecyclerView = (RecyclerView) findViewById(R.id.placeSearch_RecyclerView);
    }

    private void prepareAlbums() {

        placeSearch = new PlaceSearch("RedFort", "Delhi", "33.08 Km", "1");
        placeSearchList.add(placeSearch);
        placeSearch = new PlaceSearch("RedFort", "Delhi", "33.08 Km", "1");
        placeSearchList.add(placeSearch);
        placeSearch = new PlaceSearch("RedFort", "Delhi", "33.08 Km", "1");
        placeSearchList.add(placeSearch);
        placeSearch = new PlaceSearch("RedFort", "Delhi", "33.08 Km", "1");
        placeSearchList.add(placeSearch);
        placeSearch = new PlaceSearch("RedFort", "Delhi", "33.08 Km", "1");
        placeSearchList.add(placeSearch);
        placeSearch = new PlaceSearch("RedFort", "Delhi", "33.08 Km", "1");
        placeSearchList.add(placeSearch);
        placeSearch = new PlaceSearch("RedFort", "Delhi", "33.08 Km", "1");
        placeSearchList.add(placeSearch);
        placeSearch = new PlaceSearch("RedFort", "Delhi", "33.08 Km", "1");
        placeSearchList.add(placeSearch);
        placeSearch = new PlaceSearch("RedFort", "Delhi", "33.08 Km", "1");
        placeSearchList.add(placeSearch);


        adapter.notifyDataSetChanged();
    }

    @Override
    public void CitySearch_onItemClick(int position) {
        Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show();
    }

    public void placeSearchBackButton(View view) {
        finish();
    }
}
