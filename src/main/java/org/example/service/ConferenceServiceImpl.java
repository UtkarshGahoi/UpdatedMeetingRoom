package org.example.service;

import org.example.Building;
import org.example.Floor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConferenceServiceImpl implements ConfrenceService{
    private Map<String,List<Floor>>roomList=new HashMap<>();

    @Override
    public void addBuilding(Building building) {
        roomList.put(building.getName(),building.getFloorList());
    }

    @Override
    public void removeBuilding(String buildingName) {
        roomList.remove(buildingName);

    }

    @Override
    public List<Floor> getFloors(String buildingName) {
        return roomList.get(buildingName);
    }
}
