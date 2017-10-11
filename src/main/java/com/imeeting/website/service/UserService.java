package com.imeeting.website.service;

import com.imeeting.website.domain.User;

import java.util.Map;

/**
 * Created by mrapry on 10/10/17.
 */
public interface UserService {

    Map findOne(Integer id);
    Map save(User user);
    Map edit(User user);
    Map del(Integer id);
    Map findAllByEmail(String email);
    Map findAllByRole(String role);
    Map getAll();
}
