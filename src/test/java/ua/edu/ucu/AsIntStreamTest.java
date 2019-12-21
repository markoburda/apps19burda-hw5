package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class AsIntStreamTest {

    private IntStream intStream;
    private IntStream emptyStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        int[] emptyArr = {};
        intStream = AsIntStream.of(intArr);
        emptyStream = AsIntStream.of(emptyArr);
    }

    @Test
    public void testCount(){
        System.out.println("count");
        long expCnt = 5;
        long result = intStream.count();
        assertEquals(expCnt, result);
    }

    @Test
    public void testMin(){
        System.out.println("min");
        int expMin = -1;
        int result = intStream.min();
        assertEquals(expMin, result);
    }

    @Test
    public void testMax(){
        System.out.println("max");
        int expMax = 3;
        int result = intStream.max();
        assertEquals(expMax, result);
    }

    @Test
    public void testSum(){
        System.out.println("sum");
        int expSum = 5;
        int result = intStream.sum();
        assertEquals(expSum, result);
    }

    @Test
    public void testAverage(){
        System.out.println("average");
        double expAvg = 1;
        double result = intStream.average();
        assertEquals(expAvg, result, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyAverage(){
        System.out.println("empty average");
        emptyStream.average();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMax(){
        System.out.println("empty max");
        emptyStream.max();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMin(){
        System.out.println("empty min");
        emptyStream.min();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptySum(){
        System.out.println("empty sum");
        emptyStream.sum();
    }

}
