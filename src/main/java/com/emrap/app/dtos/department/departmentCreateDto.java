package com.emrap.app.dtos.department;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class departmentCreateDto {

    @NotBlank(message = "The name is required.")
    @Size(min = 2, max = 100, message = "The length of name must be between 2 and 100 characters.")
    private String name;
    @NotBlank(message = "The description is required.")
    @Size(min = 2, max = 150, message = "The length of description must be between 2 and 150 characters.")
    private String description;
    @NotBlank(message = "The latitude is required.")
    private BigDecimal latitude;
    @NotBlank(message = "The longitude is required.")
    private BigDecimal longitude;

    public departmentCreateDto() {
    }

    public departmentCreateDto(String name, String description, BigDecimal latitude, BigDecimal longitude) {

        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getLatitude() {
        return this.latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return this.longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", latitude='" + getLatitude() + "'" +
                ", longitude='" + getLongitude() + "'" +
                "}";
    }
}
