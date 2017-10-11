package com.imeeting.website.repository;

import com.imeeting.website.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mrapry on 10/10/17.
 */
public interface ScheduleDao extends JpaRepository<Schedule, Integer>{

}
