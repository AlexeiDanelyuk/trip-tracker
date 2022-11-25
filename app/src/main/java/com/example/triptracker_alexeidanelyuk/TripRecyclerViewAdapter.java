package com.example.triptracker_alexeidanelyuk;

import static com.example.triptracker_alexeidanelyuk.HelperMethods.DefaultFormatter;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.triptracker_alexeidanelyuk.databinding.ListItemTripBinding;

import java.util.Date;

public class TripRecyclerViewAdapter extends RecyclerView.Adapter<TripRecyclerViewAdapter.ViewHolder> {

    private final ITripRepository mValues;
    private final FragmentActivity activity;
    private boolean dateFilterEnabled;
    private Date dateFilter;

    public TripRecyclerViewAdapter(FragmentActivity activity, ITripRepository trips) {
        this.activity = activity;
        mValues = trips;
        this.dateFilterEnabled = false;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ListItemTripBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // if the date filter is enabled, load only the Trips that match the date
        if (dateFilterEnabled) {
            holder.bind(mValues.getByDate(dateFilter).get(position), position);
        } else {
            holder.bind(mValues.get().get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        // needed to ensure the onBindViewHolder executes the right amount of time for teh dataset
        if (dateFilterEnabled) {
            return mValues.getByDate(dateFilter).size();
        } else {
            return mValues.get().size();
        }
    }

    /**
     * Method to filter the trips by date.
     * @param date The date by which the trips will be filtered.
     */
    public void enableDateFilter(Date date) {
        dateFilterEnabled = true;
        this.dateFilter = date;
        notifyDataSetChanged();
    }

    /**
     * Method to disable the date filter.
     */
    public void disableDateFilter() {
        dateFilterEnabled = false;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListItemTripBinding binding;
        public Trip mItem;
        private int position;

        public ViewHolder(ListItemTripBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.constraintLayout.setOnClickListener(view -> {
                DialogEditTrip dialog = new DialogEditTrip(mItem, TripRecyclerViewAdapter.this, position, mValues);
                dialog.show(activity.getSupportFragmentManager(), "edit-dialog");
            });
        }

        private void bind(Trip trip, int position) {
            mItem = trip;

            binding.dateDisplayTextView.setText(DefaultFormatter.format(mItem.getDate()));
            binding.timeDisplayTextView.setText(trip.getTime());
            binding.startOdometerDisplayTextView.setText(""+(int) trip.getStartOdometer());
            binding.endOdometerDisplayTextView.setText(""+(int) trip.getEndOdometer());

            if (trip.getType() == TripType.PERSONAL)
                binding.constraintLayout.setBackgroundColor(Color.parseColor("#804DF10C"));
            else if (trip.getType() == TripType.UBER)
                binding.constraintLayout.setBackgroundColor(Color.parseColor("#800CF1ED"));

            this.position = position;
        }
    }
}