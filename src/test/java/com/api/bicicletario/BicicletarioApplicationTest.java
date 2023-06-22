package com.api.bicicletario;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BicicletarioApplication.class)
class BicicletarioApplicationTest {

    @Test
    void contextLoads() {
    }

    @Test
    void mainTest() {
        BicicletarioApplication.main(new String[]{});
    }
}
