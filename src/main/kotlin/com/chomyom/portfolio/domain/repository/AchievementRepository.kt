package com.chomyom.portfolio.domain.repository

import com.chomyom.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long> {
    //select* from achievement whre is_active =:isActive

    fun findAllByIsActive(isActive: Boolean): List<Achievement>
}