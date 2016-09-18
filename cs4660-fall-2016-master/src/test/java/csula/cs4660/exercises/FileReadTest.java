package csula.cs4660.exercises;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * A simple text for your exercise
 */
public class FileReadTest {
    private FileRead fileRead;
    @Before
    public void setUp() throws Exception {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("array.txt").getFile());
        fileRead = new FileRead(file);
    }

    @Test
    public void mean() throws Exception {
        assertEquals(fileRead.mean(0), ((1 + 5 + 4 + 2 + 3 + 5 + 6 + 7)/8));
    }

    @Test
    public void max() throws Exception {
        assertEquals(fileRead.max(3), 9);
    }

    @Test
    public void min() throws Exception {
        assertEquals(fileRead.min(4), -5);
    }

    @Test
    public void sum() throws Exception {
        assertEquals(fileRead.sum(1), (5 + 4 + 3 + 2 + 6 + 7 + 8 + 1));
    }
}