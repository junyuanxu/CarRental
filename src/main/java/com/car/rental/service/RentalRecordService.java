package com.car.rental.service;

import com.car.rental.entity.RentalRecord;

import java.util.List;

public interface RentalRecordService {

    void saveRentalRecord(RentalRecord RentalRecord) throws Exception;

    void updateRentalRecordById(RentalRecord RentalRecord);

    void deleteRentalRecordById(int RentalRecordId);

    RentalRecord getRentalRecordById(int RentalRecordId);

    List<RentalRecord> getRetalRecords();
}
