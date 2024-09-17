package com.general_exercise.exercise.service;

import com.general_exercise.exercise.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.general_exercise.exercise.DAO.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImplementation implements Car_service{

    private CarRepository car;

    @Autowired
    public CarServiceImplementation(CarRepository car){
        this.car= car;

    }

    @Override

     public List<Car> findAll() {

        return  car.findAll();

    }

    @Override
public Car findById(String Id){
        Optional<Car> result = car.findById(Id);

        Car theCar = null;

        if(result.isPresent()){
            theCar = result.get();
        }
        else

            throw new RuntimeException("Did not find car id- " + Id);

        return theCar;
    }

    @Override
    public Car createNewCar(Car theCar){

        Car newCar = car.save(theCar);

        return newCar;

    }
    @Override
    public Car save(Car updatedCar){

        return car.save(updatedCar);
    }

    //alternative chat gpt way for Update method!
//    Optional<Car> existingCar = car.findById(id);
//
//    if(existingCar.isPresent()){
//        Car upCar = existingCar.get();
//        upCar.setBrandName(updatedCar.getBrandName());
//        upCar.setModelName(updatedCar.getModelName());
//        upCar.setYear(updatedCar.getYear());
//        return car.save(upCar);
//    }
//    else
//        throw new RuntimeException("Product with id" + id +"not found");
//   }



    public void deleteCar(String Id){

        car.deleteById(Id);
    }
}