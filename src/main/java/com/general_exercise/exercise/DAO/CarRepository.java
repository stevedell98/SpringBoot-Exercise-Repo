package com.general_exercise.exercise.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.general_exercise.exercise.entity.Car;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//@RepositoryRestResource(path="cards")
public interface CarRepository extends JpaRepository<Car,String>{


}
