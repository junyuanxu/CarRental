package com.car.rental.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="t_car_info")
public class CarInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int car_id;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "car_brand")
    private String carBrand;


    @Column(name = "car_model")
    private String carModel;


    @Column(name = "car_image_id")
    private String carImageId;

    @Column(name = "car_price")
    private BigDecimal carPrice;

    @Column(name = "car_color")
    private String carColor;

    @Column(name = "car_rent")
    private int carRent;

    @Column(name = "status")
    private int status;

    @Column(name = "modify_time")
    private Date modifyTime;

    public CarInfo(){

    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarImageId() {
        return carImageId;
    }

    public void setCarImageId(String carImageId) {
        this.carImageId = carImageId;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getCarRent() {
        return carRent;
    }

    public void setCarRent(int carRent) {
        this.carRent = carRent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
