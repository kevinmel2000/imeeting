package com.imeeting.website.service;


import com.imeeting.website.domain.Role;

import java.util.Map;

/**
 * Created by mrapry on 10/10/17.
 */
public interface RoleService {

    Map findOne(Integer id);
    Map save(Role role);
    Map edit(Role role);
    Map del(Integer id);
    Map getAll();
}
