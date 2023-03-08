package com.example.saloon_version_0.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.saloon_version_0.R;
import com.example.saloon_version_0.adapter.ServicesListAdapter;
import com.example.saloon_version_0.fragment.CartFragment;
import com.example.saloon_version_0.pojo.ServicesList;

public class AMaleActivity extends AppCompatActivity {

         ServicesList[] serviceList;

         LinearLayout linearLayout;

        RecyclerView recyclerView;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_amale);
            linearLayout = findViewById(R.id.linear_layout);

            getSupportActionBar().setTitle("Back");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//            GoToCart = findViewById(R.id.btnGoToCart);
//            GoToCart.setOnClickListener(new View.OnClickListener()
//            {
//                @Override
//                public void onClick(View v)
//                {
//                    Fragment fragment = new CartFragment();
//                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.btnGoToCart,fragment).commit();
//                }
//            });

            recyclerView = findViewById(R.id.recyclerView);
            serviceList = new ServicesList[]
                    {
                            new ServicesList("Change Of Styling","600"),
                            new ServicesList("Hair Spa","400"),
                            new ServicesList("Hair Cutting","500"),
                            new ServicesList("Hair Style","700")

                    };
            ServicesListAdapter serviceAdapter = new ServicesListAdapter(this, serviceList);
            recyclerView.setAdapter(serviceAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void goToCart(View view)
    {
        //startActivity(new Intent(AMaleActivity.this,CartFragment.class));
        Fragment fragment = new CartFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.constraint,fragment).commit();
    }
}