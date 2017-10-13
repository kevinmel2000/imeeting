package com.imeeting.website.controller;

import com.imeeting.website.domain.Find;
import com.imeeting.website.domain.Schedule;
import com.imeeting.website.service.implement.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/schedule")
public class ScheduleController {

    /**
     * Created by elvan on 12/10/17.
     */

    @Autowired
    private ScheduleServiceImpl scheduleService;

    /**
     * Api getall data. We dont need PSS (Pagging, Sorting, Searching ) because the bispro dont have more of schedule
     * @return
     */

    @RequestMapping
    public Map getAll() {
        return scheduleService.getAll();
    }

    /**
     * Api Update data schedule. Client must send data in JSON
     * ex JSON :
     * {
     *     "id":"1211",
     *      "email":"matius.prastowo@iconpln.co.id",
     *      "password":"P@ssw0rd123",
     *      "nama":"matius apry prastowo"
     * }
     *
     * @param schedule this entity from schedule
     * @return
     */

    @RequestMapping(method = RequestMethod.PUT)
    public Map edit(@RequestBody Schedule schedule){
        return scheduleService.edit(schedule);
    }

    /**
     * Api save data schedule.  Client must send data in JSON
     * ex JSON :
     * {
     *     "id":"1211",
     *      "email":"matius.prastowo@iconpln.co.id",
     *      "password":"P@ssw0rd123",
     *      "nama":"matius apry prastowo"
     * }
     * @param schedule this entity from schedule
     * @return
     */

    @RequestMapping(method = RequestMethod.POST)
    public Map save (@RequestBody Schedule schedule){
        return scheduleService.save(schedule);
    }

    /**
     * Api del data schedule. the data will be delete from database
     * client must input id parameter from schedule
     *
     * @param id id_schedule from schedule
     * @return
     */

    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public Map del(@PathVariable Integer id){
        return scheduleService.del(id);
    }

    /**
     * Api find data schedule. this method for searching data schedule
     *
     * @param find this entity is keyword and value for search data schedule
     * @return
     */

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public Map find(@RequestBody Find find) {
        if (find.getKey().equals("id")){
            return scheduleService.findOne(Integer.parseInt(find.getValue()));
        } else {
            Map m = new HashMap();
            m.put("message","Keyword not found");
            m.put("response", -1);
            return m;
        }
    }
}
