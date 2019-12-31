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
import com.example.myapplication.adapters.resturentsReviewsAdapter;


public class resturent_Reviews_Fragment extends Fragment {

    RecyclerView rv_reviews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View c= inflater.inflate(R.layout.fragment_resturent__reviews_, container, false);

        rv_reviews=c.findViewById(R.id.rv_reviews);
        rv_reviews.setLayoutManager(new LinearLayoutManager(getActivity()));

        resturentsReviewsAdapter adapter = new resturentsReviewsAdapter(getContext());
        rv_reviews.setAdapter(adapter);

        return c;
    }


}
