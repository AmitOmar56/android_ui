package com.lifeplaytrip.brain_new.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lifeplaytrip.brain_new.R;
import com.lifeplaytrip.brain_new.adapter.CategoryAdapter;
import com.lifeplaytrip.brain_new.adapter.CitySearchAdapter;
import com.lifeplaytrip.brain_new.model.Category;
import com.lifeplaytrip.brain_new.model.CitySearch;

import java.util.ArrayList;
import java.util.List;

public class CitySearchActivity extends AppCompatActivity implements CitySearchAdapter.CitySearch_OnItemClicked {

    private RecyclerView citySearch_RecyclerView;
    private CitySearchAdapter adapter;
    private List<CitySearch> citySearchList;
    private CitySearch citySearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_search);
        InitId();
        /*****************(Start) code For Card View*****************/

        citySearchList = new ArrayList<>();
        adapter = new CitySearchAdapter(this, citySearchList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        citySearch_RecyclerView.setLayoutManager(mLayoutManager);
        // categoryRecyclerView.addItemDecoration(new utils.GridSpacingItemDecoration(2, dpToPx(this, 10), true));
        citySearch_RecyclerView.setItemAnimator(new DefaultItemAnimator());
        citySearch_RecyclerView.setAdapter(adapter);
        adapter.setOnClick(this);
        prepareAlbums();
        /*****************(End) code For Card View Vertical*****************/

    }

    private void InitId() {
        citySearch_RecyclerView = (RecyclerView) findViewById(R.id.citySearch_RecyclerView);
    }

    private void prepareAlbums() {


        citySearch = new CitySearch("Mumbai", "1");
        citySearchList.add(citySearch);
        citySearch = new CitySearch("Gurgaon", "1");
        citySearchList.add(citySearch);
        citySearch = new CitySearch("Mumbai", "1");
        citySearchList.add(citySearch);
        citySearch = new CitySearch("Mumbai", "1");
        citySearchList.add(citySearch);
        citySearch = new CitySearch("Gurgaon", "1");
        citySearchList.add(citySearch);
        citySearch = new CitySearch("Mumbai", "1");
        citySearchList.add(citySearch);
        citySearch = new CitySearch("Delhi", "1");
        citySearchList.add(citySearch);
        citySearch = new CitySearch("Delhi", "1");
        citySearchList.add(citySearch);
        citySearch = new CitySearch("Delhi", "1");
        citySearchList.add(citySearch);
        citySearch = new CitySearch("Delhi", "1");
        citySearchList.add(citySearch);
        citySearch = new CitySearch("Delhi", "1");
        citySearchList.add(citySearch);
        citySearch = new CitySearch("Delhi", "1");
        citySearchList.add(citySearch);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void CitySearch_onItemClick(int position) {

    }

    public void citySearchBackButton(View view) {
        finish();
    }
}
