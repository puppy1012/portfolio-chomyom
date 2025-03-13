package com.chomyom.portfolio.domain.entity

import com.chomyom.portfolio.domain.constant.SkillType
import jakarta.persistence.*

@Entity // 이 클래스가 JPA 엔티티임을 명시, DB 테이블과 매핑됨
class Skill(
    name: String,       // 외부에서 입력받는 스킬 이름
    type: String,       // 외부에서 입력받는 스킬 유형 (문자열 형태, 후에 Enum으로 변환)
    isActive: Boolean   // 외부에서 입력받는 스킬 활성 상태
) : BaseEntity() {      // BaseEntity 상속, 공통 필드(createdDateTime, updatedDateTime) 포함

    @Id // 이 필드를 엔티티의 기본 키(primary key)로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB의 auto-increment 기능으로 기본 키 값 자동 생성
    @Column(name = "skill_id") // DB에서 해당 필드를 'skill_id' 컬럼명으로 매핑
    var id: Long? = null // 기본 키 필드, 초기에는 null

    var name: String = name // 생성자에서 받은 name 값을 필드에 할당

    @Column(name = "skill_type") // DB에서 해당 필드를 'skill_type' 컬럼명으로 매핑
    @Enumerated(value = EnumType.STRING) // Enum 타입 값을 문자열로 저장하도록 지정
    var type: SkillType = SkillType.valueOf(type) // 생성자에서 받은 문자열을 SkillType enum으로 변환하여 할당

    var isActive: Boolean = isActive // 생성자에서 받은 isActive 값을 필드에 할당
}
