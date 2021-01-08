package com.yonlabs.kt_boxcolors

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.persistence.EntityManager
import javax.transaction.Transactional


@SpringBootTest
@Transactional
open class InverseBoxColorTest @Autowired constructor(
        val entityManager: EntityManager
) {
    @Test
    fun testGetBox_ColorNotSaved() {
        // given: create a new box with one color
        val boxId = 1
        val colorId = 1
        val color = Color2(ColorId2(colorId))
        val box = Box2(boxId, mutableListOf(color))
        box.id = boxId
        entityManager.persist(box)
        // forces flush to a database
        entityManager.flush()
        // detaches all managed entities to force find from a database
        entityManager.clear()

        // when: find a box
        val found = entityManager.find(Box2::class.java, boxId)

        // then:
        assert(found != null)
        assert(found?.colors?.size == 0)
    }

    @Test
    fun testGetBox_ColorSaved() {
        // given: create a new box with one color
        val boxId = 2
        val colorId = 2
        val color = Color2(ColorId2(colorId))
        val box = Box2(boxId, mutableListOf(color))
        // Color is the owning side of a relationship between Box and Color
        // that's why we need to set the Box in the Color in order to save a relationship in a database
        color.box = box
        entityManager.persist(box)
        // forces flush to a database
        entityManager.flush()
        // detaches all managed entities to force find from a database
        entityManager.clear()

        // when: find a box
        val found = entityManager.find(Box2::class.java, boxId)

        // then:
        assert(found != null)
        assert(found?.colors?.size == 1)
    }

}