package com.ev.BatteryStation.Service;

import com.ev.BatteryStation.Entity.StationEntity;
import com.ev.BatteryStation.Exceptions.ResourceNotFoundException;
import com.ev.BatteryStation.Model.StationModel;

import java.util.List;

public interface StationService {
    List<StationModel> getAllStations();
    StationModel getStationById(Long stationId) throws ResourceNotFoundException;
    StationModel saveStation(StationEntity stationEntity);
    StationModel editStation(Long id, StationEntity stationEntity) throws ResourceNotFoundException;
    boolean deleteStation(Long id)throws ResourceNotFoundException;
    List<StationModel> getLimitedStations(Integer limit);

}
