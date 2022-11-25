package com.example.triptracker_alexeidanelyuk;

import java.util.Date;

/**
 * Class for Trip that a driver has done.
 */
public class Trip {
    private int id;
    private Date date;
    private String time;
    private double startOdometer;
    private double endOdometer;
    private TripType type;

    public Trip(int id, Date date, String time, double startOdometer, double endOdometer, TripType type){
        this.id = id;
        this.date = date;
        this.time = time;
        this.startOdometer = startOdometer;
        this.endOdometer = endOdometer;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getStartOdometer() {
        return startOdometer;
    }

    public void setStartOdometer(double startOdometer) {
        this.startOdometer = startOdometer;
    }

    public double getEndOdometer() {
        return endOdometer;
    }

    public void setEndOdometer(double endOdometer) {
        this.endOdometer = endOdometer;
    }

    public TripType getType() {
        return type;
    }

    public void setType(TripType uberTrip) {
        type = uberTrip;
    }
}
