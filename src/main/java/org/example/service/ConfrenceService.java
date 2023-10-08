package org.example.service;

import org.example.Building;
import org.example.Floor;

import java.util.List;

public interface ConfrenceService {
    void addBuilding(Building building);
    void removeBuilding(String buildingName);

    List<Floor> getFloors(String buildingName);
}
