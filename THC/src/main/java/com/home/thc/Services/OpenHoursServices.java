package com.home.thc.Services;

import com.home.thc.DTO.OpenHoursDTO;
import com.home.thc.Model.OpenHours;
import com.home.thc.Repository.OpenHoursRepository;
import com.home.thc.Services.Interface.OpenHoursInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
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
    public List<OpenHours> getAll() {
        List<OpenHours> openHoursList = new ArrayList<>(openHoursRepo.findAll());
        if (openHoursList.isEmpty()) {
            throw new EmptyStackException();
        }
        return openHoursList;
    }

    @Override
    public List<OpenHours> findOpenHoursByLocation(String id) {
        return null;
    }

    @Override
    public Boolean createOpenHours(OpenHoursDTO openHoursDTO) {
        OpenHours openHours = new OpenHours();
        BeanUtils.copyProperties(openHoursDTO, openHours);
        openHoursRepo.save(openHours);
        return Boolean.TRUE;
    }
}
