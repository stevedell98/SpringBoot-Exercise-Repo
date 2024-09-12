package com.general_exercise.exercise.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="car")
public class Car {

    @Id
    @Column(name = "brand")
    private String brandName;

    @Column(name = "model")
    private String modelName;

    @Column(name = "year")
    private String year;

    public Car(){

    }

    public Car(String modelName, String year) {
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
