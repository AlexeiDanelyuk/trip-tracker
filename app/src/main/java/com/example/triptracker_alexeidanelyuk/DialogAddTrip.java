package com.example.triptracker_alexeidanelyuk;

import static com.example.triptracker_alexeidanelyuk.HelperMethods.*;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.triptracker_alexeidanelyuk.databinding.FragmentDialogAddTripBinding;

import java.text.ParseException;
import java.util.Date;

/**
 * Dialog to add a Trip.
 */
public class DialogAddTrip extends DialogFragment {

    private final ITripRepository mValues;
    private FragmentDialogAddTripBinding binding;

    public DialogAddTrip(TripRecyclerViewAdapter tripRecyclerViewAdapter, ITripRepository mValues) {
        this.mValues = mValues;
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

        binding = FragmentDialogAddTripBinding.inflate(inflater, container, false);

        // keep track of the latest trip
        Trip lastTrip = mValues.get().get(mValues.size()-1);

        // date is the date of the last trip by default
        binding.dateDialogEditText.setText(DefaultFormatter.format(lastTrip.getDate()));
        // odometer start is the odometer end of the last trip by default
        binding.startDialogEditText.setText(lastTrip.getEndOdometer()+"");
        // trip type is PERSONAL by default
        binding.typeDialogEditText.setText(TripType.PERSONAL.toString());

        // add
        binding.btnDialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Trip newTrip = new Trip(lastTrip.getId()+1, new Date(), "", lastTrip.getEndOdometer(), 0, TripType.PERSONAL);

                try {
                    // if the date is valid, set the date to that
                    if (IsValidDate(binding.dateDialogEditText.getText().toString())){
                        newTrip.setDate(DefaultFormatter.parse(binding.dateDialogEditText.getText().toString()));
                    }
                    // otherwise, set the date to the last trip's date
                    else {
                        newTrip.setDate(lastTrip.getDate());
                    }
                } catch (ParseException ignored){}

                newTrip.setTime(binding.timeDialogEditText.getText().toString());
                newTrip.setStartOdometer(Double.parseDouble(binding.startDialogEditText.getText().toString()));
                newTrip.setEndOdometer(Double.parseDouble(binding.endDialogEditText.getText().toString()));

                // if the trip type is valid, set the type to it, otherwise keep it PERSONAL
                if (IsValidType(binding.typeDialogEditText.getText().toString())) {
                    newTrip.setType(TripType.valueOf(binding.typeDialogEditText.getText().toString().toUpperCase()));
                }

                mValues.add(newTrip);

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