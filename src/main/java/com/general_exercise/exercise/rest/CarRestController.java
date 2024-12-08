package com.general_exercise.exercise.rest;


import com.general_exercise.exercise.ExceptionHandling.CarNotFoundException;
import com.general_exercise.exercise.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.general_exercise.exercise.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarRestController {

    private CarRepository carService;

    @Autowired
    public CarRestController(CarRepository theCarService) {
        carService = theCarService;
    }

    @GetMapping("/cars")
    public List<Car> getCars() {

        return carService.findAll();
    }

    @GetMapping("/cars/{theId}")
    public Optional<Car> getCarById(@PathVariable String theId) {

        Optional<Car> theCar = carService.findById(theId);
        if (theCar.isEmpty()) {
           throw new CarNotFoundException("car not found" + theId);

        } else

            return theCar;
    }

    @PostMapping("/cars")
    public Car createCar(@RequestBody Car theCar){

        return carService.save(theCar);
    }

    @PutMapping("/cars")
    public Car updateCar(@RequestBody Car theCar){

        return carService.save(theCar);
    }

    @DeleteMapping("/cars/theId")
    public void deleteCarById(@PathVariable String theId){

        if(theId != null) {
            carService.deleteById(theId);
        }
        else
            throw new CarNotFoundException("car not found" + theId);
    }
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

//    @PutMapping("/employees")
//
//    public Car updateEmployee(@RequestBody Car updatedEmployee){
//
//
//        return carService.updateCars(updatedEmployee);
//    }

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
