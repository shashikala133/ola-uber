package org.example.service;

import org.example.model.Driver;

import java.util.HashMap;
import java.util.Map;

public class DriverService {

    Map<String, Driver> map=new HashMap<>();

    public Driver registerDriver(String id,String name){
        Driver driver=new Driver(id,name);
        map.put(id,driver);
        return driver;
    }

    public Driver getDriverById(String id){
        return map.get(id);
    }
}
