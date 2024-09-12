package com.general_exercise.exercise.service;

import com.general_exercise.exercise.entity.Car;

import java.util.List;


public interface Car_service {

     List<Car> findAll();

    //public Car getCarbyId(String Id);

     Car save(Car carBrand);

    //public void deleteCar(String Id);
}

