package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VehicleModeLServiceImpl implements VehicleModelService {

    @Autowired
    VehicleModelRepository vehicleModelRepository;

    @Override
    public Iterable<VehicleModel> listAllVehicles() {
        return vehicleModelRepository.findAll();
    }

    @Override
    public VehicleModel getVehicleModelById(Integer id) {
        return vehicleModelRepository.findOne(id);
    }

    @Override
    public VehicleModel findVehicleModelByName(String vehicleModelName) {
        return vehicleModelRepository.findVehicleModelByVehicleModelName(vehicleModelName);
    }

    @Override
    public VehicleModel saveVehicleModel(VehicleModel vehicleModel) {
        return null;
    }

    @Override
    public Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModelIterable) {
        return null;
    }

    @Override
    public void deleteVehicleModel(Integer id) {

    }
}
