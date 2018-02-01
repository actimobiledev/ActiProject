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
import com.actiknow.actiproject.model.Chart;
import com.actiknow.actiproject.model.Product;
import com.actiknow.actiproject.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import az.plainpie.PieView;
import az.plainpie.animation.PieAngleAnimation;

public class ChartAdapter extends RecyclerView.Adapter<ChartAdapter.ViewHolder> {
    OnItemClickListener mItemClickListener;

    private Activity activity;
    private List<Chart> chartList = new ArrayList<Chart>();

    public ChartAdapter(Activity activity, List<Chart> chartList) {
        this.activity = activity;
        this.chartList = chartList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.list_item_chart, parent, false);
        return new ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {//        runEnterAnimation (holder.itemView);
        final Chart chart = chartList.get(position);
        holder.tvChartHeading.setText(chart.getChart_title());
        holder.pieView.setPercentageBackgroundColor (activity.getResources ().getColor (R.color.primary));
        holder.pieView.setInnerBackgroundColor (activity.getResources ().getColor (R.color.primary_dark));
        holder.pieView.setMainBackgroundColor(activity.getResources().getColor(R.color.primary_trans));
        holder.pieView.setTextColor (activity.getResources ().getColor (R.color.md_white_1000));
        holder.pieView.setPieInnerPadding(25);
        holder.pieView.setInnerText ("6.2");
        holder.pieView.setPercentageTextSize (Utils.pxFromDp (activity, 8));
        holder.pieView.setPercentage (Float.parseFloat(chart.getRadius()));
        PieAngleAnimation animation = new PieAngleAnimation (holder.pieView);
        animation.setDuration (2000); //This is the duration of the animation in millis
        holder.pieView.startAnimation (animation);
        holder.pieView.setInnerTextVisibility (View.GONE);
        holder.tvPer1.setText(chart.getPercentage());


    }


    @Override
    public int getItemCount() {
        return chartList.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        PieView pieView;
        TextView tvPer1;
        private TextView tvChartHeading;

        ProgressBar progressBar;

        public ViewHolder(View view) {
            super(view);
            tvChartHeading = (TextView) view.findViewById(R.id.tvChartHeading);
            tvPer1 = (TextView) view.findViewById(R.id.tvPer1);
            pieView = (PieView) view.findViewById(R.id.pieView);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


        }
    }
}