package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.ViewPagerAdapter;
import com.example.myapplication.fragments.about_restaurants_Fragment;
import com.example.myapplication.fragments.resturent_Reviews_Fragment;
import com.example.myapplication.models.vendorModels.Vendor;
import com.google.android.material.tabs.TabLayout;

public class about_restaurants extends AppCompatActivity {

    TabLayout tabLayout ;
    ViewPager viewPager;
    TextView tvname;
    TextView rating;

    ImageView imgBack;
    Vendor vendor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_resturent);

        vendor= (Vendor) getIntent().getSerializableExtra("EXTRA_VENDOR");


        tvname=findViewById(R.id.name_about_resturent);
        rating=findViewById(R.id.rating_aboutResturent);
        tabLayout=findViewById(R.id.tabs_layout);
        viewPager=findViewById(R.id.viewpager_about_resturent);

        tvname.setText(vendor.getName());
        rating.setText(String.valueOf(vendor.getRating()));


        ViewPagerAdapter adapter= new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new about_restaurants_Fragment(vendor), "About");
        adapter.addFragment(new resturent_Reviews_Fragment(), "Reviews");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        imgBack=findViewById(R.id.back_about_restaurants);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(about_restaurants.this, Resturent_profile.class));
                Intent intent = new Intent(about_restaurants.this, Resturent_profile.class);
                intent.putExtra("EXTRA_VENDOR",  vendor);
                startActivity(intent);


            }
        });

    }
}
