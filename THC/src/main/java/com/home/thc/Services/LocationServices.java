package com.home.thc.Services;

import com.home.thc.DTO.LocationDTO;
import com.home.thc.Exception.LocationException;
import com.home.thc.Exception.MenuException;
import com.home.thc.Model.Location;
import com.home.thc.Repository.LocationRepository;
import com.home.thc.Services.Interface.LocationInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class LocationServices implements LocationInterface {

    LocationRepository locationRepo;

    public LocationServices(LocationRepository locationRepo){
        this.locationRepo = locationRepo;
    }

    @Override
    public List<Location> getAllLocation(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        List<Location> locationList = new ArrayList<>(locationRepo.findAll(pageable).getContent());
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
    public List<Location> findByLocationName(String name) {
        List<Location> locationList = new ArrayList<>(locationRepo.findByName(name));
        if (locationList.isEmpty()) {
            throw new EmptyStackException();
        }
        return locationList;
    }

    @Override
    public Boolean createLocation(LocationDTO locationDTO) {
        Location location = new Location();
        BeanUtils.copyProperties(locationDTO, location);
        locationRepo.save(location);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateLocation(String id, LocationDTO locationDTO) {
        Optional<Location> location = locationRepo.findById(Long.parseLong(id));
        if(location.isEmpty()) {
            throw new LocationException(id);
        }
        BeanUtils.copyProperties(locationDTO, location.get());
        locationRepo.save(location.get());
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteLocation(String id) {
        Optional<Location> location = locationRepo.findById(Long.parseLong(id));
        if(location.isEmpty()) {
            throw new MenuException(id);
        }
        locationRepo.delete(location.get());
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteAll() {
        locationRepo.deleteAll();
        return Boolean.TRUE;
    }
}
