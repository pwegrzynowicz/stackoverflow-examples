package com.yonlabs.java_boxcolors.owning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class OwningBoxColorTest {

    @Autowired
    EntityManager entityManager;

    @Test
    public void testGetBox_ColorSaved() {
        // given: create a new box with one color
        int boxId = 1;
        int colorId = 1;
        JColor1 color = new JColor1(new JColorId1(colorId));
        JBox1 box = new JBox1(boxId, Arrays.asList(color));
        entityManager.persist(box);
        // forces flush to a database
        entityManager.flush();
        // detaches all managed entities to force find from a database
        entityManager.clear();

        // when: find a box
        JBox1 found = entityManager.find(JBox1.class, boxId);

        // then:
        assertThat(found).isNotNull();
        assertThat(found.getColors().size()).isEqualTo(1);
    }

}
