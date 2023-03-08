package com.example.saloon_version_0.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saloon_version_0.R;
import com.example.saloon_version_0.activity.BookAppointementActivity;
import com.example.saloon_version_0.adapter.AppointementAdapter;
import com.example.saloon_version_0.adapter.CartAdapter;
import com.example.saloon_version_0.adapter.ServicesListAdapter;
import com.example.saloon_version_0.pojo.Appointements;
import com.example.saloon_version_0.pojo.CartItem;
import com.example.saloon_version_0.pojo.ServicesList;

import java.util.Arrays;
import java.util.List;

public class CartFragment extends Fragment
{
    Button btn;
    RecyclerView recyclerView;
    CartItem[] cartItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);

        btn = view.findViewById(R.id.btnProccedOut);
        btn.setOnClickListener(v ->
        {
            Intent intent = new Intent(getActivity(), BookAppointementActivity.class);
            startActivity(intent);
        });

        recyclerView = view.findViewById(R.id.recyclerView);
        cartItems = new CartItem[]
                {
                        new CartItem(1,"Change Of Styling","600"),
                        new CartItem(2,"Hair Cutting","700"),
                        new CartItem(3,"Body Spa","800"),
                        new CartItem(4,"Facial","900")

                };
        CartAdapter cartAdapter = new CartAdapter(getContext(), cartItems);
        recyclerView.setAdapter(cartAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

}

