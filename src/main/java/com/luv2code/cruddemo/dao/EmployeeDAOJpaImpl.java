package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    //define field for entitymanager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> employees = entityManager.createQuery("from Employee",Employee.class);
        //execute query and get result list
        return employees.getResultList();
    }


    @Override

    public Employee findById(int theId){

        //get employee by Id
        Employee theEmployee = entityManager.find(Employee.class,theId);

        return theEmployee;
    }

    @Override

    public Employee save(Employee theEmployee){

        //save employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        //return the dbEmployee
        return dbEmployee;
    }

    @Override

    public void deleteById(int theId){

        Employee theEmployee = entityManager.find(Employee.class,theId);

        entityManager.remove(theEmployee);

    }
}
