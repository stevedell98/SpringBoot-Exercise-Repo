package com.general_exercise.exercise.service;

import com.general_exercise.exercise.entity.Car;

import java.util.List;
import java.util.Optional;


public interface Car_service {

     List<Car> findAll();

    Car findById(String Id);

    Car createNewCar(Car theCar);

     Car save(Car updatedCar);

    public void deleteCar(String Id);
}

