package com.actiknow.actiproject.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.actiknow.actiproject.R;
import com.actiknow.actiproject.adapter.ProductAdapter;
import com.actiknow.actiproject.fragment.PieChartFragment;
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
    List<Product> productList = new ArrayList<>();
    RecyclerView rvProductList;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    List<String> fragmentList=new ArrayList<>();
    PieChartFragment pieChartFrag;
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


        ivBack.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                finish ();
                overridePendingTransition (R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }




    private void initView() {
        clMain = (CoordinatorLayout) findViewById(R.id.clMain);
        ivNavigation = (ImageView) findViewById(R.id.ivNavigation);
        rvProductList = (RecyclerView) findViewById(R.id.rv1);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tvHeading=(TextView)findViewById(R.id.tvHeading);
        ivBack=(ImageView)findViewById(R.id.ivNavigation);
    }

    private void initData() {
        fragmentList.add("Technical Score");
        fragmentList.add("Cost Score");
        fragmentList.add("Price Diff Score");
        fragmentList.add("Win Rate Score");
        userDetailsPref = UserDetailsPref.getInstance();
        progressDialog = new ProgressDialog(this);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setVisibility(View.GONE);
        setupViewPager(viewPager);

        Utils.setTypefaceToAllViews(this, tvHeading);

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initAdapter() {
        productList.add(new Product(1,"30XW0912 "," 6.2","350 tons"));
        productList.add(new Product(2,"30HXC165E"," 5.8","150 tons"));
        productList.add(new Product(3,"42CT00320"," 5.4","150 tons"));
        productList.add(new Product(4,"42CT00320"," 5.1","150 tons"));
        productList.add(new Product(4,"42CT00320"," 4.2","150 tons"));

        productAdapter = new ProductAdapter(this, productList);
        rvProductList.setAdapter(productAdapter);
        rvProductList.setHasFixedSize(true);
        rvProductList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvProductList.setItemAnimator(new DefaultItemAnimator());
       // rvProductList.addItemDecoration(new RecyclerViewMargin((int) Utils.pxFromDp(MainActivity.this, 16), (int) Utils.pxFromDp(MainActivity.this, 16), (int) Utils.pxFromDp(MainActivity.this, 16), (int) Utils.pxFromDp(MainActivity.this, 16), 1, 0, RecyclerViewMargin.LAYOUT_MANAGER_LINEAR, RecyclerViewMargin.ORIENTATION_VERTICAL));

    }






    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        for (int i=0; i<1;i++){
            adapter.addFragment(new PieChartFragment(), fragmentList.get(i));
        }

        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        pieChartFrag=new PieChartFragment().newInstance(1,25);
                        break;
                    case 1:
                        pieChartFrag=new PieChartFragment().newInstance(2,50);
                        break;
                    case 2:
                        pieChartFrag=new PieChartFragment().newInstance(3,75);
                        break;
                    case 3:
                        pieChartFrag=new PieChartFragment().newInstance(4,40);
                        break;
                    default:
                        pieChartFrag=new PieChartFragment().newInstance(1,25);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 1:
                    pieChartFrag = new PieChartFragment().newInstance(1, 25);
                    break;
                case 2:
                    pieChartFrag = new PieChartFragment().newInstance(2, 50);
                    break;
                case 3:
                    pieChartFrag = new PieChartFragment().newInstance(3, 75);
                    break;
                case 4:
                    pieChartFrag = new PieChartFragment().newInstance(4, 40);
                    break;
                default:
                    pieChartFrag = new PieChartFragment().newInstance(1, 25);
                    break;
            }
             return pieChartFrag;

        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }



}
