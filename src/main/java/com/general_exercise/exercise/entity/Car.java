package com.general_exercise.exercise.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="car_dealership")
public class Car {

    @Id
    @Column(name = "brand")
    private String brandName;

    @Column(name = "model")
    private String modelName;

    @Column(name = "year")
    private String year;

    @PrePersist
    public void prePersist() {
        // Generate a UUID if the id is not set before persisting the entity
        if (this.brandName == null) {
            this.brandName = UUID.randomUUID().toString();
        }
    }

    public Car(){

    }

    public Car(String brandName,String modelName, String year) {
       this.brandName = brandName;
        this.modelName = modelName;
        this.year = year;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", brand '" + brandName + '\'' +
                ", model'" + modelName + '\'' +
                ", year'" + year + '\'' +
                '}';
    }
}
