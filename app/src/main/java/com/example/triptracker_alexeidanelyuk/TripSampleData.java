package com.example.triptracker_alexeidanelyuk;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Sample date for TripRepository.
 */
public class TripSampleData {
    public static ITripRepository getData() {
        TripRepository data = new TripRepository();
        try {
            data.add(new Trip(0, new Date(120, 3, 6), "16:00", 4334, 12345, TripType.PERSONAL));
            data.add(new Trip(1, new Date(120, 6, 6), "16:00", 12345, 12355, TripType.PERSONAL));
            data.add(new Trip(2, new Date(120, 6, 7), "17:00", 12355, 12365, TripType.UBER));
            data.add(new Trip(3, new Date(120, 6, 8), "18:00", 12365, 12385, TripType.PERSONAL));
            data.add(new Trip(4, new Date(120, 6, 9), "19:00", 12385, 12395, TripType.UBER));
            data.add(new Trip(5, new Date(120, 6, 10), "01:00", 12395, 12400, TripType.UBER));
            data.add(new Trip(6, new Date(120, 6, 11), "11:00", 12400, 12407, TripType.PERSONAL));
            data.add(new Trip(7, new Date(120, 6, 12), "10:00", 12407, 12420, TripType.PERSONAL));
            data.add(new Trip(8, new Date(120, 6, 13), "12:00", 12420, 12440, TripType.PERSONAL));
            data.add(new Trip(9, new Date(120, 6, 14), "13:00", 12440, 12460, TripType.UBER));
            data.add(new Trip(10, new Date(120, 6, 15), "11:00", 12460, 12480, TripType.UBER));
            data.add(new Trip(11, new Date(120, 6, 15), "17:00", 12480, 12500, TripType.UBER));
            data.add(new Trip(12, new Date(120, 6, 15), "18:00", 12500, 12510, TripType.PERSONAL));
            data.add(new Trip(13, new Date(120, 6, 15), "19:00", 12510, 12515, TripType.PERSONAL));
            data.add(new Trip(14, new Date(120, 6, 16), "12:00", 12515, 12530, TripType.PERSONAL));
            data.add(new Trip(15, new Date(120, 6, 17), "10:00", 12530, 12560, TripType.UBER));
            data.add(new Trip(16, new Date(120, 6, 17), "11:00", 12560, 12580, TripType.UBER));
            data.add(new Trip(17, new Date(120, 6, 17), "13:00", 12580, 12600, TripType.PERSONAL));
            data.add(new Trip(18, new Date(120, 6, 18), "17:00", 12600, 12620, TripType.PERSONAL));
            data.add(new Trip(19, new Date(120, 6, 19), "15:00", 12620, 12640, TripType.UBER));
            data.add(new Trip(20, new Date(120, 6, 20), "13:00", 12640, 12645, TripType.UBER));
            data.add(new Trip(21, new Date(120, 6, 21), "17:00", 12645, 12660, TripType.PERSONAL));
            data.add(new Trip(22, new Date(120, 6, 22), "18:00", 12660, 12670, TripType.PERSONAL));
            data.add(new Trip(23, new Date(120, 6, 26), "12:00", 12670, 12690, TripType.UBER));
        } catch (InvalidParameterException e) {
            e.printStackTrace();
        }
        return data;
    }

}
