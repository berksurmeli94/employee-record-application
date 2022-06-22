package com.emrap.app.entities;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE employees SET deleted = true WHERE id = ?")
public class Employee extends BaseEntity {

    private long departmentId;
    @Column(name = "firstName", length = 50)
    private String firstName;
    @Column(name = "lastName", length = 50)
    private String lastName;
    @Column(name = "phoneNumber", length = 50)
    private String phoneNumber;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "password", length = 50)
    private String password;

    public Employee() {
    }

    public Employee(long departmentId, String firstName, String lastName, String phoneNumber, String email,
            String password) {
        this.departmentId = departmentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                " departmentId='" + getDepartmentId() + "'" +
                ", firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                ", email='" + getEmail() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }

}
