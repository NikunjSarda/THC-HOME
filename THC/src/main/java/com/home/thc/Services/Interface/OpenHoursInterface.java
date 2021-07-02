package com.home.thc.Services.Interface;

import com.home.thc.Model.OpenHours;

import java.util.List;

public interface OpenHoursInterface {

    List<OpenHours> getAll();
    List<OpenHours> findOpenHoursByLocation(String id);

}
