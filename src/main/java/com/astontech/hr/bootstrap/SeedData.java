package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.EmployeeService;
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
    private EmployeeService employeeService;

    @Autowired
    private VehicleMakeServiceImpl vehicleMakeServiceimpl;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //generateElementAndElementTypes();
        //generateEmployees();
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

    private void generateEmployees() {

        Employee employee = new Employee();
        employee.setFirstName("KyleB");
        employee.setLastName("Butz");
        employee.setBackground("Java Dev");
        employeeService.saveEmployee(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Steve");
        employee1.setLastName("Irwin");
        employee1.setBackground("Java Dev");
        employeeService.saveEmployee(employee1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Dane");
        employee2.setLastName("Dyer");
        employee2.setBackground("Java Dev");
        employeeService.saveEmployee(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Hello");
        employee3.setLastName("World");
        employee3.setBackground(".NET dev");
        employeeService.saveEmployee(employee3);

        Employee employee4 = new Employee();
        employee4.setFirstName("Kyle");
        employee4.setLastName("Butz");
        employee4.setBackground("python dev");
        employeeService.saveEmployee(employee4);

    }

}




























