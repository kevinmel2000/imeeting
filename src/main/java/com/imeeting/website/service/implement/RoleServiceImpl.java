package com.imeeting.website.service.implement;

import com.imeeting.website.domain.Role;
import com.imeeting.website.repository.RoleDao;
import com.imeeting.website.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrapry on 10/10/17.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Map findOne(Integer id) {
        Map m = new HashMap();
        Role Roles = roleDao.findOne(id);
        if (Roles==null){
            m.put("message","Data Role not found");
            m.put("response",-1);
        }else{
            m.put("message",Roles);
            m.put("response",1);
        }
        return m;
    }

    @Override
    public Map save(Role role) {
        Map m = new HashMap();
        roleDao.save(role);
        m.put("message","Data Role hasben saved");
        m.put("response",1);
        return m;
    }

    @Override
    public Map edit(Role Role) {
        Map m = new HashMap();
        roleDao.save(Role);
        m.put("message","Data Role hasben edited");
        m.put("response",1);
        return m;
    }

    @Override
    public Map del(Integer id) {
        Map m = new HashMap();
        roleDao.delete(id);
        m.put("message","Data Role hasben deleted");
        m.put("response",1);
        return m;
    }

    @Override
    public Map getAll() {
        Map m = new HashMap();
        m.put("message",roleDao.findAll());
        m.put("response",1);
        return m;
    }
}
