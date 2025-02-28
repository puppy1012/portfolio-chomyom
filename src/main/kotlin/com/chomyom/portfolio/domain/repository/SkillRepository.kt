package com.chomyom.portfolio.domain.repository

import com.chomyom.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>