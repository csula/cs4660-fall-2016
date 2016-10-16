package csula.cs4660.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test StringUtils class
 */
public class StringUtilsTest {
    @Test
    public void reverse() throws Exception {
        assertEquals(
            "dlrow olleH",
            StringUtils.reverse("Hello world")
        );
    }
}