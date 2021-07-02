package com.home.thc.Services.Interface;

import com.home.thc.DTO.OpenHoursDTO;
import com.home.thc.Model.OpenHours;
import com.home.thc.Response.Response;

import java.util.List;

public interface OpenHoursInterface {

    List<OpenHours> getAll();
    List<OpenHours> findOpenHoursByLocation(String id);
    Boolean createOpenHours(OpenHoursDTO openHoursDTO);
}
