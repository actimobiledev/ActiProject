package com.actiknow.actiproject.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.actiknow.actiproject.R;
import com.actiknow.actiproject.adapter.ChartAdapter;
import com.actiknow.actiproject.adapter.ProductAdapter;
import com.actiknow.actiproject.model.Chart;
import com.actiknow.actiproject.model.Product;
import com.actiknow.actiproject.utils.UserDetailsPref;
import com.actiknow.actiproject.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ProjectDetailActivity extends AppCompatActivity {
    UserDetailsPref userDetailsPref;
    CoordinatorLayout clMain;
    ProgressDialog progressDialog;
    ImageView ivNavigation;
    ProductAdapter productAdapter;
    ChartAdapter chartAdapter;
    List<Product> productList = new ArrayList<>();
    List<Chart> chartList = new ArrayList<>();
    RecyclerView rvChart;
    RecyclerView rvProductList;
    TextView tvHeading;
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        initView();
        initData();
        initAdapter();
        initListener();
    }
    private void initListener() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
    private void initView() {
        clMain = (CoordinatorLayout) findViewById(R.id.clMain);
        ivNavigation = (ImageView) findViewById(R.id.ivNavigation);
        rvProductList = (RecyclerView) findViewById(R.id.rv1);
        rvChart = (RecyclerView) findViewById(R.id.rvChart);
        tvHeading = (TextView) findViewById(R.id.tvHeading);
        ivBack = (ImageView) findViewById(R.id.ivNavigation);
    }
    private void initData() {
        userDetailsPref = UserDetailsPref.getInstance();
        progressDialog = new ProgressDialog(this);
        Utils.setTypefaceToAllViews(this, tvHeading);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initAdapter() {
        productList.add(new Product(1, "30XW0912 ", " 6.2", "350 tons"));
        productList.add(new Product(2, "30HXC165E", " 5.8", "150 tons"));
        productList.add(new Product(3, "42CT00320", " 5.4", "150 tons"));
        productList.add(new Product(4, "42CT00320", " 5.1", "150 tons"));
        productList.add(new Product(4, "42CT00320", " 4.2", "150 tons"));

        productAdapter = new ProductAdapter(this, productList);
        rvProductList.setAdapter(productAdapter);
        rvProductList.setHasFixedSize(true);
        rvProductList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvProductList.setItemAnimator(new DefaultItemAnimator());
        // rvProductList.addItemDecoration(new RecyclerViewMargin((int) Utils.pxFromDp(MainActivity.this, 16), (int) Utils.pxFromDp(MainActivity.this, 16), (int) Utils.pxFromDp(MainActivity.this, 16), (int) Utils.pxFromDp(MainActivity.this, 16), 1, 0, RecyclerViewMargin.LAYOUT_MANAGER_LINEAR, RecyclerViewMargin.ORIENTATION_VERTICAL));

        chartList.add(new Chart(1, "Technical Score", "62", "6.2"));
        chartList.add(new Chart(2, "Cost  Score", "73", "7.3"));
        chartList.add(new Chart(3, "Price Diff Score", "35", "3.5"));
        chartList.add(new Chart(4, "Win Rate Score", "48", "4.8"));


        chartAdapter = new ChartAdapter(this, chartList);
        rvChart.setAdapter(chartAdapter);
        rvChart.setHasFixedSize(true);
        rvChart.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        rvChart.setItemAnimator(new DefaultItemAnimator());
        // rvChart.addItemDecoration(new RecyclerViewMargin((int) Utils.pxFromDp(this, 16), (int) Utils.pxFromDp(this, 16), (int) Utils.pxFromDp(this, 16), (int) Utils.pxFromDp(this, 16), 1, 0, RecyclerViewMargin.LAYOUT_MANAGER_LINEAR, RecyclerViewMargin.ORIENTATION_VERTICAL));


    }


}
