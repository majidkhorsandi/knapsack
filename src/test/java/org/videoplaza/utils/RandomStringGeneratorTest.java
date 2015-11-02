package org.videoplaza.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by majid on 02/11/15.
 */
public class RandomStringGeneratorTest {

    private static final int SIZE_OF_RANDOM_STRING = 5;

    private RandomStringGenerator tooShortRandomStringGenerator;
    private RandomStringGenerator randomStringGenerator;

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testRandomString() {
        tooShortRandomStringGenerator = new RandomStringGenerator(0);
    }

    @Test
    public final void testNextString() {
        randomStringGenerator = new RandomStringGenerator(SIZE_OF_RANDOM_STRING);
        String testString = randomStringGenerator.nextString();
        Assert.assertEquals(testString.length(), SIZE_OF_RANDOM_STRING);
    }


}
