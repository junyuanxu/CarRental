package com.car.rental.controller;

import com.car.rental.entity.CarInfo;
import com.car.rental.service.CarInfoService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/carInfo")
public class CarInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarInfoController.class);

    @Autowired
    private CarInfoService carInfoService;

    @PostMapping(value = "")
    public String saveCity(@RequestBody CarInfo carInfo){
        carInfoService.saveCarInfo(carInfo);
        return "success";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteCity(int carInfoId){
        carInfoService.deleteCarInfoById(carInfoId);
        return "success";
    }

    @PutMapping(value = "")
    public String updateCity(@RequestBody CarInfo carInfo){
        carInfoService.updateCarInfoById(carInfo);
        return "success";
    }


    @GetMapping(value = "/{id}")
    public String getCityById(int carInfoId){
        LOGGER.info("getCarInfoById is {}",carInfoId);
        CarInfo carInfo = carInfoService.getCarInfoById(carInfoId);
        Gson gson=new Gson();
        return gson.toJson(carInfo);
    }

}
