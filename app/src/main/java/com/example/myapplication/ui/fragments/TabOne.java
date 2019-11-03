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
import com.example.myapplication.database.tables.DashboardTableOne;
import com.example.myapplication.database.tables.HomeTableOne;
import com.example.myapplication.database.tables.NotificationTableOne;
import com.example.myapplication.ui.adapters.DashboardTabOneAdapter;
import com.example.myapplication.ui.adapters.HomeTabOneAdapter;
import com.example.myapplication.ui.adapters.NotificationTabOneAdapter;

import java.util.List;

public class TabOne extends Fragment {

    String state;
    RecyclerView recyclerView;
    private MyViewModel myViewModel;

    public TabOne(String state) {
        this.state = state;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab_one, container, false);
        recyclerView = root.findViewById(R.id.recyclerview_one);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        if (!TextUtils.isEmpty(state) && state.equalsIgnoreCase("HOME")) {

            final HomeTabOneAdapter homeTabOneAdapter = new HomeTabOneAdapter(getActivity(), state+" TAB ONE",myViewModel);
            recyclerView.setAdapter(homeTabOneAdapter);

            myViewModel.getAllDatahometableone().observe(this, new Observer<List<HomeTableOne>>() {
                @Override
                public void onChanged(List<HomeTableOne> homeTableOnes) {
                    homeTabOneAdapter.setHomeTableOne(homeTableOnes);
                }

            });
        } else if (!TextUtils.isEmpty(state) && state.equalsIgnoreCase("DASHBOARD")) {

            final DashboardTabOneAdapter dashboardTabOneAdapter = new DashboardTabOneAdapter(getActivity(), state+" TAB ONE",myViewModel);
            recyclerView.setAdapter(dashboardTabOneAdapter);

            myViewModel.getAllDatadashboardone().observe(this, new Observer<List<DashboardTableOne>>() {
                @Override
                public void onChanged(List<DashboardTableOne> dashboardTableOnes) {
                    dashboardTabOneAdapter.setDashboardTableOnes(dashboardTableOnes);
                }

            });
        } else if (!TextUtils.isEmpty(state) && state.equalsIgnoreCase("NOTIFICATION")) {

            final NotificationTabOneAdapter notificationTabOneAdapter = new NotificationTabOneAdapter(getActivity(), state+" TAB ONE",myViewModel);
            recyclerView.setAdapter(notificationTabOneAdapter);

            myViewModel.getAllDatanotificationone().observe(this, new Observer<List<NotificationTableOne>>() {
                @Override
                public void onChanged(List<NotificationTableOne> notificationTableOnes) {
                    notificationTabOneAdapter.setNotificationTableOnes(notificationTableOnes);
                }

            });
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }
}
