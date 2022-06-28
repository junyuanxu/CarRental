package com.car.rental.service.impl;

import com.car.rental.Util.UpdateColumnUtil;
import com.car.rental.entity.CarInfo;
import com.car.rental.entity.RentalRecord;
import com.car.rental.entity.UserInfo;
import com.car.rental.repository.RentalRecordRepository;
import com.car.rental.service.CarInfoService;
import com.car.rental.service.RentalRecordService;
import com.car.rental.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("RentalRecordService")
public class RentalRecordServiceImpl implements RentalRecordService {

    @Autowired
    private RentalRecordRepository rentalRecordRepository;





    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveRentalRecord(RentalRecord rentalRecord) throws Exception {


        rentalRecordRepository.save(rentalRecord);
    }

    private void rentalCar(RentalRecord rentalRecord, CarInfo carInfo) {

    }

    @Override
    public void updateRentalRecordById(RentalRecord rentalRecord) {
        //首先从数据库查出待更新对象
        RentalRecord target = rentalRecordRepository.findById(rentalRecord.getId()).orElse(new RentalRecord());
        //使用更新对象的非空值去覆盖待更新对象
        BeanUtils.copyProperties(rentalRecord, target, UpdateColumnUtil.getNullPropertyNames(rentalRecord));
        //执行更新操作
        rentalRecordRepository.save(target);
    }

    @Override
    public void deleteRentalRecordById(int rentalRecordId) {
        rentalRecordRepository.deleteById(rentalRecordId);
    }

    @Override
    public RentalRecord getRentalRecordById(int rentalRecordId) {
        Optional<RentalRecord> rentalRecord = rentalRecordRepository.findById(rentalRecordId);

        return Optional.ofNullable(rentalRecord).get().orElse(null);
    }

    @Override
    public List<RentalRecord> getRetalRecords() {
        return rentalRecordRepository.findAll();
    }

}
