package com.imeeting.website.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by mrapry on 10/10/17.
 */
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String pertanyaan;
    private String jawaban;
    private Boolean status;
    private String dateCreate;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private User user;

    public Question(String pertanyaan, String jawaban, Boolean status, String dateCreate, User user) {
        this.pertanyaan = pertanyaan;
        this.jawaban = jawaban;
        this.status = status;
        this.dateCreate = dateCreate;
        this.user = user;
    }

    public Question() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
