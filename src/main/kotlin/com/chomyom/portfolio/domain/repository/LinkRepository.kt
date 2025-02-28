package com.chomyom.portfolio.domain.repository

import com.chomyom.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long>