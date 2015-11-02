package org.videoplaza.utils;

import java.util.Random;

/**
 * Created by majid on 01/11/15.
 * A random string generator mainly used to generate name of random customers
 */
public class RandomStringGenerator {
    private static final char[] symbols;

    // create a staic array of alphabets that can be used later to pick letters from randomly.
    static {
        StringBuilder tmp = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ++ch)
            tmp.append(ch);
        symbols = tmp.toString().toCharArray();
    }

    private final Random random = new Random();
    private final char[] buf;

    /**
     * Constructor that gets length of wanted random string and initializes a new String
     * @param length
     */
    public RandomStringGenerator(int length) {
        if (length < 1)
            throw new IllegalArgumentException("length < 1: " + length);
        buf = new char[length];
    }

    /**
     * Generates the next random string of the given length
     * @return
     */
    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }
}
