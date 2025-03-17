package com.chomyom.portfolio.domain.entity

import jakarta.persistence.*

/**
 * Experience 엔티티 클래스
 * - 사용자의 경험(경력, 프로젝트 등)을 나타내며, DB 테이블과 매핑됩니다.
 */
@Entity // JPA에서 테이블로 인식
class Experience(
    title: String,
    description: String,
    startYear: Int,
    startMonth: Int,
    endYear: Int?,    // 종료 연도 (null 가능: 진행 중인 경우)
    endMonth: Int?,   // 종료 월 (null 가능: 진행 중인 경우)
    isActive: Boolean // 현재 활동 여부
) : BaseEntity() {

    @Id // 기본 키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 전략
    @Column(name = "experience_id") // DB 컬럼명 지정
    var id: Long? = null // 경험 ID

    var title: String = title // 경험 제목
    var description: String = description // 경험 설명
    var startYear: Int? = startYear // 시작 연도
    var startMonth: Int? = startMonth // 시작 월
    var endYear: Int? = endYear // 종료 연도 (null 가능)
    var endMonth: Int? = endMonth // 종료 월 (null 가능)
    var isActive: Boolean = isActive // 활동 상태

    @OneToMany( //1:N(하나 대 다수) 관계를 나타내는 어노테이션
        targetEntity = ExperienceDetail::class,  // 1:N 관계의 대상 엔티티 (ExperienceDetail)
        fetch = FetchType.LAZY,                  // 지연 로딩 (실제 접근 시 로딩)
        cascade = [CascadeType.ALL]              // 부모 엔티티 저장·수정·삭제 시 자식에게 모두 자동 반영
    )

    @JoinColumn(name = "experience_id") // ExperienceDetail과의 외래키 연결
    var details: MutableList<ExperienceDetail> = mutableListOf() // 경험 상세 목록

    /**
     * 종료 연도와 월을 포맷팅하여 반환하는 메서드
     * - 종료 정보가 없으면 "Present" 반환
     */
    fun getEndYearMonth(): String {
        if (endYear == null || endMonth == null) {
            return "Present" // 진행 중인 경우 표시
        }
        return "${endYear}.${endMonth}" // "YYYY.MM" 형식 반환
    }

    /**
     * Experience 객체의 정보를 업데이트하는 메서드
     */
    fun update(
        title: String,
        description: String,
        startYear: Int,
        startMonth: Int,
        endYear: Int?,
        endMonth: Int?,
        isActive: Boolean
    ) {
        this.title = title
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    /**
     * ExperienceDetail 객체 목록을 기존 목록에 추가하는 메서드
     */
    fun addDetails(details: MutableList<ExperienceDetail>?) {
        if (details != null) {
            this.details.addAll(details)
        }
    }
}
