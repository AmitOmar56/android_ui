package com.lifeplaytrip.brain_new.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lifeplaytrip.brain_new.R;
import com.lifeplaytrip.brain_new.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context mContext;
    private List<Category> categoryList;

    //declare interface
    private CategoryAdapter.Product_OnItemClicked onClick;

    //make interface like this
    public interface Product_OnItemClicked {
        void Product_onItemClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView categoryTextView;
        private ImageView categoryImageView;
        private CardView card_view;

        public MyViewHolder(View view) {
            super(view);
            categoryTextView = (TextView) view.findViewById(R.id.categoryTextView);
            categoryImageView = (ImageView) view.findViewById(R.id.categoryImageView);
            card_view = (CardView) view.findViewById(R.id.card_view);
        }
    }

    public CategoryAdapter(Context mContext, List<Category> categoryList) {
        this.mContext = mContext;
        this.categoryList = categoryList;
    }

    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cartview_catogary, parent, false);

        return new CategoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CategoryAdapter.MyViewHolder holder, final int position) {

        final Category category = categoryList.get(position);
        holder.categoryTextView.setText(category.getCategory_name());
        Glide.with(mContext).load(category.getCategory_image()).into(holder.categoryImageView);
        Log.d("category", category.getCategory_image());
        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.Product_onItemClick(position);
            }
        });
    }

    public void setOnClick(CategoryAdapter.Product_OnItemClicked onClick) {
        this.onClick = onClick;
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

}

