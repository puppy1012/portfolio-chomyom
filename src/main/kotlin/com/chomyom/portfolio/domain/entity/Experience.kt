package com.chomyom.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Experience(
    title: String, description: String, startYear: Int, startMonth: Int, endYear: Int?,
    endMonth: Int?, isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    var id: Long? = null // 경험 ID

    var title: String = title // 경험 제목
    var description: String = description // 경험 설명
    var startYear: Int? = startYear // 시작 연도
    var startMonth: Int? = startMonth // 시작 월
    var endYear: Int? = endYear // 종료 연도
    var endMonth: Int? = endMonth // 종료 월
    var isActive: Boolean = isActive // 현재 활동 중 여부

    @OneToMany(targetEntity = ExperienceDetail::class, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "experience_id")
    var details: MutableList<ExperienceDetail> = mutableListOf() // 경험 상세 목록

    fun getEndYearMonth(): String {
        // 종료 연도와 월이 없으면 "Present" 반환
        if (endYear == null || endMonth == null) {
            return "Present"
        }
        return "${endYear}.${endMonth}" // "YYYY.MM" 형식으로 반환
    }

    fun update(title: String, description: String, startYear: Int, startMonth: Int, endYear: Int?, endMonth: Int?, isActive: Boolean) {
        // 경험 정보 업데이트
        this.title = title
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(details: MutableList<ExperienceDetail>?) {
        // 경험 상세 추가
        if (details != null) {
            this.details.addAll(details)
        }
    }
}
