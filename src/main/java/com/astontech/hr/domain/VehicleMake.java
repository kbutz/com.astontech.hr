package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class VehicleMake {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleMakeId")
    private Integer id;

    @Version
    private Integer version;

    private String vehicleMakeName;

//    @JoinColumn(name="VehicleMakeId")
//    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<VehicleModel> vehicleModelList;

    public VehicleMake(){}
    public VehicleMake(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getVehicleMakeName() {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

//    public List<VehicleModel> getVehicleModels() {
//        return vehicleModelList;
//    }
//    public void setVehicleModelList(List<VehicleModel> vehicleModelList){
//        this.vehicleModelList = vehicleModelList;
//    }
}
