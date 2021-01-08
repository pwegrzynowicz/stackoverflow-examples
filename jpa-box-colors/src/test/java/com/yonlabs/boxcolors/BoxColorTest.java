package com.yonlabs.boxcolors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
public class BoxColorTest {

    @Autowired
    PlatformTransactionManager transactionManager;

    TransactionTemplate transactionTemplate;

    @Autowired
    BoxRepository boxRepository;

    @PostConstruct
    private void init() {
        transactionTemplate = new TransactionTemplate(transactionManager);
    }


    @Test
    public void testGetBox() {
        transactionTemplate.execute(status -> {
            Color color = new Color();
            color.setColorId(new ColorId(1));

            Box box = new Box();
            box.setId(1);
            box.setColors(Arrays.asList(color));

            boxRepository.save(box);

            return box;
        });

        transactionTemplate.execute(status -> {
            Optional<Box> found = boxRepository.findById(1);

            Assert.isTrue(found.isPresent());
            Assert.isTrue(found.get().getColors().size() == 1);
            return found;
        });
    }

}
