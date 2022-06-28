package com.car.rental.repository;

import com.car.rental.entity.CarInfo;
import com.car.rental.entity.RentalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRecordRepository extends JpaRepository<RentalRecord,Integer> {


}
