package com.example.triptracker_alexeidanelyuk;

import static com.example.triptracker_alexeidanelyuk.HelperMethods.*;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.support.v4.app.*;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.triptracker_alexeidanelyuk.databinding.FragmentTripListBinding;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A fragment representing a list of Items.
 */
public class TripFragment extends Fragment {

    private int mColumnCount = 1;
    TripRecyclerViewAdapter adapter;
    ITripRepository data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTripListBinding binding = FragmentTripListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        Context context = view.getContext();

        // get access to the main activity to take over the data and adapter
        MainActivity main = (MainActivity) getActivity();

        if (mColumnCount <= 1) {
            binding.tripsRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            binding.tripsRecyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }

        data = main.data;
        adapter = main.adapter;

        binding.tripsRecyclerView.setAdapter(adapter);

        // date filter button event
        binding.dateFilterButton.setOnClickListener(view1 -> {
            // if valid date, switch to that date
            if (IsValidDate(binding.dateFilterEditTextDate.getText().toString())){
                try {
                    adapter.enableDateFilter(DefaultFormatter.parse(binding.dateFilterEditTextDate.getText().toString()));
                } catch (ParseException e) {}
            }
            // otherwise, disable the filter
            else {
                adapter.disableDateFilter();
            }
        });

        return view;
    }
}