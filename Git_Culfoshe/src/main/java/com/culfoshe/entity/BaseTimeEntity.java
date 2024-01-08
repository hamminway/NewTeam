package com.culfoshe.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter @Setter
public abstract class BaseTimeEntity {

    @CreatedDate    //Entity가 생성되고 저장될 때 시간이 자동으로 저장된다.
    @Column(updatable = false)
    private LocalDateTime regTime;

    @LastModifiedDate   //Entity가 변경될 때 시간이 자동으로 저장
    private LocalDateTime updateTime;
}
