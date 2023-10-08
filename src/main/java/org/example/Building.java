package org.example;

import java.util.ArrayList;
import java.util.List;

public class Building {
    String name;
    private List<Floor> floorList=new ArrayList<>();

    public Building(String name, List<Floor> floorList) {
        this.name = name;
        this.floorList = floorList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }
}
