package com.home.thc;

import com.home.thc.DTO.*;
import com.home.thc.Model.Location;
import com.home.thc.Repository.LocationRepository;
import com.home.thc.Services.LocationServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LocationTest {

    @Mock
    private LocationRepository locationRepo;
    private LocationServices locationServices;

    @BeforeEach
    void setup(){
        locationServices = new LocationServices(locationRepo);
    }
    @Test
    void getLocation(){

        LocationDTO locationDTO = createData();
        locationServices.createLocation(locationDTO);
        Location location = locationServices.getByLocationId("1");
        assertEquals(location.getId(), createData().getId());

    }

    LocationDTO createData(){

        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setId(1);
        locationDTO.setAddress("3800 SW 34th");
        locationDTO.setName("THC");
        locationDTO.setPhone("3254557661");
        locationDTO.setStatus("Open");

        MenuDTO menuDTO = new MenuDTO();

        menuDTO.setId(1);
        menuDTO.setName("Ham Burger");
        menuDTO.setPrice(18);
        menuDTO.setType("Main Course");
        menuDTO.setIngredients("ham, bread, cheese, onion, lettuce");

        OpenHoursDTO openHoursDTO = new OpenHoursDTO();

        openHoursDTO.setId(1);
        openHoursDTO.setDay("Monday");
        openHoursDTO.setStartTime("09:00 am");
        openHoursDTO.setEndTime("07:00 pm");
        openHoursDTO.setStatus("Open");
        openHoursDTO.setLocation(locationDTO);

        CustomerDTO customerDTO =new CustomerDTO();

        customerDTO.setId(1);
        customerDTO.setCustomerName("Rio");
        customerDTO.setEmailId("rio@skymail.com");
        customerDTO.setPhone("2455557661");

        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setId(1);
        reservationDTO.setDate(Date.valueOf("2021-07-15"));
        reservationDTO.setEventName("Personal");
        reservationDTO.setGuests(2);
        reservationDTO.setTime("01:30 pm");
        reservationDTO.setCustomer(customerDTO);
        reservationDTO.setLocation(locationDTO);

        return locationDTO;
    }
}
