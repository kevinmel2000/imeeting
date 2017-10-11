package com.imeeting.website.service;


import com.imeeting.website.domain.Schedule;

import java.util.Map;

/**
 * Created by mrapry on 10/10/17.
 */
public interface ScheduleService {

    Map findOne(Integer id);
    Map save(Schedule user);
    Map edit(Schedule user);
    Map del(Integer id);
    Map getAll();
}
