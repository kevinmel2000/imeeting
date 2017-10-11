package com.imeeting.website.service.implement;

import com.imeeting.website.domain.User;
import com.imeeting.website.repository.UserDao;
import com.imeeting.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrapry on 10/10/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Map findOne(Integer id) {
        Map m = new HashMap();
        User user = userDao.findOne(id);
        if (user==null){
            m.put("response", -1);
            m.put("message","Data User not found");
        } else{
            m.put("response", 1);
            m.put("message",user);
        }
        return m;
    }

    @Override
    public Map findAllByEmail(String email) {
        Map m = new HashMap();
        User user = userDao.findAllByEmail(email);
        if (user==null){
            m.put("response", -1);
            m.put("message","Data User not found");
        } else{
            m.put("response", 1);
            m.put("message",user);
        }
        return m;
    }

    @Override
    public Map findAllByRole(String role) {
        Map m = new HashMap();
        User user = userDao.findAllByRole(role);
        if (user==null){
            m.put("response", -1);
            m.put("message","Data User not found");
        } else{
            m.put("response", 1);
            m.put("message",user);
        }
        return m;
    }

    @Override
    public Map save(User user) {
        Map m = new HashMap();
        User users = user;
        User data = userDao.findAllByEmail(users.getEmail());
        if (data==null){
            userDao.save(user);
            m.put("response", 1);
            m.put("message","Data User hasbeans save");
        } else{
            m.put("response", -1);
            m.put("message","Data user is exits");
        }
        return m;
    }

    @Override
    public Map del(Integer id) {
        Map m = new HashMap();
        User user = userDao.findAllById(id);
        if (user==null){
            userDao.delete(id);
            m.put("response", 1);
            m.put("message","Data User hasbeans deleted");
        } else{
            m.put("response", -1);
            m.put("message","Data user not found");
        }
        return m;
    }

    @Override
    public Map edit(User user) {
        Map m = new HashMap();
        User users = user;
        User data = userDao.findAllByEmail(users.getEmail());
        if (data==null){
            userDao.save(user);
            m.put("response", 1);
            m.put("message","Data User hasbeans edit");
        } else{
            m.put("response", -1);
            m.put("message","Data user not found");
        }
        return m;
    }

    @Override
    public Map getAll() {
        Map m = new HashMap();
        m.put("message",userDao.findAll());
        m.put("response",1);
        return m;
    }
}
