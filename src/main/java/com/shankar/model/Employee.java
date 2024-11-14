package com.shankar.model;

import java.util.Optional;
import com.shankar.enums.Gender;

public class Employee {
    private int id;
    private String name;
    private String mobileNumber; // Change to camelCase
    private String emailId;
    private Gender gender;
    private Integer departmentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getMobileNumber() { // Change to camelCase
        return Optional.ofNullable(mobileNumber);
    }

    public void setMobileNumber(String mobileNumber) { // Change to camelCase
        this.mobileNumber = mobileNumber;
    }

    public Optional<String> getEmailId() {
        return Optional.ofNullable(emailId);
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Optional<Gender> getGender() {
        return Optional.ofNullable(gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Optional<Integer> getDepartmentId() {
        return Optional.ofNullable(departmentId);
    }

    public void setDepartmentId(Integer departmentId) { // Change parameter type to Integer
        this.departmentId = departmentId; // Allow nulls
    }
}