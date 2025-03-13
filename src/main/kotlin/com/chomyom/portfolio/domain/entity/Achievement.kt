package com.chomyom.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

// Achievement라는 엔티티(Entity) 클래스 선언, 데이터베이스 테이블과 매핑됨
@Entity
class Achievement(
    title: String,                      // 성취(achievement)의 제목
    description: String,                // 성취에 대한 상세 설명
    achievedDate: LocalDate?,           // 성취를 달성한 날짜 (null 가능)
    host: String,                       // 성취를 주관한 주최자 정보
    isActive: Boolean                   // 성취가 현재 활성 상태인지 여부 (true/false)
) : BaseEntity() {                      // BaseEntity 상속받아 공통 필드(createdDateTime, updatedDateTime) 사용 가능

    // 데이터베이스에서 자동 생성되는 고유 ID (기본 키)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")    // 데이터베이스 컬럼 이름 명시
    var id: Long? = null                // 최초 저장 시 ID는 없으므로 null 허용

    // 성취의 제목 (필수 입력)
    var title: String = title
    // 성취에 대한 설명 (필수 입력)
    var description: String = description
    // 성취를 달성한 날짜 (필수 아님, 달성일 모를 경우 null 가능)
    var achievedDate: LocalDate? = achievedDate
    // 성취를 주관한 주최자 정보 (필수 입력)
    var host: String = host
    // 성취의 활성 상태 (true: 활성화, false: 비활성화)
    var isACtive: Boolean = isActive
}
