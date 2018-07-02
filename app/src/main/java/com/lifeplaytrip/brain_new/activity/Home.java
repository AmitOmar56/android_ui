package com.lifeplaytrip.brain_new.activity;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.lifeplaytrip.brain_new.adapter.CategoryAdapter;
import com.lifeplaytrip.brain_new.R;
import com.lifeplaytrip.brain_new.adapter.ExploreAdapter;
import com.lifeplaytrip.brain_new.model.Category;
import com.lifeplaytrip.brain_new.model.Explore;
import com.lifeplaytrip.brain_new.utils.utils;

import java.util.ArrayList;
import java.util.List;

import static com.lifeplaytrip.brain_new.utils.utils.dpToPx;

public class Home extends AppCompatActivity implements CategoryAdapter.Product_OnItemClicked, ExploreAdapter.Explore_OnItemClicked, AppBarLayout.OnOffsetChangedListener {
    private RecyclerView categoryRecyclerView;
    private CategoryAdapter adapter;
    private Category category;
    private List<Category> categoryList;

    private RecyclerView exploreRecyclerView;
    private ExploreAdapter exploreAdapter;
    private List<Explore> exploreList;
    private Explore explore;
    private TextView search_box_editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
//        appBarLayout.setExpanded(true, true);
        appBarLayout.addOnOffsetChangedListener(Home.this);

        Log.d("data->>>", appBarLayout + "");
        InitId();
        /*****************(Start) code For Card View*****************/

