package com.example.randomnumbermemorization2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;

public class ArrayFileTest {

    @Test
    public void randomNumberGeneratorUpperBoundTest() {
        int expectedLessThan = 9 ;
        int out = ArrayFile.randomNumberGenerator();
        assertTrue(out <= expectedLessThan);
    }

    @Test
    public void randomNumberGeneratorNegativeNumberTest() {
        int out = ArrayFile.randomNumberGenerator();
        assertTrue(out > 0);
    }

    @Test
    public void joinArray() {
        String expected = "1  3  5  7  ";
        ArrayList<Integer> numb = new ArrayList<>();
        numb.add(1);
        numb.add(3);
        numb.add(5);
        numb.add(7);
        String out = ArrayFile.joinArray(numb);
        assertEquals(expected, out);
    }

        @Test
        public void joinArray2Digit() {
        String expected = "36  27  45  52  ";
            ArrayList<Integer> numb = new ArrayList<>();
            numb.add(36);
            numb.add(27);
            numb.add(45);
            numb.add(52);
            String out = ArrayFile.joinArray(numb);
            assertEquals(expected, out);
        }

    @Test
    public void makeArray() {
        String expected = "" ;
        String out = ArrayFile.makeArray() + ArrayFile.makeArray() + ArrayFile.makeArray();
        System.out.println(out);
        assertEquals(9, out.length());

    }

}