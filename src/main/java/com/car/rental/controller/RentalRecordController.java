package com.car.rental.controller;

import com.car.rental.common.CommonResult;
import com.car.rental.entity.CarInfo;
import com.car.rental.entity.RentalRecord;
import com.car.rental.service.CarInfoService;
import com.car.rental.service.RentalRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value="/rental")
public class RentalRecordController {

    @Autowired
    private RentalRecordService rentalRecordService;

    @Autowired
    private CarInfoService carInfoService;



    @RequestMapping(value="/records", method= RequestMethod.GET)
    public List<RentalRecord> getRentalRecordList() {
        return rentalRecordService.getRetalRecords();
    }

    @RequestMapping(value="/record", method=RequestMethod.POST)
    public CommonResult postRentalRecord(@RequestBody RentalRecord rentalRecord) {
        try{
            CarInfo carInfo = carInfoService.getCarInfoById(rentalRecord.getCarId());
            if (carInfo.getStatus() == 1){
                rentalRecordService.saveRentalRecord(rentalRecord);
            }else {
                throw new RuntimeException("The car has rental");
            }
            return CommonResult.success("success");
        }catch (Exception ex){
            log.info("rental car is fail,error is {}",ex);
            return CommonResult.error("fail");
        }


    }

    @RequestMapping(value="/record/{id}", method=RequestMethod.GET)
    public RentalRecord getRentalRecord(@PathVariable int id) {
        return rentalRecordService.getRentalRecordById(id);
    }

    @RequestMapping(value="/record", method=RequestMethod.PUT)
    public String putRentalRecord(@RequestBody RentalRecord rentalRecord) {
        rentalRecordService.updateRentalRecordById(rentalRecord);
        return "success";
    }

    @RequestMapping(value="/record/{id}", method=RequestMethod.DELETE)
    public String deleteRentalRecord(@PathVariable int id) {
        rentalRecordService.deleteRentalRecordById(id);
        return "success";
    }


}
