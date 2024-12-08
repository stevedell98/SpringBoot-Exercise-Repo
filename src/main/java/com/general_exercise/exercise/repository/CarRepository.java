package com.general_exercise.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.general_exercise.exercise.entity.Car;


//@RepositoryRestResource(path="cars")
public interface CarRepository extends JpaRepository<Car,String>{


}
