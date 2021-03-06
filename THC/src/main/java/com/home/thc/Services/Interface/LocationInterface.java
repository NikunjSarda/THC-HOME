package com.home.thc.Services.Interface;

import com.home.thc.DTO.LocationDTO;
import com.home.thc.Model.Location;
import com.home.thc.Response.Response;

import java.util.List;

public interface LocationInterface {

    List<Location> getAllLocation(int page, int size);
    Location getByLocationId(String id);
    List<Location> findByLocationName(String name);
    /*
    find by zip code(sort by distance), city(all), state(all)
     */
    Boolean createLocation(LocationDTO location);
    Boolean updateLocation(String id, LocationDTO location);
    Boolean deleteLocation(String id);
    Boolean deleteAll();
}
