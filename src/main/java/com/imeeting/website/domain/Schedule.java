package com.imeeting.website.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by mrapry on 10/10/17.
 */
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    private Date timeStart;
    private Date timeEnd;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private User user;

    public Schedule(String title, String description, Date timeStart, Date timeEnd, User user) {
        this.title = title;
        this.description = description;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.user = user;
    }

    public Schedule() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
