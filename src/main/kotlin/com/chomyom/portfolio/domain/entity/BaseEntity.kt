package com.chomyom.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

// 공통 필드를 가진 엔티티를 위한 추상 클래스
@MappedSuperclass
abstract class BaseEntity {

    // 엔티티가 최초 저장될 때 자동으로 생성되는 시간 (생성일시)
    @CreatedDate
    @Column(nullable = false, updatable = false) // null 허용 X, 최초 생성 후 수정 불가
    var createdDateTime: LocalDateTime = LocalDateTime.now()

    // 엔티티가 수정될 때마다 자동으로 갱신되는 시간 (수정일시)
    @LastModifiedDate
    @Column(nullable = false, updatable = true) // null 허용 X, 업데이트 가능
    var updatedDateTime: LocalDateTime = LocalDateTime.now() //엔티티의 마지막 수정 일시를 기록하는 필드

}
