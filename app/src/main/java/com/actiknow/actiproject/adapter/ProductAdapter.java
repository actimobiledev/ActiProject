package com.actiknow.actiproject.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.actiknow.actiproject.R;
import com.actiknow.actiproject.activity.ProductDetailActivity;
import com.actiknow.actiproject.model.Jobs;

import com.actiknow.actiproject.model.Product;
import com.actiknow.actiproject.utils.Utils;


import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    OnItemClickListener mItemClickListener;

    private Activity activity;
    private List<Product> productList = new ArrayList<Product>();

    public ProductAdapter(Activity activity, List<Product> productList) {
        this.activity = activity;
        this.productList = productList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.list_item_product_list, parent, false);
        return new ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {//        runEnterAnimation (holder.itemView);
        final Product products = productList.get(position);
        Utils.setTypefaceToAllViews(activity, holder.tvProductNumber);
        holder.tvProductNumber.setText(products.getProduct_number() + " : ");
        holder.tvSpot.setText(products.getSpot());
        holder.tvWeight.setText(products.getWeight());


    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RelativeLayout rlMain;
        private TextView tvSpot;
        private TextView tvWeight;
        private TextView tvProductNumber;

        ProgressBar progressBar;

        public ViewHolder(View view) {
            super(view);
            tvProductNumber = (TextView) view.findViewById(R.id.tvProductNumber);
            tvSpot = (TextView) view.findViewById(R.id.tvSpot);
            tvWeight = (TextView) view.findViewById(R.id.tvWeight);
            rlMain = (RelativeLayout) view.findViewById(R.id.rlMain);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(activity,ProductDetailActivity.class);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            // final Jobs jobDescription = bookingList.get (getLayoutPosition ());
            // activity.overridePendingTransition (R.anim.slide_in_right, R.anim.slide_out_left);
          //  mItemClickListener.onItemClick(v, getLayoutPosition());

        }
    }
}