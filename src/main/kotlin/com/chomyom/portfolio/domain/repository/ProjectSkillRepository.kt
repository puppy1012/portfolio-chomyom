package com.chomyom.portfolio.domain.repository

import com.chomyom.portfolio.domain.entity.Project
import com.chomyom.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProjectSkillRepository : JpaRepository<ProjectSkill, Long> {
    //select *from project_skill where projectId and skill_id= :skillId
    fun findByProjectIdAndSkillId(projectId: Long, skillId: Long): Optional<Project>
}