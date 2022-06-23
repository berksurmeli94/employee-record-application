package com.emrap.app.dtos.department;

import java.math.BigDecimal;

public class updateLocationDto {

    private Long departmentId;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public updateLocationDto() {
    }

    public updateLocationDto(BigDecimal latitude, BigDecimal longitude, Long departmentId) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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
                " latitude='" + getLatitude() + "'" +
                ", longitude='" + getLongitude() + "'" +
                "}";
    }

}
