package com.example.myapplication.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MyViewModel;
import com.example.myapplication.R;
import com.example.myapplication.database.tables.HomeTableOne;

import java.util.List;

public class HomeTabOneAdapter extends RecyclerView.Adapter<HomeTabOneAdapter.MyViewHolder> {

    private final LayoutInflater mInflater;
    private List<HomeTableOne> homeTableOnes; // Cached copy of words

    private String tab;
    MyViewModel myViewModel;

    public HomeTabOneAdapter(Context context, String tab,MyViewModel myViewModel) {
        mInflater = LayoutInflater.from(context);
        this.tab = tab;
        this.myViewModel = myViewModel;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView firstName,lastName,age;
        private ImageView imageViewDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.first_name);
            lastName = itemView.findViewById(R.id.last_name);
            age = itemView.findViewById(R.id.age);
            imageViewDelete = itemView.findViewById(R.id.delete);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (tab.equalsIgnoreCase("HOME TAB ONE")) {
            if (homeTableOnes != null) {
                final HomeTableOne homeTableOne = homeTableOnes.get(position);
                holder.firstName.setText(" First Name: " + homeTableOne.getFirstName());
                holder.lastName.setText(" Last Name: " + homeTableOne.getLastName());
                holder.age.setText(" Age: " + homeTableOne.getAge());
                holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myViewModel.delete(homeTableOne);
                    }
                });
            } else {
                // Covers the case of data not being ready yet.
                holder.firstName.setText("NA");
                holder.lastName.setText("NA");
                holder.age.setText("NA");
            }
        }
    }

    public void setHomeTableOne(List<HomeTableOne> homeTableOnes){
        this.homeTableOnes = homeTableOnes;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (homeTableOnes != null)
            return homeTableOnes.size();
        else return 0;
    }

}
