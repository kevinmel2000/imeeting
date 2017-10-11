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

    /**
     * Api get data all. We no need PSS(Pagging, sorting, searching) because the bispro not have more of user.
     * @return
     * */
    @RequestMapping(method = RequestMethod.GET)
    public Map getAll(){
        return userService.getAll();
    }

    /**
     * Api update data for user. Client must send data in JSON.
     * ex json :
     * {
     *      "id":"1211",
     *      "email":"matius.prastowo@iconpln.co.id",
     *      "password":"P@ssw0rd123",
     *      "nama":"matius apry prastowo"
     * }
     *
     * @param user entity from user
     * @return
     * */

    @RequestMapping(method = RequestMethod.PUT)
    public Map edit(@RequestBody User user){
        return userService.edit(user);
    }

    /**
     * Api save user. Client must send data in JSON.
     * ex json :
     * {
     *      "email":"matius.prastowo@iconpln.co.id",
     *      "password":"P@ssw0rd123",
     *      "nama":"matius apry prastowo"
     * }
     * @param user entity form user
     * @return
     * */

    @RequestMapping(method = RequestMethod.POST)
    public Map save(@RequestBody User user){
        return userService.save(user);
    }

    /**
     * Api del user. The data will be delete from database.
     * user must input parameter id from user
     *
     * @param id id_user form table user
     * @return
     * */

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public Map del(@PathVariable Integer id){
        return userService.del(id);
    }

    /**
     * Method find for searching data user
     *
     * @param find this entity for keyword and value searching
     * @return
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
