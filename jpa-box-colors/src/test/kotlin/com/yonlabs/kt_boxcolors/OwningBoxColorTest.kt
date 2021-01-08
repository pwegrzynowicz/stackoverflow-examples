package com.yonlabs.kt_boxcolors

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.persistence.EntityManager
import javax.transaction.Transactional

@SpringBootTest
@Transactional
open class OwningBoxColorTest @Autowired constructor(
        val entityManager: EntityManager
) {
    @Test
    fun testGetBox_ColorSaved() {
        // given: create a new box with one color
        val boxId = 1
        val colorId = 1
        val color = Color1(ColorId1(colorId))
        val box = Box1(boxId, mutableListOf(color))

        entityManager.persist(box)
        // forces flush to a database
        entityManager.flush()
        // detaches all managed entities to force find from a database
        entityManager.clear()

        // when: find a box
        val found = entityManager.find(Box1::class.java, boxId)

        // then:
        assert(found != null)
        assert(found?.colors?.size == 1)
    }

}