package com.emrap.app.dtos.employee;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class employeeCreateDto {

    @NotBlank(message = "The departmentId is required.")
    private long departmentId;
    @NotBlank(message = "The firstName is required.")
    @Size(min = 2, max = 100, message = "The length of firstName must be between 2 and 100 characters.")
    private String firstName;
    @NotBlank(message = "The lastName is required.")
    @Size(min = 2, max = 100, message = "The length of lastName must be between 2 and 100 characters.")
    private String lastName;
    @NotBlank(message = "The phoneNumber is required.")
    @Size(min = 2, max = 50, message = "The length of phoneNumber must be between 2 and 100 characters.")
    private String phoneNumber;
    @NotBlank(message = "The email is required.")
    @Size(min = 2, max = 100, message = "The length of email must be between 2 and 100 characters.")
    @Email
    private String email;
    @NotBlank(message = "The startDate is required.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @NotBlank(message = "The salary is required.")
    @DecimalMin(value = "0.00", message = "The salary must be greater than 0.")
    private BigDecimal salary;

    public employeeCreateDto() {
    }

    public employeeCreateDto(long departmentId, String firstName, String lastName, String phoneNumber, String email,
            Date startDate, BigDecimal salary) {
        this.departmentId = departmentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.startDate = startDate;
        this.salary = salary;
    }

    public long getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{" +
                " departmentId='" + getDepartmentId() + "'" +
                ", firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                ", email='" + getEmail() + "'" +
                ", startDate='" + getStartDate() + "'" +
                ", salary='" + getSalary() + "'" +
                "}";
    }

}
