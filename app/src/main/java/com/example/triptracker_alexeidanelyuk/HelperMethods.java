package com.example.triptracker_alexeidanelyuk;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperMethods {

    public static DateFormat DefaultFormatter = new SimpleDateFormat("dd/MM/yyyy");


    /**
     * A TryParse for dates.
     * @param dateString The string that might be a valid date.
     * @return True if the date is valid, false otherwise.
     */
    public static boolean IsValidDate(String dateString) {
        try {
            Date date = DefaultFormatter.parse(dateString);

            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * A TryParse for dates.
     * @param dateString The string that might be a valid date.
     * @param formatter The format that the date is supposed to be in.
     * @return True if the date is valid, false otherwise.
     */
    public static boolean IsValidDate(String dateString, DateFormat formatter) {
        try {
            Date date = formatter.parse(dateString);

            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Determine if the trip type is a valid type.
     * @param typeString The string that might be a valid trip type.
     * @return True if the type is valid, false otherwise.
     */
    public static boolean IsValidType(String typeString) {
        return typeString.toUpperCase().equals(TripType.PERSONAL.toString()) || typeString.toUpperCase().equals(TripType.UBER.toString());
    }
}
