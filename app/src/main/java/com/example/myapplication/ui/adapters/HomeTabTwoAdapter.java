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
import com.example.myapplication.database.tables.HomeTableTwo;

import java.util.List;

public class HomeTabTwoAdapter extends RecyclerView.Adapter<HomeTabTwoAdapter.MyViewHolder> {

    private final LayoutInflater mInflater;
    private List<HomeTableTwo> homeTableTwos; // Cached copy of words

    private String tab;
    MyViewModel myViewModel;

    public HomeTabTwoAdapter(Context context, String tab,MyViewModel myViewModel) {
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
        if (tab.equalsIgnoreCase("HOME TAB TWO")) {
            if (homeTableTwos != null) {
                final HomeTableTwo homeTableTwo = homeTableTwos.get(position);
                holder.firstName.setText(" First Name: " + homeTableTwo.getFirstName());
                holder.lastName.setText(" Last Name: " + homeTableTwo.getLastName());
                holder.age.setText(" Age: " + homeTableTwo.getAge());
                holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myViewModel.delete(homeTableTwo);
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

    public void setHomeTableTwo(List<HomeTableTwo> homeTableTwo){
        this.homeTableTwos = homeTableTwo;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (homeTableTwos != null)
            return homeTableTwos.size();
        else return 0;
    }

}
