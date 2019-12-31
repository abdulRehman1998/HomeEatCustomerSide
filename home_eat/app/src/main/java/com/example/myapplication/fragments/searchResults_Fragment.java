package com.example.myapplication.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.adapters.horizontalAdapter;
import com.example.myapplication.adapters.itemsAdapter;
import com.example.myapplication.models.vendorModels.Vendor;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class searchResults_Fragment extends Fragment {

    ArrayList<Vendor> searchList;
    RecyclerView rv_searchResults;

    public searchResults_Fragment( ArrayList<Vendor> searchList)
    {

        this.searchList=searchList;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_search_results_, container, false);


        horizontalAdapter adapterOrderAgain = new horizontalAdapter(getContext(),searchList);
        rv_searchResults=(RecyclerView)view.findViewById(R.id.list_searchResults);
        rv_searchResults.setLayoutManager(new GridLayoutManager(getContext(),2));
        rv_searchResults.setAdapter(adapterOrderAgain);






        return  view;
    }
}
