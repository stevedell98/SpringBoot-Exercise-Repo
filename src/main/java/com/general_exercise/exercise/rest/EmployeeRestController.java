package com.general_exercise.exercise.rest;


import com.general_exercise.exercise.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.general_exercise.exercise.service.Car_service;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final Car_service carService;

    @Autowired
    public EmployeeRestController(Car_service theEmployeeService) {
        this.carService = theEmployeeService;
    }

    @GetMapping("/cars")
    public List<Car> getEmployees() {

        return carService.findAll();
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable String id) {

        Car theCar = carService.findById(id);

        if (id == null) {

            throw new RuntimeException("Employee id not found -" + id);
        }

        return theCar;
    }

    //add mapping for POST /employees - add new empoloyee
    @PostMapping("/cars")

    public Car createEmployee(@RequestBody Car theCar) {

        //also just in case they pass an id in JSON ... set id to 0
        //this is to force a save of new item ... instead of update


        Car newCar = carService.save(theCar);

        return newCar;

    }

    @PutMapping("/cars")

    public Car updateEmployee(@RequestBody Car updatedCar) {

        Car upCar = carService.save(updatedCar);

        return upCar;
    }

    @DeleteMapping("/cars/{theId}")

    public String deleteEmployee(@PathVariable String theId) {


        Car delCar = carService.findById(theId);

        if (theId == null) {

            return ("cannot delete a non existing Car object!");

        } else {

            carService.deleteCar(theId);

            return ("deleted car:\n" + delCar.getBrandName() + "\n" + delCar.getModelName() + "\n" + delCar.getYear());
        }
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
}