        categoryList = new ArrayList<>();
        adapter = new CategoryAdapter(this, categoryList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        categoryRecyclerView.setLayoutManager(mLayoutManager);
        // categoryRecyclerView.addItemDecoration(new utils.GridSpacingItemDecoration(2, dpToPx(this, 10), true));
        categoryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        categoryRecyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager_new = new LinearLayoutManager(this);
        linearLayoutManager_new.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(linearLayoutManager_new);
        adapter.setOnClick(this);

        /*****************(End) code For Card View Vertical*****************/

        exploreList = new ArrayList<>();
        exploreAdapter = new ExploreAdapter(this, exploreList);
        RecyclerView.LayoutManager mLayoutManager_new = new GridLayoutManager(this, 1);
        exploreRecyclerView.setLayoutManager(mLayoutManager_new);
//        exploreRecyclerView.addItemDecoration(new utils.GridSpacingItemDecoration(2, dpToPx(this, 10), true));
        exploreRecyclerView.setItemAnimator(new DefaultItemAnimator());
        exploreRecyclerView.setAdapter(exploreAdapter);
        exploreAdapter.setOnClick(this);
        /*****************(End) code For Card View Vertical*****************/
        prepareAlbums1();
        prepareAlbums2();
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
            Log.d("Fully", "full");
            search_box_editText.setVisibility(View.VISIBLE);
        } else if (verticalOffset == 0) {
            // Fully expanded
            Log.d("Fully", "partial");
        } else {
            // Not fully expanded or collapsed
//            Toast.makeText(this,"clicked_Partially",Toast.LENGTH_LONG).show();
            Log.d("Fully", "end");
            search_box_editText.setVisibility(View.INVISIBLE);

        }
    }

    private void InitId() {
        categoryRecyclerView = (RecyclerView) findViewById(R.id.categoryRecyclerView);
        exploreRecyclerView = (RecyclerView) findViewById(R.id.exploreRecyclerView);
        search_box_editText = (TextView) findViewById(R.id.search_box_editText);
    }

    @Override
    public void Product_onItemClick(int position) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public void Explore_onItemClick(int position) {

    }

    private void prepareAlbums1() {
        String[] images = new String[]{
                "https://static.pexels.com/photos/2396/light-glass-lamp-idea-medium.jpg",
                "https://static.pexels.com/photos/1854/person-woman-hand-relaxing-medium.jpg",
                "https://static.pexels.com/photos/204611/pexels-photo-204611-medium.jpeg",
                "https://static.pexels.com/photos/214487/pexels-photo-214487-medium.jpeg",
                "https://static.pexels.com/photos/168575/pexels-photo-168575-medium.jpeg",
                "https://static.pexels.com/photos/213384/pexels-photo-213384-medium.jpeg",
                "https://static.pexels.com/photos/114907/pexels-photo-114907-medium.jpeg",
                "https://static.pexels.com/photos/169047/pexels-photo-169047-medium.jpeg",
                "https://static.pexels.com/photos/160826/girl-dress-bounce-nature-160826-medium.jpeg",
                "https://static.pexels.com/photos/1702/bow-tie-businessman-fashion-man-medium.jpg",
                "https://static.pexels.com/photos/35188/child-childrens-baby-children-s-medium.jpg",
                "https://static.pexels.com/photos/70845/girl-model-pretty-portrait-70845-medium.jpeg",
                "https://static.pexels.com/photos/26378/pexels-photo-26378-medium.jpg",
                "https://static.pexels.com/photos/193355/pexels-photo-193355-medium.jpeg",
                "https://static.pexels.com/photos/1543/landscape-nature-man-person-medium.jpg"


        };

        category = new Category("Hotel", images[0], "1");
        categoryList.add(category);
        category = new Category("Hotel", images[1], "2");
        categoryList.add(category);
        category = new Category("Hotel", images[2], "3");
        categoryList.add(category);
        category = new Category("Hotel", images[3], "4");
        categoryList.add(category);
        category = new Category("Hotel", images[4], "5");
        categoryList.add(category);
        category = new Category("Hotel", images[5], "6");
        categoryList.add(category);
        category = new Category("Hotel", images[0], "1");
        categoryList.add(category);
        category = new Category("Hotel", images[1], "2");
        categoryList.add(category);
        category = new Category("Hotel", images[2], "3");
        categoryList.add(category);
        category = new Category("Hotel", images[3], "4");
        categoryList.add(category);
        adapter.notifyDataSetChanged();
    }

    private void prepareAlbums2() {
        String[] images = new String[]{
                "https://static.pexels.com/photos/114907/pexels-photo-114907-medium.jpeg",
                "https://static.pexels.com/photos/160826/girl-dress-bounce-nature-160826-medium.jpeg",
                "https://static.pexels.com/photos/1702/bow-tie-businessman-fashion-man-medium.jpg",
                "https://static.pexels.com/photos/35188/child-childrens-baby-children-s-medium.jpg",
                "https://static.pexels.com/photos/70845/girl-model-pretty-portrait-70845-medium.jpeg",
                "https://static.pexels.com/photos/26378/pexels-photo-26378-medium.jpg",
                "https://static.pexels.com/photos/193355/pexels-photo-193355-medium.jpeg",
                "https://static.pexels.com/photos/1543/landscape-nature-man-person-medium.jpg"


        };
        explore = new Explore("Hotel", images[0], "1");
        exploreList.add(explore);
        explore = new Explore("Hotel", images[1], "1");
        exploreList.add(explore);
        explore = new Explore("Hotel", images[2], "1");
        exploreList.add(explore);
        explore = new Explore("Hotel", images[3], "1");
        exploreList.add(explore);
        explore = new Explore("Hotel", images[4], "1");
        exploreList.add(explore);
        explore = new Explore("Hotel", images[5], "1");
        exploreList.add(explore);
        explore = new Explore("Hotel", images[6], "1");
        exploreList.add(explore);
        explore = new Explore("Hotel", images[7], "1");
        exploreList.add(explore);
        adapter.notifyDataSetChanged();
    }

    public void goToCitySearch(View view) {
        startActivity(new Intent(this, CitySearchActivity.class));
    }

    public void goToPlaceSearch(View view) {
        startActivity(new Intent(this, PlaceSearchActivity.class));
    }
}
