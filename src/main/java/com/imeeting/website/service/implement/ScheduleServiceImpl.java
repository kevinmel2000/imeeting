package com.imeeting.website.service.implement;

import com.imeeting.website.domain.Schedule;
import com.imeeting.website.repository.ScheduleDao;
import com.imeeting.website.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrapry on 10/10/17.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    public Map findOne(Integer id) {
        Map m = new HashMap();
        Schedule schedules = scheduleDao.findOne(id);
        if (schedules==null){
            m.put("message","Data Schedule not found");
            m.put("response",-1);
        }else{
            m.put("message",schedules);
            m.put("response",1);
        }
        return m;
    }

    @Override
    public Map save(Schedule schedule) {
        Map m = new HashMap();
        scheduleDao.save(schedule);
        m.put("message","Data Schedule hasben saved");
        m.put("response",1);
        return m;
    }

    @Override
    public Map edit(Schedule schedule) {
        Map m = new HashMap();
        scheduleDao.save(schedule);
        m.put("message","Data Schedule hasben edited");
        m.put("response",1);
        return m;
    }

    @Override
    public Map del(Integer id) {
        Map m = new HashMap();
        scheduleDao.delete(id);
        m.put("message","Data Schedule hasben deleted");
        m.put("response",1);
        return m;
    }

    @Override
    public Map getAll() {
        Map m = new HashMap();
        m.put("message",scheduleDao.findAll());
        m.put("response",1);
        return m;
    }
}
