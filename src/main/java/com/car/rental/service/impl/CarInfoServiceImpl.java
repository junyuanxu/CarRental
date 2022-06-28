package com.car.rental.service.impl;

import com.car.rental.Util.UpdateColumnUtil;
import com.car.rental.entity.CarInfo;
import com.car.rental.repository.CarInfoRepository;
import com.car.rental.service.CarInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("carInfoService")
public class CarInfoServiceImpl implements CarInfoService {

    @Autowired
    private CarInfoRepository carInfoRepository;


    @Override
    public void saveCarInfo(CarInfo carInfo) {
        carInfo.setModifyTime(new Date());
        carInfoRepository.save(carInfo);
    }

    @Override
    public void updateCarInfoById(CarInfo carInfo) {
        CarInfo target = carInfoRepository.findById(carInfo.getCar_id()).orElse(new CarInfo());
        BeanUtils.copyProperties(carInfo, target, UpdateColumnUtil.getNullPropertyNames(carInfo));
        target.setModifyTime(new Date());
        carInfoRepository.save(target);
    }

    @Override
    public void deleteCarInfoById(int carInfoId) {
        carInfoRepository.deleteById(carInfoId);
    }

    @Override
    public CarInfo getCarInfoById(int carInfoId) {
        Optional<CarInfo> carInfoOptional = carInfoRepository.findById(carInfoId);

        return Optional.ofNullable(carInfoOptional).get().orElse(null);
    }

    @Override
    public List<CarInfo> getCarInfos() {
        return carInfoRepository.findAll();
    }


}
