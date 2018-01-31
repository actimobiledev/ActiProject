package com.actiknow.actiproject.activity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.actiknow.actiproject.R;
import com.actiknow.actiproject.fragment.BarChartFragment;
import com.actiknow.actiproject.fragment.PieChartFragment;
import com.actiknow.actiproject.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by l on 30/01/2018.
 */

public class ProductDetailActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    List<String> fragmentList=new ArrayList<>();
    BarChartFragment pieChartFrag;
    CoordinatorLayout clMain;

    private TextView tvWeight;
    private TextView tvProductNumber;
    ImageView ivBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        initView();
        initData();
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
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tvProductNumber = (TextView)findViewById(R.id.tvProductNumber);
        tvWeight = (TextView)findViewById(R.id.tvWeight);
        ivBack=(ImageView)findViewById(R.id.ivNavigation);
    }

    private void initData() {
        Utils.setTypefaceToAllViews(this, tvProductNumber);
        fragmentList.add("Technical Score");
        fragmentList.add("Cost Score");
        fragmentList.add("Price Diff Score");
        fragmentList.add("Win Rate Score");
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);

        tvProductNumber.setText("30XW0912");
        tvWeight.setText("350 tons");


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter2 adapter = new ViewPagerAdapter2(getSupportFragmentManager());
        for (int i=0; i<4;i++){
            adapter.addFragment(new BarChartFragment(), fragmentList.get(i));
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
                        pieChartFrag=new BarChartFragment().newInstance(1,25);
                        break;
                    case 1:
                        pieChartFrag=new BarChartFragment().newInstance(2,50);
                        break;
                    case 2:
                        pieChartFrag=new BarChartFragment().newInstance(3,75);
                        break;
                    case 3:
                        pieChartFrag=new BarChartFragment().newInstance(4,40);
                        break;
                    default:
                        pieChartFrag=new BarChartFragment().newInstance(1,25);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


    class ViewPagerAdapter2 extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter2(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 1:
                    pieChartFrag = new BarChartFragment().newInstance(1, 25);
                    break;
                case 2:
                    pieChartFrag = new BarChartFragment().newInstance(2, 50);
                    break;
                case 3:
                    pieChartFrag = new BarChartFragment().newInstance(3, 75);
                    break;
                case 4:
                    pieChartFrag = new BarChartFragment().newInstance(4, 40);
                    break;
                default:
                    pieChartFrag = new BarChartFragment().newInstance(1, 25);
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
