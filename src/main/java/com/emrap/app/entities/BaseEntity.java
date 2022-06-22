package com.emrap.app.entities;

import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "deleted")
    private boolean deleted = false;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date UpdatedAt;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.UpdatedAt;
    }

    public void setUpdatedAt(Date UpdatedAt) {
        this.UpdatedAt = UpdatedAt;
    }
}
