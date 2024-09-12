package service;

import entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.car_dealership_repo;

import java.util.List;

@Service
public class car_service_impl implements Car_service{

    private car_dealership_repo car;

    @Autowired
    public car_service_impl(car_dealership_repo car){
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