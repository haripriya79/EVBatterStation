package com.ev.BatteryStation.Controller;

import com.ev.BatteryStation.Entity.StationEntity;
import com.ev.BatteryStation.Exceptions.ResourceNotFoundException;
import com.ev.BatteryStation.Model.StationModel;
import com.ev.BatteryStation.Service.StationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class StationController {
    @Autowired
    StationService stationService;

    @GetMapping(path = "/")
    public ResponseEntity<List<StationModel>> getStations(@RequestParam("limit") Optional<Integer> limit){

        return ResponseEntity.ok(limit.isPresent() ?
                stationService.getLimitedStations(limit.get()) :
                stationService.getAllStations());
    }

    @GetMapping(path = "show/{Id}")
    public ResponseEntity<StationModel> getStationById(@PathVariable Long Id ) throws ResourceNotFoundException {
        return ResponseEntity.ok(stationService.getStationById(Id));
    }
    @PostMapping(path = "/")
    @ResponseBody
    public ResponseEntity<StationModel> saveStation(@RequestBody @Valid StationEntity stationEntity){
        return ResponseEntity.ok(stationService.saveStation(stationEntity));
    }
    @PutMapping(path = "{Id}/edit")
    public ResponseEntity<StationModel> editStation(@PathVariable  Long Id,@RequestBody @Valid StationEntity stationEntity){
        return ResponseEntity.ok(stationService.editStation(Id,stationEntity));
    }
    @DeleteMapping(path = "delete/{Id}")
    public ResponseEntity<String> deleteStation(@PathVariable Long Id){
        return ResponseEntity.ok(stationService.deleteStation(Id)? "Deleted Successfully.":"Failed to Delete");
    }



}
