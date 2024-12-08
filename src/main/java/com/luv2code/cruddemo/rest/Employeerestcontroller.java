package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.entity.Employee;
import com.luv2code.cruddemo.exceptionHandling.EmployeeErrorResponse;
import com.luv2code.cruddemo.exceptionHandling.EmployeeNotFoundException;
import com.luv2code.cruddemo.service.EmployeeService;
import jakarta.servlet.FilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Employeerestcontroller {

    private EmployeeService employeeService;

    @Autowired
    public Employeerestcontroller(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {

        return employeeService.findAll();
    }

    @GetMapping("/employees/{theId}")
    public Employee getEmployee(@PathVariable int theId) {

        if (theId <= 0 || theId > 28) {
            throw new EmployeeNotFoundException("employee not found" + theId);
        } else {
            Employee theEmployee = employeeService.findById(theId);

//        if(theEmployee==null){
//
//            throw new RuntimeException("Employee id not found -" + theId);
//        }

            return theEmployee;
        }
    }

    //add mapping for POST /employees - add new empoloyee
    @PostMapping("/employees")

    public Employee createEmployee(@RequestBody Employee theEmployee) {

        //also just in case they pass an id in JSON ... set id to 0
        //this is to force a save of new item ... instance of update

        theEmployee.setId(0);

        return employeeService.save(theEmployee);

    }

    @PutMapping("/employees")

    public Employee updateEmployee(@RequestBody Employee updatedEmployee) {

        Employee updatedEmpl = employeeService.save(updatedEmployee);

        return updatedEmpl;
    }

    @DeleteMapping("/employees/{theId}")

    public String deleteEmployee(@PathVariable int theId) {

        Employee tempEmployee = employeeService.findById(theId);

        //throw exception if null

        if (tempEmployee == null) {

            throw new RuntimeException("Employee id not found -" + theId);
        }

        employeeService.deleteById(theId);

        return "deleted employee id - " + theId;
    }

}
