package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleMakeRepository extends CrudRepository<VehicleMake, Integer> {
    List<VehicleModel> findVehicleModelById(Integer id);
}
