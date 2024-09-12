package com.general_exercise.exercise.rest;


import com.general_exercise.exercise.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.general_exercise.exercise.service.Car_service;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final Car_service carService;

    @Autowired
    public EmployeeRestController(Car_service theEmployeeService){
        carService = theEmployeeService;
    }

    @GetMapping("/cars")
    public List<Car> getEmployees(){

        return carService.findAll();
    }

//    @GetMapping ("/employees/{theId}")
//    public Car getEmployee(@PathVariable int theId){
//
//        Car theEmployee = carService.findById(theId);
//
//        if(theEmployee==null){
//
//            throw new RuntimeException("Employee id not found -" + theId);
//        }
//
//        return theEmployee;
//    }

//    //add mapping for POST /employees - add new empoloyee
//    @PostMapping("/employees")
//
//    public Car createEmployee(@RequestBody Car theEmployee){
//
//        //also just in case they pass an id in JSON ... set id to 0
//        //this is to force a save of new item ... instance of update
//
//        carService.
//
//        Car dbEmployee = carService.updateCars();
//
//        return dbEmployee;
//
//    }

    @PutMapping("/cars")

    public Car updateEmployee(@RequestBody Car updatedCar){

        Car dbCar = carService.save(updatedCar);
        return dbCar;
    }

//    @DeleteMapping("/employees/{theId}")
//
//    public String deleteEmployee(@PathVariable int theId){
//
//        Car tempEmployee = carService.findById(theId);
//
//        //throw exception if null
//
//        if (tempEmployee ==null){
//
//            throw new RuntimeException("Employee id not found -" + theId);
//        }
//
//        employeeService.deleteById(theId);
//
//        return "deleted employee id - " + theId;
//    }

}
