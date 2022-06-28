package com.car.rental.repository;

import com.car.rental.entity.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInfoRepository extends JpaRepository<CarInfo,Integer> {

}
