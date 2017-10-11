package com.imeeting.website.repository;

import com.imeeting.website.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mrapry on 10/10/17.
 */
public interface UserDao extends JpaRepository<User, Integer>{

    User findAllById (Integer id);
    User findAllByEmail(String email);
    User findAllByRole(String role);
}
