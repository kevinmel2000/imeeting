package com.imeeting.website.repository;

import com.imeeting.website.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mrapry on 10/10/17.
 */
public interface RoleDao extends JpaRepository<Role, Integer> {
}
