package com.home.thc.Services;

import com.home.thc.DTO.OpenHoursDTO;
import com.home.thc.Model.Location;
import com.home.thc.Model.OpenHours;
import com.home.thc.Repository.OpenHoursRepository;
import com.home.thc.Services.Interface.OpenHoursInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

@Service
@Log4j2
public class OpenHoursServices implements OpenHoursInterface {

    OpenHoursRepository openHoursRepo;

    public OpenHoursServices(OpenHoursRepository openHoursRepo){
        this.openHoursRepo = openHoursRepo;
    }
    @Override
    public List<OpenHours> getAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        List<OpenHours> openHoursList = new ArrayList<>(openHoursRepo.findAll(pageable).getContent());
        if (openHoursList.isEmpty()) {
            throw new EmptyStackException();
        }
        return openHoursList;
    }

    @Override
    public List<OpenHours> getOpenHoursByLocation(String id) {
        return null;
    }

    @Override
    public Boolean createOpenHours(OpenHoursDTO openHoursDTO) {
        OpenHours openHours = new OpenHours();
        Location location = new Location();
        BeanUtils.copyProperties(openHoursDTO.getLocation(), location);
        BeanUtils.copyProperties(openHoursDTO, openHours);
        openHours.setLocation(location);
        openHoursRepo.save(openHours);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateOpenHours(String id, OpenHoursDTO openHoursDTO) {
        return null;
    }

    @Override
    public Boolean deleteOpenHours(String id) {
        return null;
    }

    @Override
    public Boolean deleteAll() {
        openHoursRepo.deleteAll();
        return Boolean.TRUE;
    }

}
