package com.chomyom.portfolio.domain.repository

import com.chomyom.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long> {
    //select* from introduction whre is_active =:isActive

    fun findAllByIsActive(isActive: Boolean): List<Introduction>
}