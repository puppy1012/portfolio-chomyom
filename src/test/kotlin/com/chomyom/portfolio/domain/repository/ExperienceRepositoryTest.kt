package com.chomyom.portfolio.domain.repository

import com.chomyom.portfolio.domain.entity.Experience
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest(
    @Autowired val experienceRepository:ExperienceRepository
) {
    val DATA_SIZE=10

    private fun createExperience(n:Int):Experience{

    }

}