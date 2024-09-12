package com.general_exercise.exercise.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.general_exercise.exercise.entity.Car;


//@RepositoryRestResource(path="cars")
public interface car_dealership_repo extends JpaRepository<Car,String>{


}
