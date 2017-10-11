package com.imeeting.website.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by mrapry on 10/10/17.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String namaRole;

    public Role(String namaRole) {
        this.namaRole = namaRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaRole() {
        return namaRole;
    }

    public void setNamaRole(String namaRole) {
        this.namaRole = namaRole;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", namaRole='" + namaRole + '\'' +
                '}';
    }
}
