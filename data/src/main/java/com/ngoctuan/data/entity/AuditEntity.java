package com.ngoctuan.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity implements Serializable {

    @CreatedBy
    @Column(updatable = false, name = "created_user")
    protected Long createdUser;

    @CreatedDate
    @Column(updatable = false, name = "created_date")
    protected LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "updated_user")
    protected Long updatedUser;

    @LastModifiedDate
    @Column(name = "updated_date")
    @Builder.Default
    protected LocalDateTime updatedDate = LocalDateTime.now();
}

