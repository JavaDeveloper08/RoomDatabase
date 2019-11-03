package com.example.myapplication.ui.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MyViewModel;
import com.example.myapplication.R;
import com.example.myapplication.database.tables.DashboardTableThree;
import com.example.myapplication.database.tables.DashboardTableTwo;
import com.example.myapplication.database.tables.HomeTableThree;
import com.example.myapplication.database.tables.HomeTableTwo;
import com.example.myapplication.database.tables.NotificationTableThree;
import com.example.myapplication.database.tables.NotificationTableTwo;
import com.example.myapplication.ui.adapters.DashboardTabThreeAdapter;
import com.example.myapplication.ui.adapters.DashboardTabTwoAdapter;
import com.example.myapplication.ui.adapters.HomeTabOneAdapter;
import com.example.myapplication.ui.adapters.HomeTabThreeAdapter;
import com.example.myapplication.ui.adapters.HomeTabTwoAdapter;
import com.example.myapplication.ui.adapters.NotificationTabOneAdapter;
import com.example.myapplication.ui.adapters.NotificationTabThreeAdapter;
import com.example.myapplication.ui.adapters.NotificationTabTwoAdapter;

import java.util.List;

public class TabThree extends Fragment {

    String state;
    RecyclerView recyclerView;
    private MyViewModel myViewModel;

    public TabThree(String state) {
        this.state = state;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab_three, container, false);
        recyclerView = root.findViewById(R.id.recyclerview_three);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        if (!TextUtils.isEmpty(state) && state.equalsIgnoreCase("HOME")) {

            final HomeTabThreeAdapter homeTabThreeAdapter = new HomeTabThreeAdapter(getActivity(), state+" TAB THREE",myViewModel);
            recyclerView.setAdapter(homeTabThreeAdapter);

            myViewModel.getAllDatahometablethree().observe(this, new Observer<List<HomeTableThree>>() {
                @Override
                public void onChanged(List<HomeTableThree> homeTableThrees) {
                    homeTabThreeAdapter.setHomeTableThree(homeTableThrees);
                }

            });
        } else if (!TextUtils.isEmpty(state) && state.equalsIgnoreCase("DASHBOARD")) {

            final DashboardTabThreeAdapter dashboardTabThreeAdapter = new DashboardTabThreeAdapter(getActivity(), state+" TAB THREE",myViewModel);
            recyclerView.setAdapter(dashboardTabThreeAdapter);

            myViewModel.getAllDatadashboardthree().observe(this, new Observer<List<DashboardTableThree>>() {
                @Override
                public void onChanged(List<DashboardTableThree> dashboardTableThrees) {
                    dashboardTabThreeAdapter.setDashboardTableThrees(dashboardTableThrees);
                }

            });
        } else if (!TextUtils.isEmpty(state) && state.equalsIgnoreCase("NOTIFICATION")) {

            final NotificationTabThreeAdapter notificationTabThreeAdapter = new NotificationTabThreeAdapter(getActivity(), state+" TAB THREE",myViewModel);
            recyclerView.setAdapter(notificationTabThreeAdapter);

            myViewModel.getAllDatanotificationthree().observe(this, new Observer<List<NotificationTableThree>>() {
                @Override
                public void onChanged(List<NotificationTableThree> notificationTableThrees) {
                    notificationTabThreeAdapter.setNotificationTableThrees(notificationTableThrees);
                }

            });
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }
}
