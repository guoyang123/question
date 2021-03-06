package com.neuedu.entity;

import java.io.Serializable;

public class Quser implements Serializable
{

    private Integer id;
    private String username;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Quser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
