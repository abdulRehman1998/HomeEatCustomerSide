package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.models.vendorModels.Vendor;


public class about_restaurants_Fragment extends Fragment {

    Vendor vendor;
    TextView tvAddress;

    public about_restaurants_Fragment(Vendor vendor)
    {
        this.vendor=vendor;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View c = inflater.inflate(R.layout.fragment_about_, container, false);

        tvAddress=c.findViewById(R.id.address_fragmentAbout);
        tvAddress.setText(vendor.getAddress());


        return c;
    }


}
