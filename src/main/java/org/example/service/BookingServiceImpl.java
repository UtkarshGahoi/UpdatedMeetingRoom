package org.example.service;

import org.example.Floor;
import org.example.Room;
import org.example.User;

import java.sql.Time;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    private ConfrenceService confrenceService;
    private Map<User,List<Booking>>bookingList=new HashMap<>();


    public BookingServiceImpl(ConfrenceService confrenceService) {
        this.confrenceService=confrenceService;
    }

    @Override
    public synchronized void booking(User user,String buildingName, String floorName, String roomName,String roomNumber) {
        List<Floor> floors = confrenceService.getFloors(buildingName);
        for(Floor floor:floors) {
            System.out.println(floor.getName());
            if (floor.getName().equals(floorName)) {
                List<Room> roomList = floor.getRoomList();
                for (Room room : roomList) {
                    if (room.getName().equals(roomName) && room.getRoomNumber().equalsIgnoreCase(roomNumber)) {
                        Booking booking = new Booking(UUID.randomUUID().toString(), user,buildingName, floorName, roomNumber, Time.valueOf("08:30:00"), Time.valueOf("12:30:00"));
                        List<Booking> bookings;
                        if(bookingList.size()>0 && bookingList.containsKey(user)){
                            bookings = bookingList.get(user);
                        }
                        else{
                            bookings = new ArrayList<>();
                        }
                        bookings.add(booking);
                        bookingList.put(user,bookings);
                    }
                }
            }
        }
    }

    @Override
    public void cancelBooking(User user,String bookingID) {
        List<Booking> allBookings = getAllBookings(user);
        for(Booking booking:allBookings){
            if(booking.bookingId.equalsIgnoreCase(bookingID)){
                allBookings.remove(booking);
                bookingList.put(user,allBookings);
                break;
            }
        }
    }

    @Override
    public List<Booking> getAllBookings(User user) {
        return bookingList.get(user);

    }
}
