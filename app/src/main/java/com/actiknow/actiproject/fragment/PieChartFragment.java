package com.actiknow.actiproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actiknow.actiproject.R;
import com.actiknow.actiproject.utils.Utils;

import az.plainpie.PieView;
import az.plainpie.animation.PieAngleAnimation;


public class PieChartFragment extends Fragment {

    public static int PERMISSION_REQUEST_CODE = 1;
    PieView pieView;
    PieView pieView2;
    PieView pieView3;
    PieView pieView4;
    static double percentage=0;
    int type=0;
    TextView tvPer1;
    TextView tvPer2;
    TextView tvPer3;
    TextView tvPer4;

    public PieChartFragment newInstance(int type, double value) {
        PieChartFragment fragment = new PieChartFragment();
        Log.e ("Candidate2", "123"+type);
        Log.e ("value2", "12345"+value);
        percentage=value;
        Bundle args = new Bundle ();
        args.putInt ("type", type);
        args.putDouble ("value", value);
        fragment.setArguments (args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chart, container, false);
        initView(rootView);
        initBundle();
        initData();
        setPieChartValue();
        return rootView;
    }

    private void setPieChartValue() {
        pieView.setPercentageBackgroundColor (getResources ().getColor (R.color.primary));
        pieView.setInnerBackgroundColor (getResources ().getColor (R.color.primary_dark));
        pieView.setMainBackgroundColor(getResources().getColor(R.color.primary_trans));
        pieView.setTextColor (getResources ().getColor (R.color.md_white_1000));
        pieView.setPieInnerPadding(25);
        pieView.setInnerText ("6.2");
        pieView.setPercentageTextSize (Utils.pxFromDp (getActivity(), 8));
        pieView.setPercentage ((float) 62);
        PieAngleAnimation animation = new PieAngleAnimation (pieView);
        animation.setDuration (2000); //This is the duration of the animation in millis
        pieView.startAnimation (animation);
        pieView.setInnerTextVisibility (View.GONE);
        tvPer1.setText("6.2");





        pieView2.setPercentageBackgroundColor (getResources ().getColor (R.color.primary));
        pieView2.setInnerBackgroundColor (getResources ().getColor (R.color.primary_dark));
        pieView2.setMainBackgroundColor(getResources().getColor(R.color.primary_trans));
        pieView2.setTextColor (getResources ().getColor (R.color.md_white_1000));
        pieView2.setPieInnerPadding(25);
        pieView2.setInnerText ("4.0");
        pieView2.setPercentageTextSize (Utils.pxFromDp (getActivity(), 8));
        pieView2.setPercentage ((float) 73);
        PieAngleAnimation animation2 = new PieAngleAnimation (pieView2);
        animation2.setDuration (2000); //This is the duration of the animation in millis
        pieView2.startAnimation (animation2);
        pieView2.setInnerTextVisibility (View.GONE);
        tvPer2.setText("7.3");




        pieView3.setPercentageBackgroundColor (getResources ().getColor (R.color.primary));
        pieView3.setInnerBackgroundColor (getResources ().getColor (R.color.primary_dark));
        pieView3.setMainBackgroundColor(getResources().getColor(R.color.primary_trans));
        pieView3.setTextColor (getResources ().getColor (R.color.md_white_1000));
        pieView3.setPieInnerPadding(25);
        pieView3.setInnerText ("7.3");
        pieView3.setPercentageTextSize (Utils.pxFromDp (getActivity(), 8));
        pieView3.setPercentage ((float) 35);
        PieAngleAnimation animation3 = new PieAngleAnimation (pieView3);
        animation3.setDuration (2000); //This is the duration of the animation in millis
        pieView3.startAnimation (animation3);
        pieView3.setInnerTextVisibility (View.GONE);
        tvPer3.setText("3.5");




        pieView4.setPercentageBackgroundColor (getResources ().getColor (R.color.primary));
        pieView4.setInnerBackgroundColor (getResources ().getColor (R.color.primary_dark));
        pieView4.setMainBackgroundColor(getResources().getColor(R.color.primary_trans));
        pieView4.setTextColor (getResources ().getColor (R.color.md_white_1000));
        pieView4.setPieInnerPadding(25);
        pieView4.setInnerText ("4.8");
        pieView4.setPercentageTextSize (Utils.pxFromDp (getActivity(), 8));
        pieView4.setPercentage ((float) 48);
        PieAngleAnimation animation4 = new PieAngleAnimation (pieView4);
        animation4.setDuration (2000); //This is the duration of the animation in millis
        pieView4.startAnimation (animation4);
        pieView4.setInnerTextVisibility (View.GONE);
        tvPer4.setText("4.8");

    }


    private void initView(View rootView) {
        pieView = (PieView) rootView.findViewById(R.id.pieView);
        pieView2 = (PieView) rootView.findViewById(R.id.pieView2);
        pieView3 = (PieView) rootView.findViewById(R.id.pieView3);
        pieView4 = (PieView) rootView.findViewById(R.id.pieView4);
        tvPer1=(TextView)rootView.findViewById(R.id.tvPer1);
        tvPer2=(TextView)rootView.findViewById(R.id.tvPer2);
        tvPer3=(TextView)rootView.findViewById(R.id.tvPer3);
        tvPer4=(TextView)rootView.findViewById(R.id.tvPer4);
    }
    private void initData() {
        Utils.setTypefaceToAllViews(getActivity(), tvPer1);
    }

    private void initBundle () {
     /*  Bundle bundle = this.getArguments ();
        percentage = bundle.getDouble ("value");
        type = bundle.getInt ("type");
        Log.e ("percentage", "-"+bundle.getDouble("value"));
*/

    }




}
