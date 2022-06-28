package com.car.rental.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name="t_user")
public class UserInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "role")
    private int role;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "create_time")
    private Date createTime;

    public UserInfo(){
    }

}
