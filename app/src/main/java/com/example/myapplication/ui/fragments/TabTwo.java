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
import com.example.myapplication.database.tables.DashboardTableTwo;
import com.example.myapplication.database.tables.HomeTableTwo;
import com.example.myapplication.database.tables.NotificationTableTwo;
import com.example.myapplication.ui.adapters.DashboardTabTwoAdapter;
import com.example.myapplication.ui.adapters.HomeTabTwoAdapter;
import com.example.myapplication.ui.adapters.NotificationTabTwoAdapter;

import java.util.List;

public class TabTwo extends Fragment {

    String state;
    RecyclerView recyclerView;
    private MyViewModel myViewModel;

    public TabTwo(String state) {
        this.state = state;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab_two, container, false);
        recyclerView = root.findViewById(R.id.recyclerview_two);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        if (!TextUtils.isEmpty(state) && state.equalsIgnoreCase("HOME")) {

            final HomeTabTwoAdapter homeTabTwoAdapter = new HomeTabTwoAdapter(getActivity(), state+" TAB TWO",myViewModel);
            recyclerView.setAdapter(homeTabTwoAdapter);

            myViewModel.getAllDatahometabletwo().observe(this, new Observer<List<HomeTableTwo>>() {
                @Override
                public void onChanged(List<HomeTableTwo> homeTableTwos) {
                    homeTabTwoAdapter.setHomeTableTwo(homeTableTwos);
                }

            });
        } else if (!TextUtils.isEmpty(state) && state.equalsIgnoreCase("DASHBOARD")) {

            final DashboardTabTwoAdapter dashboardTabTwoAdapter = new DashboardTabTwoAdapter(getActivity(), state+" TAB TWO",myViewModel);
            recyclerView.setAdapter(dashboardTabTwoAdapter);

            myViewModel.getAllDatadashboardtwo().observe(this, new Observer<List<DashboardTableTwo>>() {
                @Override
                public void onChanged(List<DashboardTableTwo> dashboardTableTwos) {
                    dashboardTabTwoAdapter.setDashboardTableTwos(dashboardTableTwos);
                }

            });
        } else if (!TextUtils.isEmpty(state) && state.equalsIgnoreCase("NOTIFICATION")) {

            final NotificationTabTwoAdapter notificationTabTwoAdapter = new NotificationTabTwoAdapter(getActivity(), state+" TAB TWO",myViewModel);
            recyclerView.setAdapter(notificationTabTwoAdapter);

            myViewModel.getAllDatanotificationtwo().observe(this, new Observer<List<NotificationTableTwo>>() {
                @Override
                public void onChanged(List<NotificationTableTwo> notificationTableTwos) {
                    notificationTabTwoAdapter.setNotificationTableTwos(notificationTableTwos);
                }

            });
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }
}
