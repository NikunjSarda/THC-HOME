package com.home.thc.Services;

import com.home.thc.DTO.LocationDTO;
import com.home.thc.Exception.LocationException;
import com.home.thc.Model.Location;
import com.home.thc.Repository.LocationRepository;
import com.home.thc.Services.Interface.LocationInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

@Service
@Log4j2
public class LocationServices implements LocationInterface {

    LocationRepository locationRepo;

    public LocationServices(LocationRepository locationRepo){
        this.locationRepo = locationRepo;
    }

    @Override
    public List<Location> getAllLocation() {

        List<Location> locationList = new ArrayList<>(locationRepo.findAll());
        if (locationList.isEmpty()) {
            throw new EmptyStackException();
        }
        return locationList;
    }

    @Override
    public Location getByLocationId(String id) {
        return locationRepo.findById(Long.parseLong(id)).orElseThrow(() -> new LocationException(id));
    }

    @Override
    public Location findByLocationName(String name) {
        return null;
    }

    @Override
    public Boolean createLocation(LocationDTO location) {
        return null;
    }

    @Override
    public Boolean updateLocation(String id, LocationDTO location) {
        return null;
    }

    @Override
    public Boolean deleteLocation(String id) {
        return null;
    }
}
