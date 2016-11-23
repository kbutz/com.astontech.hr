package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.impl.VehicleMakeServiceImpl;
import com.astontech.hr.services.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleServiceImpl vehicleServiceImpl;

    @Autowired
    private VehicleMakeServiceImpl vehicleMakeServiceimpl;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        generateElementAndElementTypes();
        //just a fucking test
    }

    private void generateElementAndElementTypes() {
        ElementType laptopType = new ElementType("Laptop");

        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));

        laptopType.setElementList(elementList);

        elementTypeService.saveElementType(laptopType);

        Vehicle newVehicle = new Vehicle("12345ABC");
        newVehicle.setColor("red");
        newVehicle.setVIN("VIN11100");
        newVehicle.setVehicleYear(1999);

        VehicleModel newVehicleModel = new VehicleModel();
        newVehicleModel.setVehicleModelName("4Runner");
        newVehicleModel.setVehicleMake(new VehicleMake("Toyota"));
        newVehicle.setVehicleModel(newVehicleModel);

        vehicleServiceImpl.saveVehicle(newVehicle);

        newVehicle = new Vehicle("12345ABC");
        newVehicle.setColor("white");
        newVehicle.setVIN("VIN333100");
        newVehicle.setVehicleYear(1997);

        newVehicleModel = new VehicleModel();
        newVehicleModel.setVehicleModelName("Elektra");
        newVehicleModel.setVehicleMake(new VehicleMake("Ford"));
        newVehicle.setVehicleModel(newVehicleModel);

        vehicleServiceImpl.saveVehicle(newVehicle);

        newVehicle = new Vehicle("12345ABC");
        newVehicle.setColor("white");
        newVehicle.setVIN("VIN11100");
        newVehicle.setVehicleYear(1997);

        newVehicleModel = new VehicleModel();
        newVehicleModel.setVehicleModelName("Highlander");
        newVehicleModel.setVehicleMake(new VehicleMake("Toyota"));
        newVehicle.setVehicleModel(newVehicleModel);

        vehicleServiceImpl.saveVehicle(newVehicle);
    }

}
