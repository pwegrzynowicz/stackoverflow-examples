package com.yonlabs.java_boxcolors.inverse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class InverseBoxColorTest {

    @Autowired
    EntityManager entityManager;

    @Test
    public void testGetBox_ColorNotSaved() {
        // given: create a new box with one color
        int boxId = 1;
        int colorId = 1;
        JColor2 color = new JColor2(new JColorId2(colorId));
        JBox2 box = new JBox2(boxId, Arrays.asList(color));
        entityManager.persist(box);
        // forces flush to a database
        entityManager.flush();
        // detaches all managed entities to force find from a database
        entityManager.clear();

        // when: find a box
        JBox2 found = entityManager.find(JBox2.class, boxId);

        // then:
        assertThat(found != null);
        // even though we added Color via setColors in Box it was not saved in a database (size == 0)
        // because Box is not the owning side of the relationship
        assertThat(found.getColors().size() == 0);
    }

    @Test
    public void testGetBox_ColorSaved() {
        // we force different transactions

        // given: create a new box with one color
        int boxId = 1;
        int colorId = 1;
        JColor2 color = new JColor2(new JColorId2(colorId));
        JBox2 box = new JBox2(boxId, Arrays.asList(color));
        // Color is the owning side of a relationship between Box and Color
        // that's why we need to set the Box in the Color in order to save a relationship in a database
        color.setBox(box);
        entityManager.persist(box);
        // forces flush to a database
        entityManager.flush();
        // detaches all managed entities to force find from a database
        entityManager.clear();

        // when: find a box
        JBox2 found = entityManager.find(JBox2.class, boxId);

        // then:
        assertThat(found != null);
        // now the relationship is properly saved in a database
        // and we expect 1 color for this Box
        assertThat(found.getColors().size() == 1);
    }

}
