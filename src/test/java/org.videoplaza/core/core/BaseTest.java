package org.videoplaza.core.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * Created by majid on 30/10/15.
 */
public class BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BookingsTest.class);

    @BeforeTest
    public final void beforeTests() {
        logger.info("============ Starting New Test  ============");
    }


    @AfterTest
    public final void afterTests() {
        logger.info("============ Test Finished  ============");
    }
}
