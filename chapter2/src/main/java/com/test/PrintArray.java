package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class PrintArray {

    private double expected;
    private double valOne;
    private double valTwo;

    @Parameters
    public static Collection<Integer[]> getParams() {
        return Arrays.asList(new Integer[][]{
                {2, 1, 1},
                {3, 2, 1},
                {4, 3, 1},
        });
    }

    public PrintArray(double expected, double valOne, double valTwo) {
        this.expected = expected;
        this.valOne = valOne;
        this.valTwo = valTwo;
    }

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(expected, valOne, valTwo);

    }
}
