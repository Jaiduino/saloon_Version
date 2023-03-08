package com.example.saloon_version_0.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saloon_version_0.R;
import com.example.saloon_version_0.pojo.ServicesList;


public class ServicesListAdapter extends RecyclerView.Adapter<ServicesListAdapter.ViewHolder>
{
    public Context context;
    public ServicesList[] serviceList;

    public ServicesListAdapter(Context context, ServicesList[] serviceList)
    {
        this.context = context;
        this.serviceList = serviceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.list_of_services,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        final ServicesList servicesList = serviceList[position];
        holder.ServiceName.setText(servicesList.getServiceName());
        holder.ServicePrice.setText(servicesList.getServicePrice());
        holder.Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.Add.setText("Added");
                Toast.makeText(context, holder.ServiceName.getText()+" service is added to the cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return serviceList.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView ServiceName,ServicePrice;
        Button Add;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ServiceName = itemView.findViewById(R.id.tvServiceName);
            ServicePrice = itemView.findViewById(R.id.tvServicePrice);
            Add = itemView.findViewById(R.id.btnAdd);
        }
    }
}
