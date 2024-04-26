package com.example.DataBase.unused.entity;

import com.example.DataBase.server.entity.commonEntityImpl;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User extends commonEntityImpl {

    @Id
    @Column(name = "user_id", length = 50)
    private String id;

    @Column(name = "user_pwd", length = 50)
    private String pwd;

    @Column(name = "user_email", length = 100)
    private String email;

    public User(JsonObject json) {
        this.id = json.get("user_id").getAsString();
        this.pwd = json.get("user_pwd").getAsString();
        this.email = json.get("user_email").getAsString();
    }

    public void update(String pwd, String email) {
        this.pwd = pwd;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User[id = " + getId() + ", pwd = " + getPwd() + ", email = " + getEmail() + "]";
    }
}
