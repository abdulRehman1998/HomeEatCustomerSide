package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.ViewPagerAdapterProfile;
import com.example.myapplication.fragments.categoriesFragment;
import com.example.myapplication.models.Order;
import com.example.myapplication.models.vendorModels.Vendor;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Resturent_profile extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewPager;
    TextView restName;
    TextView ratingBar;
    ImageView imgBack;
    Vendor vendor;
    Order mOrder=new Order();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_resturent_profile);
            restName=findViewById(R.id.resturent_name_rest_profile);
            ratingBar=findViewById(R.id.rating_resturentProfile);
            vendor= (Vendor) getIntent().getSerializableExtra("EXTRA_VENDOR");


             restName.setText(vendor.getName().toString());
             ratingBar.setText(String.valueOf(vendor.getRating()));
                mOrder.setVendorID(vendor.get_id().toString());
                mOrder.setCustomerID("cust101");


                btnClick();






            tablayout = (TabLayout) findViewById(R.id.tabs_layout_restaurants_profile);
            viewPager = (ViewPager) findViewById(R.id.viewpager_restaurants_profile);

            ViewPagerAdapterProfile adapter = new ViewPagerAdapterProfile (getSupportFragmentManager());

            for(int i = 0; i< vendor.getMenu().getcategoriesList().size(); i++)
            {
                adapter.addFragment (new categoriesFragment(vendor.getMenu().getcategoriesList().get(i),mOrder),vendor.getMenu().getcategoriesList().get(i).getName());

            }
            viewPager.setAdapter(adapter);
            tablayout.setupWithViewPager(viewPager);






        }


        void btnClick()
        {

            restName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Resturent_profile.this, about_restaurants.class);
                    intent.putExtra("EXTRA_VENDOR",  vendor);
                    startActivity(intent);

                }
            });

            imgBack=findViewById(R.id.img_baclk_rest_profile2);
            imgBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Resturent_profile.this, OrderPage.class));

                }
            });

            ImageView imgCart=findViewById(R.id.img_Cart_rest_profile2);
            imgCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy       hh : mm : ss ");
                    Calendar calendar = Calendar.getInstance();
                    Date orderDate = calendar.getTime();
                    String orderDateAndTime = sdf.format(orderDate);

                    mOrder.setTime(orderDateAndTime);
                    mOrder.setDate(orderDateAndTime);
                    mOrder.setDeliveryFee(150);

                    float total=mOrder.getTotalPrice();
                    float tax= (float) (total*(0.16));
                    total=total+tax+150;




                    Intent intent = new Intent(Resturent_profile.this, Cart_activity.class);
                    intent.putExtra("EXTRA_ORDER",  mOrder);
                    startActivity(intent);

                }
            });

        }
}
