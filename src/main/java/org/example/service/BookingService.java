package org.example.service;

import org.example.User;

import java.util.List;

public interface BookingService {
    void booking(User user,String buildingName,String floorName,String roomName,String roomNumber);
    void cancelBooking(User user,String bookingId);
    List<Booking> getAllBookings(User user);
}
