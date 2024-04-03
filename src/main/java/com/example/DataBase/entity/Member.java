package com.example.DataBase.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "user_id", length = 50)
    private String id;

    @Column(name = "user_pwd", length = 50)
    private String pwd;

    @Column(name = "user_email", length = 100)
    private String email;

    public Member(JSONObject json) {
        this.id = (String) json.get("user_id");
        this.pwd = (String) json.get("user_pwd");
        this.email = (String) json.get("user_email");
    }

    public void update(String pwd, String email) {
        this.pwd = pwd;
        this.email = email;
    }
}
