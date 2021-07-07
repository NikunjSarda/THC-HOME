package com.home.thc.Services.Interface;

import com.home.thc.DTO.OpenHoursDTO;
import com.home.thc.Model.OpenHours;
import com.home.thc.Response.Response;

import java.util.List;
import java.util.function.BooleanSupplier;

public interface OpenHoursInterface {

    List<OpenHours> getAll(int page, int size);
    List<OpenHours> getOpenHoursByLocation(String id);
    Boolean createOpenHours(OpenHoursDTO openHoursDTO);
    Boolean updateOpenHours(String id, OpenHoursDTO openHoursDTO);
    Boolean deleteOpenHours(String id);
    Boolean deleteAll();
}
