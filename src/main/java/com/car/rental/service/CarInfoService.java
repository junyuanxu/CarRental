package com.car.rental.service;

import com.car.rental.entity.CarInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarInfoService {

    void saveCarInfo(CarInfo carInfo);

    void updateCarInfoById(CarInfo carInfo);

    void deleteCarInfoById(int carInfoId);

    CarInfo getCarInfoById(int carInfoId);

    List<CarInfo> getCarInfos();


}
