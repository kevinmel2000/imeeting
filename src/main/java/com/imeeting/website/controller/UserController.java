package com.imeeting.website.controller;

import com.imeeting.website.domain.Find;
import com.imeeting.website.domain.User;
import com.imeeting.website.service.implement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrapry on 10/10/17.
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET)
    public Map getAll(){
        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map edit(@RequestBody User user){
        return userService.edit(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map save(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public Map del(@PathVariable Integer id){
        return userService.del(id);
    }

    /**
     * Method find for searching data user
     *
     * @param key this for keyword searching
     * @param value this for value of data searching
     *
     * */

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public Map find(@RequestBody Find find){
        if (find.getKey().equals("id")){
            return userService.findOne(Integer.parseInt(find.getValue()));
        } else if (find.getKey().equals("email")){
            return userService.findAllByEmail(find.getKey());
        } else{
            Map m = new HashMap();
            m.put("message","Keyword not found");
            m.put("response",-1);
            return m;
        }
    }
}
