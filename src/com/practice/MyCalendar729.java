package com.practice;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar729 {

    private List<Booking> bookings;


    public MyCalendar729() {
        bookings = new ArrayList<Booking>();
    }

    public static void main(String[] args) {
        MyCalendar729 cal = new MyCalendar729();
        cal.book(10, 20);
        cal.book(5, 20);
        //cal.book(20, 30);
    }

    public boolean book(int start, int end) {
        Booking newBooking = new Booking(start, end);

        for (Booking booking : bookings) {

            if (checkClash(booking, newBooking)) {
                return false;
            }

        }

        bookings.add(newBooking);
        return true;
    }

    private boolean checkClash(Booking booking, Booking toCheck) {
        int start = toCheck.start;
        int end = toCheck.end;

        if (start == booking.start || (start < booking.end && start > booking.start)) {
            return true;
        } else if (end < booking.end && end > booking.start) {
            return true;
        } else if (booking.start < end && booking.start > start) {
            return true;
        } else if (booking.end < end && booking.end > start) {
            return true;
        }
        return false;
    }


    class Booking {
        private int start;
        private int end;

        Booking(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }


}


/*class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}*/
