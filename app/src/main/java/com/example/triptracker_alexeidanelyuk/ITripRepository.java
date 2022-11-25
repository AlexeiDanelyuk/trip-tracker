package com.example.triptracker_alexeidanelyuk;

import java.util.ArrayList;
import java.util.Date;

/**
 * Interface for repositories of Trips.
 */
public interface ITripRepository {

    /**
     * Get all trips in the repository.
     * @return ArrayList of Trips.
     */
    ArrayList<Trip> get();

    /**
     * Get specific trip in the repository.
     * @param id Id of the trip.
     * @return Trip by the specified id.
     */
    Trip getById(int id);

    /**
     * Get all trips that happened on a specific date.
     * @param date The date of the trips.
     * @return ArrayList of Trips.
     */
    ArrayList<Trip> getByDate(Date date);

    /**
     * Add a trip to the repository.
     * @param trip The trip to add.
     */
    void add(Trip trip);

    /**
     * Update a trip in the repository.
     * @param trip What to update the trip to (its id must match the id of the trip update).
     */
    void update(Trip trip);

    /**
     * Delete a trip from the repository.
     * @param trip The trip to delete.
     */
    void delete(Trip trip);

    /**
     * The amount of trips in the repository.
     * @return Amount of trips.
     */
    int size();
}
