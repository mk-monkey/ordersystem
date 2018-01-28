package com.mkmonkey.sell;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class LoggerTest {
    @Test
    public void test1() {
        log.info("info...");
        log.debug("debug....");
        log.error("error");
        log.warn("warn");
    }
}
