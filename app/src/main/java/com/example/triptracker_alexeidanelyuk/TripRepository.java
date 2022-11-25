package com.example.triptracker_alexeidanelyuk;

import java.util.ArrayList;
import java.util.Date;

/**
 * Implementation of ITripRepository interface.
 */
public class TripRepository implements ITripRepository{
    ArrayList<Trip> trips = new ArrayList<>();

    /**
     * Get all trips in the repository.
     * @return ArrayList of Trips.
     */
    @Override
    public ArrayList<Trip> get() {
        return trips;
    }

    /**
     * Get specific trip in the repository.
     * @param id Id of the trip.
     * @return Trip by the specified id.
     */
    @Override
    public Trip getById(int id) {

        for (Trip trip : trips)
            if (trip.getId() == id)
                return trip;

        return null;
    }

    /**
     * Get all trips that happened on a specific date.
     * @param date The date of the trips.
     * @return ArrayList of Trips.
     */
    @Override
    public ArrayList<Trip> getByDate(Date date) {
        ArrayList<Trip> tripsOnDate = new ArrayList<>();

        for (Trip trip : trips)
            if (trip.getDate().equals(date))
                tripsOnDate.add(trip);

        return tripsOnDate;
    }

    /**
     * Add a trip to the repository.
     * @param trip The trip to add.
     */
    @Override
    public void add(Trip trip) {
        trips.add(trip);
    }

    /**
     * Update a trip in the repository.
     * @param trip What to update the trip to (its id must match the id of the trip update).
     */
    @Override
    public void update(Trip trip) {
        Trip tripToReplace = getById(trip.getId());
        tripToReplace.setDate(trip.getDate());
        tripToReplace.setStartOdometer(trip.getStartOdometer());
        tripToReplace.setEndOdometer(trip.getEndOdometer());
        tripToReplace.setTime(trip.getTime());
        tripToReplace.setType(trip.getType());
    }

    /**
     * Delete a trip from the repository.
     * @param trip The trip to delete.
     */
    @Override
    public void delete(Trip trip) { trips.remove(trip); }

    /**
     * The amount of trips in the repository.
     * @return Amount of trips.
     */
    @Override
    public int size() {
        return trips.size();
    }
}
