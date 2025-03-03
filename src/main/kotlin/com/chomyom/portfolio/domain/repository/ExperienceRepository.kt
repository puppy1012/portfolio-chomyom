package com.chomyom.portfolio.domain.repository

import com.chomyom.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Experience>

//    override fun findById(id:Long):Optional<Project>
}