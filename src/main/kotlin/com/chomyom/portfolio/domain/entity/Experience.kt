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
        if (endYear == null || endMonth == null) { //둘다 null일시
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
        this.title = title //"함수 호출 시 전달받은 새 title 값을 클래스 내부의 기존 멤버변수 title에 덮어씌운다."
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    /**
     * ExperienceDetail 객체 목록을 기존 목록에 추가하는 메서드
     * 멤버 변수(Member Variable): 클래스 내부에 선언한 변수. 클래스 전체에서 접근 가능.
     * 지역 변수(Local Variable): 특정 함수나 블록 내부에 선언된 변수로, 그 블록 안에서만 접근 가능.
     * 파라미터(매개변수): 함수를 호출할 때 외부에서 전달받는 값.
     *
     * 처음에 details라는 변수를 빈 리스트로 선언한 후,
     * 이후 addDetails()라는 함수가 호출될 때 파라미터로 들어오는 details 값을
     * 조건문으로 null 여부를 체크하고,
     * null이 아니면 클래스 내부의 멤버변수인 details 리스트에 추가하는 것이다.
     */
    fun addDetails(details: MutableList<ExperienceDetail>?) {
        if (details != null) {
            this.details.addAll(details)
        }
    }
}
