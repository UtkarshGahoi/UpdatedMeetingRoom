package org.example;

import org.example.service.*;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main{
 public static void main(String[]args) {
  User user=new User("Utkarsh","utkershgahoi140@gmail.com");
  List<Room>roomList=new ArrayList<>();


  List<String>rooms = Arrays.asList(
          "sharechat",
          "unacadamay",
          "microsoft",
          "kuliza",
          "crib",
          "lendingkart"
  );
  for(String roomName:rooms){
   Room room=new Room(roomName,"124");
   roomList.add(room);

  }
  Floor floor=new Floor("nxs",roomList);
  List<Floor>floorList=new ArrayList<>();
  floorList.add(floor);
  Building building=new Building("HQ",floorList);
  ConferenceServiceImpl conferenceService=new ConferenceServiceImpl();
  conferenceService.addBuilding(building);
  BookingServiceImpl bookingService=new BookingServiceImpl(conferenceService);
  bookingService.booking(user,"HQ","nxs","crib","124");
  List<Booking> allBookings = bookingService.getAllBookings(user);
  for(Booking booking:allBookings){
   System.out.println(booking.getBookingId()+" "+booking.getBuildingName()+" "+booking.getUser()+" "+booking.getStartTime()+" "+booking.getEndTime());
  }
 }

}