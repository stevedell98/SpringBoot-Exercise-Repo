package com.general_exercise.exercise.service;

import com.general_exercise.exercise.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.general_exercise.exercise.repository.CarRepository;

import java.util.List;

@Service
public class car_service_impl implements Car_service{

    private CarRepository car;

    @Autowired
    public car_service_impl(CarRepository car){
        this.car= car;

    }

    @Override
     public List<Car> findAll() {

        return  car.findAll();

    }

//    @Override
//public Car getCarbyId(String Id){
//
//    return carService.getCarbyId(Id);
//
//    }

//@Override
//    public Car updateCars(Car carBrand){
//        return car.save(carBrand);
//    }

//    public void deleteCar(String Id){
//        carService.deleteCar(Id);
//    }
}