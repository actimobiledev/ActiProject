package com.actiknow.actiproject.fragment;


import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actiknow.actiproject.R;
import com.actiknow.actiproject.utils.Utils;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import az.plainpie.PieView;
import az.plainpie.animation.PieAngleAnimation;


public class BarChartFragment extends Fragment {

    public static int PERMISSION_REQUEST_CODE = 1;
    PieView pieView;
    HorizontalBarChart barChart;
    static double percentage = 0;
    BarDataSet bardataset;
    int type = 0;
    TextView tvPer1;

    public BarChartFragment newInstance(int type, double value) {
        BarChartFragment fragment = new BarChartFragment();
        Log.e("Candidate2", "123" + type);
        Log.e("value2", "12345" + value);
        percentage = value;
        Bundle args = new Bundle();
        args.putInt("type", type);
        args.putDouble("value", value);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chart_detail, container, false);
        initView(rootView);
        initBundle();
        initData();
        setPieChartValue();
        setBarChartValue();


        return rootView;
    }
    private void setPieChartValue() {
        pieView.setPercentageBackgroundColor(getResources().getColor(R.color.primary));
        pieView.setInnerBackgroundColor(getResources().getColor(R.color.primary_dark));
        pieView.setMainBackgroundColor(getResources().getColor(R.color.primary_trans));
        pieView.setTextColor(getResources().getColor(R.color.md_white_1000));
        pieView.setPieInnerPadding(25);
        pieView.setInnerText("" + percentage + "%");
        pieView.setPercentageTextSize(Utils.pxFromDp(getActivity(), 8));
        pieView.setPercentage((float) 62);
        PieAngleAnimation animation = new PieAngleAnimation(pieView);
        animation.setDuration(2000); //This is the duration of the animation in millis
        pieView.startAnimation(animation);
        pieView.setInnerTextVisibility(View.GONE);
        tvPer1.setText("6.2");

    }
    private void initView(View rootView) {
        pieView = (PieView) rootView.findViewById(R.id.pieView);
        barChart = (HorizontalBarChart) rootView.findViewById(R.id.barchart);
        tvPer1=(TextView)rootView.findViewById(R.id.tvPer1);
    }
    private void initData() {
        Utils.setTypefaceToAllViews(getActivity(), tvPer1);
    }
    private void initBundle() {
     /*  Bundle bundle = this.getArguments ();
        percentage = bundle.getDouble ("value");
        type = bundle.getInt ("type");
        Log.e ("percentage", "-"+bundle.getDouble("value"));
*/

    }

    private void setBarChartValue() {

        ArrayList<BarEntry> bargroup1 = new ArrayList<>();
        bargroup1.add(new BarEntry(8.6f, 0));
        bargroup1.add(new BarEntry(8.2f, 1));
        bargroup1.add(new BarEntry(7.9f, 2));
        bargroup1.add(new BarEntry(7.3f, 3));
        bargroup1.add(new BarEntry(6.2f, 4));
        bargroup1.add(new BarEntry(5.9f, 5));
        bargroup1.add(new BarEntry(5.4f, 6));
        bargroup1.add(new BarEntry(5.1f, 7));

        BarDataSet barDataSet1 = new BarDataSet(bargroup1, "Bar Group 1");
        barChart.setDrawBarShadow(false);
        barChart.setDrawGridBackground(false);
        barChart.getLegend().setEnabled(false);
        barChart.setPinchZoom(false);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawGridLines(false);
        barChart.getAxisRight().setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        barChart.setDescription("");

        barChart.getAxisLeft().setDrawLabels(false);
        barChart.getAxisRight().setDrawLabels(false);
        barChart.getXAxis().setDrawLabels(false);



        YAxis yAxis = barChart.getAxisLeft();
        // yAxis.setSpaceTop(25f);
        yAxis.setDrawGridLines(false);
        yAxis.setEnabled(false);
        yAxis = barChart.getAxisRight();
        yAxis.setDrawGridLines(false);
        yAxis.setEnabled(false);
        barChart.getXAxis().setDrawLabels(true);


        ArrayList<String> labels = new ArrayList<String>();
        labels.add("30XW0502");
        labels.add("30XW0612");
        labels.add("30XW0692");
        labels.add("30XW0802");
        labels.add("30XW0912");
        labels.add("30XW0913");
        labels.add("30XW1261S");
        labels.add("30XW1401S");

        ArrayList<BarDataSet> dataSets = new ArrayList<>();
        // combined all dataset into an arraylist
        barDataSet1.setColors(new int[]{getResources().getColor(R.color.primary)});
        dataSets.add(barDataSet1);
        BarData data = new BarData(labels, dataSets);
        barChart.setData(data);


    }


}
