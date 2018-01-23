package com.mkmonkey.sell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Class Name: LoggerTest
 * @Description: TODO
 * @Company bgy:  MK monkey
 * @create: 2018-01-23 11:24
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {
        logger.debug("debug....");
        logger.error("error....");
        logger.info("info....");
    }
}
