package com.emrap.app.entities;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
@Where(clause = "deleted='false'")
@SQLDelete(sql = "UPDATE departments SET deleted = true WHERE id = ?")
public class Department extends BaseEntity {

    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "description", length = 100)
    private String description;

    public Department() {
        super();
    }

    public Department(String name, String description) {
        super();
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                "}";
    }
}
