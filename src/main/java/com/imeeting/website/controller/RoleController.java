package com.imeeting.website.controller;

import com.imeeting.website.domain.Find;
import com.imeeting.website.domain.Role;
import com.imeeting.website.service.implement.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by elvan on 12/10/17.
 */
@RestController
@RequestMapping(value = "api/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    /**
     * Api get data all. We dont need PSS(Pagging, sorting, searching) because the bispro dont have more of role.
     * @return
     * */
    @RequestMapping(method = RequestMethod.GET)
    public Map getAll() {
        return roleService.getAll();
    }

    /**
     * Api update data role. client must send the data in JSON
     * ex JSON :
     * {
     *     "id":"1211",
     *      "email":"matius.prastowo@iconpln.co.id",
     *      "password":"P@ssw0rd123",
     *      "nama":"matius apry prastowo"
     * }
     *
     * @param role entity from role
     * @return
     * */
    @RequestMapping(method = RequestMethod.PUT)
    public Map edit(@RequestBody Role role){
        return roleService.edit(role);
    }

    /**
     * Api save data role. client must send data in JSON
     * ex JSON:
     * {
     *      "email":"matius.prastowo@iconpln.co.id",
     *      "password":"P@ssw0rd123",
     *      "nama":"matius apry prastowo"
     * }
     * @param role entity from role
     * @return
     * */
    @RequestMapping(method = RequestMethod.POST)
    public Map save (@RequestBody Role role){
        return roleService.save(role);
    }

    /**
     * Api del data role. The data will be delete from database.
     * client must input id parameter from role
     *
     * @param id id_role form role
     * @return
     */
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public Map del(@PathVariable Integer id){
        return roleService.del(id);
    }

    /**
     * Method find for searching data role
     *
     * @param find this entity is keyword and value of search data role
     * @return
     * */
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public Map find(@RequestBody Find find) {
        if (find.getKey().equals("id")){
            return roleService.findOne(Integer.parseInt(find.getValue()));
        } else {
            Map m = new HashMap();
            m.put("message","Keyword not found");
            m.put("response", -1);
            return m;
        }
    }
}
