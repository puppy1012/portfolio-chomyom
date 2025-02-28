package com.chomyom.portfolio.domain.repository

import com.chomyom.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>