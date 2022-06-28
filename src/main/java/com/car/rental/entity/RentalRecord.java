package com.car.rental.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "t_rental_record")
public class RentalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "car_id")
    private int carId;


    @Column(name = "user_id")
    private int userId;


    @Column(name = "work_id")
    private int workId;

    @Column(name = "total_car_rent")
    private BigDecimal totalCarRent;

    @Column(name = "identity_card")
    private String identityCard;

    @Column(name = "phone")
    private String phone;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "driving_number")
    private String drivingNumber;

    @Column(name = "remark")
    private String remark;

    @Column(name = "status")
    private int status;

    @Column(name = "rental_time")
    private Date rentalTime;

    @Column(name = "repaid_time")
    private Date repaidTime;

    public RentalRecord(){

    }


}
