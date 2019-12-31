package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapters.itemsAdapter;
import com.example.myapplication.models.Category;
import com.example.myapplication.models.Order;


public class categoriesFragment extends Fragment {

    RecyclerView rv_items;
    Category category;
    Order mOrder;

    public categoriesFragment(Category category, Order mOrder) {

        this.mOrder=mOrder;
    this.category = category;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View c= inflater.inflate(R.layout.fragment_items_, container, false);

        rv_items=c.findViewById(R.id.rv_items);
        rv_items.setLayoutManager(new LinearLayoutManager(getActivity()));

        itemsAdapter adapter = new itemsAdapter(getContext(), category,getActivity(),mOrder);
        rv_items.setAdapter(adapter);

        return c;

    }


}
