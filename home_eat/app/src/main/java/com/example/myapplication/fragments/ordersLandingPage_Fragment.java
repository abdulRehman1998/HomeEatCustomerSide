package com.example.myapplication.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapters.horizontalAdapter;
import com.example.myapplication.models.vendorModels.Vendor;

import java.util.ArrayList;
import java.util.List;

public class ordersLandingPage_Fragment extends Fragment {

    RecyclerView rv_orderAgain;
    RecyclerView rv_bestRated;
    RecyclerView rv_feeDelivery;

    List<Vendor> vendorsList;


    public ordersLandingPage_Fragment(List<Vendor> vendorsList)
    {
        this.vendorsList=vendorsList;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_orders_landing_page_, container, false);

        inflateBestRated(view);
        inflateFreeDelivery(view);
        inflateOrderAgain(view);


        return view;
    }

    void inflateOrderAgain(View view)
    {
        LinearLayoutManager layoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        horizontalAdapter adapterOrderAgain = new horizontalAdapter(getContext(),vendorsList);
        rv_orderAgain=(RecyclerView)view.findViewById(R.id.list_orderagain);
        rv_orderAgain.setLayoutManager(layoutManager);
        rv_orderAgain.setAdapter(adapterOrderAgain);

    }

    void inflateFreeDelivery(View view)
    {
        LinearLayoutManager layoutManager_freeDelivery= new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        horizontalAdapter adapterFreeDelivery = new horizontalAdapter(getContext(),vendorsList);
        rv_feeDelivery=(RecyclerView) view.findViewById(R.id.list_freeDelivery);
        rv_feeDelivery.setLayoutManager(layoutManager_freeDelivery);
        rv_feeDelivery.setAdapter(adapterFreeDelivery);

    }

    void inflateBestRated(View view)
    {
        LinearLayoutManager layoutManager_bestRated= new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        horizontalAdapter adapterBestRated = new horizontalAdapter(getContext(),vendorsList);
        rv_bestRated=(RecyclerView) view.findViewById(R.id.list_bestRated);
        rv_bestRated.setLayoutManager(layoutManager_bestRated);
        rv_bestRated.setAdapter(adapterBestRated);

    }



}
