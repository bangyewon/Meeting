package com.example.Meeting.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Created_at과 update_at 설정해야하는 이유
 * : 데이터 무결성(데이터 추적) , 재사용 가능성 , 로직 구현 편리
 * 되도록 BaseEntity 구현하자
 */
@MappedSuperclass // 상속관계에 있는 엔티티에 공통속성 설정시
@EntityListeners(AuditingEntityListener.class) // 엔티티의 생성,수정 시간을 자동으로 처리할때 사용
public class BaseEntity {
    @CreatedDate // 엔티티 생성시 자동으로 현재 시간 설정
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
