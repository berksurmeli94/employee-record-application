package com.emrap.app.dtos;

public class FilterRequestDto {
    private int pageNumber = 1;
    private int pageSize = 15;

    public FilterRequestDto() {
    }

    public FilterRequestDto(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "{" +
                " pageNumber='" + getPageNumber() + "'" +
                ", pageSize='" + getPageSize() + "'" +
                "}";
    }

}
