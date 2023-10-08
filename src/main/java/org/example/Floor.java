package org.example;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    String name;
    private List<Room>roomList;

    public Floor(String name, List<Room> roomList) {
        this.name = name;
        this.roomList = roomList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}
