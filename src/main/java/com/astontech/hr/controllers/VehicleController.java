package com.astontech.hr.controllers;

import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    private Logger logger = Logger.getLogger(VehicleController.class);;

    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
     public String adminVehicleList(Model model) {
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicleList", vehicleService.listAllVehicles());

        return "admin/vehicle/vehicle_list";
    }

    @RequestMapping(value = "/admin/vehicle/list/{success}", method = RequestMethod.GET)
    public String adminVehicleAddSuccess(@PathVariable String success, Model model) {
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicleList", vehicleService.listAllVehicles());
        if(success.compareTo("success") == 0){
            model.addAttribute("successAlert", "visible");
        } else if (success.compareTo("warning") == 0) {
            model.addAttribute("warningAlert", "visible");
        } else {
            model.addAttribute("errorAlert", "visible");
        }
        return "admin/vehicle/vehicle_list";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.POST)
    public String adminAddVehicle(VehicleVO vehicleVO, Model model) {
        saveVehicleFromVehicleVO(vehicleVO);
        model.addAttribute("vehicleList", vehicleService.listAllVehicles());
        return "redirect:/admin/vehicle/list/success";
    }

    @RequestMapping(value = "/admin/vehicle/edit/{id}", method = RequestMethod.GET)
    public String vehicleEditGet(@PathVariable String id, Model model) {
        try {
            Integer idInt = Integer.parseInt(id);
            if (vehicleService.getVehicleById(idInt) == null)
                return "redirect:/admin/vehicle/list/editErrorVehicleNotFound";
            else {
                Vehicle vehicle = vehicleService.getVehicleById(idInt);
                model.addAttribute("vehicleAttribute", vehicle);
                return "admin/vehicle/vehicle_edit";
            }
        } catch (NumberFormatException e) {
            logger.error(e);
            return "redirect:/admin/vehicle/list/editErrorNumberFormat";
        }
    }

    @RequestMapping(value = "/admin/vehicle/update", method = RequestMethod.POST)
    public String vehicleUpdate(Vehicle vehicle) {

        vehicleService.saveVehicle(vehicle);

        return "redirect:/admin/vehicle/list/success";
    }

    @RequestMapping(value = "/admin/vehicle/delete/{id}", method = RequestMethod.GET)
    public String vehicleDelete(@PathVariable String id) {
        try {
            Integer idInt = Integer.parseInt(id);
            vehicleService.deleteVehicle(idInt);
            return "redirect:/admin/vehicle/list/success";
        } catch (NumberFormatException e) {
            logger.error(e);
            return "redirect:/admin/vehicle/list/deleteErrorNumberFormat";
        } catch (EmptyResultDataAccessException e) {
            logger.error(e);
            return "redirect:/admin/vehicle/list/deleteErrorVehicleNotFound";
        }
    }

    // Helper Methods
    public void saveVehicleFromVehicleVO(VehicleVO vehicleVO){
        Vehicle newVehicle = new Vehicle();

        VehicleModel newVehicleModel = new VehicleModel();

//        VehicleModel findByName = vehicleModelService.findVehicleModelByName(vehicleVO.getNewVehicleModel());
//        if (findByName.getVehicleModelName().equals(vehicleVO.getNewVehicleModel())){
//            System.out.println(findByName.getId());
//            newVehicleModel.setId(findByName.getId());
//            newVehicleModel.setVehicleModelName(findByName.getVehicleModelName());
//            newVehicleModel.getVehicleMake().setVehicleMakeName(vehicleVO.getNewVehicleMake());
//        } else {}

        newVehicleModel.getVehicleMake().setVehicleMakeName(vehicleVO.getNewVehicleMake());
        newVehicleModel.setVehicleModelName(vehicleVO.getNewVehicleModel());

        newVehicle.setVehicleModel(newVehicleModel);

        newVehicle.setLicensePlate(vehicleVO.getNewLicensePlate());
        newVehicle.setVIN(vehicleVO.getNewVIN());
        newVehicle.setVehicleYear(vehicleVO.getNewVehicleYear());
        newVehicle.setColor(vehicleVO.getNewColor());


        vehicleService.saveVehicle(newVehicle);
    }
}
