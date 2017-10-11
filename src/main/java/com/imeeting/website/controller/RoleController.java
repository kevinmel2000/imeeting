package com.imeeting.website.controller;

import com.imeeting.website.service.implement.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrapry on 10/11/17.
 */
@RestController
@RequestMapping(value = "/api/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @RequestMapping(method = RequestMethod.GET)
    public Map getAll(){
        return roleService.getAll();
    }
}
