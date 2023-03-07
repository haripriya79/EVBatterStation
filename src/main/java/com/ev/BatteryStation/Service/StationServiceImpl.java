package com.ev.BatteryStation.Service;

import com.ev.BatteryStation.Entity.StationEntity;
import com.ev.BatteryStation.Exceptions.ResourceNotFoundException;
import com.ev.BatteryStation.Model.StationModel;
import com.ev.BatteryStation.Repository.StationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements StationService{
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<StationModel> getAllStations() {

        return stationRepository.findAll()
                .stream()
                .map(stationEntity -> modelMapper.map(stationEntity,StationModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public StationModel getStationById(Long stationId) {
        if(stationRepository.findById(stationId).isEmpty())
            throw new ResourceNotFoundException();
        return modelMapper.map(stationRepository.findById(stationId).get(), StationModel.class);
    }

    @Override
    public StationModel saveStation(StationEntity stationEntity) {
        return modelMapper.map(stationRepository.save(stationEntity),StationModel.class);
    }

    @Override
    public StationModel editStation(Long stationId, StationEntity stationEntity) throws ResourceNotFoundException {
        if(stationRepository.findById(stationId).isEmpty())
            throw new ResourceNotFoundException();
        return modelMapper.map(stationRepository.save(stationEntity),StationModel.class);
    }

    @Override
    public boolean deleteStation(Long stationId) throws ResourceNotFoundException {
        if(stationRepository.findById(stationId).isEmpty())
            throw new ResourceNotFoundException();
        stationRepository.deleteById(stationId);
        return true;
    }



    @Override
    public List<StationModel> getLimitedStations(Integer limit) {
        Pageable limitPage = PageRequest.of(0, limit);
        return stationRepository.findAll(PageRequest.of(0, limit))
                .stream()
                .map(stationEntity -> modelMapper.map(stationEntity,StationModel.class))
                .collect(Collectors.toList());

    }


}
