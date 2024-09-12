package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import entity.Car;


//@RepositoryRestResource(path="cars")
public interface car_dealership_repo extends JpaRepository<Car,String>{


}
