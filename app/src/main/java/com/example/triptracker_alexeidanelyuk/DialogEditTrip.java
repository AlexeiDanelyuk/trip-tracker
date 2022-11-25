package com.example.triptracker_alexeidanelyuk;

import static com.example.triptracker_alexeidanelyuk.HelperMethods.*;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.triptracker_alexeidanelyuk.databinding.FragmentDialogEditTripBinding;

import java.text.ParseException;
import java.util.Date;

/**
 * Dialog to edit a Trip.
 */
public class DialogEditTrip extends DialogFragment {

    private final Trip mItem;
    private final ITripRepository mValues;
    private final TripRecyclerViewAdapter adapter;
    private final int position;
    private FragmentDialogEditTripBinding binding;


    public DialogEditTrip(Trip mItem, TripRecyclerViewAdapter tripRecyclerViewAdapter, int position, ITripRepository mValues) {
        this.mItem = mItem;
        this.mValues = mValues;
        this.adapter = tripRecyclerViewAdapter;
        this.position = position;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDialogEditTripBinding.inflate(inflater, container, false);

        binding.dateDialogEditText.setText(DefaultFormatter.format(mItem.getDate()));
        binding.timeDialogEditText.setText(mItem.getTime());
        binding.startDialogEditText.setText(mItem.getStartOdometer()+"");
        binding.endDialogEditText.setText(mItem.getEndOdometer()+"");
        binding.typeDialogEditText.setText(mItem.getType().toString());

        // update
        binding.btnDialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Trip newTrip = new Trip(mItem.getId(), new Date(), "", 0,0, TripType.UBER);

                try {
                    // if the date is valid, change to it
                    if (IsValidDate(binding.dateDialogEditText.getText().toString())){
                        newTrip.setDate(DefaultFormatter.parse(binding.dateDialogEditText.getText().toString()));
                    }
                    // otherwise, keep the old one
                    else {
                        newTrip.setDate(mItem.getDate());
                    }
                } catch (ParseException ignored){}

                newTrip.setTime(binding.timeDialogEditText.getText().toString());
                newTrip.setStartOdometer(Double.parseDouble(binding.startDialogEditText.getText().toString()));
                newTrip.setEndOdometer(Double.parseDouble(binding.endDialogEditText.getText().toString()));

                // if the trip type is valid, change to it
                if (IsValidType(binding.typeDialogEditText.getText().toString())) {
                    newTrip.setType(TripType.valueOf(binding.typeDialogEditText.getText().toString().toUpperCase()));
                }
                // otherwise, keep the old one
                else {
                    newTrip.setType(mItem.getType());
                }

                mValues.update(newTrip);

                adapter.notifyItemChanged(position);
                dismiss();
            }
        });

        // delete
        binding.btnDialogDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mValues.delete(mValues.getById(mItem.getId()));
                adapter.notifyDataSetChanged();
                dismiss();
            }
        });

        // cancel
        binding.btnDialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}