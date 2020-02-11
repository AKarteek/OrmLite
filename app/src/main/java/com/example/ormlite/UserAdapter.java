package com.example.ormlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    List<OrmDatabaseModel> ormdatalist;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        //Declaring All TextViews Here ....
        public TextView ADD1, NAME, READDATE, RRNO;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ADD1 = itemView.findViewById(R.id.txt_add1);
            NAME = itemView.findViewById(R.id.txt_name);
            READDATE = itemView.findViewById(R.id.txt_readdate);
            RRNO = itemView.findViewById(R.id.txt_rrno);
        }
    }

    public UserAdapter(List<OrmDatabaseModel> ormdatalist) {
        this.ormdatalist = ormdatalist;
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {

        OrmDatabaseModel ormDatabaseModel = ormdatalist.get(position);
        holder.ADD1.setText(ormDatabaseModel.getADD1());
        holder.NAME.setText(ormDatabaseModel.getNAME());
        holder.READDATE.setText(ormDatabaseModel.getREADDATE());
        holder.RRNO.setText(ormDatabaseModel.getRRNO());


    }

    @Override
    public int getItemCount() {
        return ormdatalist.size();
    }


}
