package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author andrii
 */
public class StreamAppTest {
    
    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }
    
//    @Test
//    public void testStreamOperations() {
//        System.out.println("streamOperations");
//        int expResult = 42;
//        int result = StreamApp.streamOperations(intStream);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testStreamToArray() {
//        System.out.println("streamToArray");
//        int[] expResult = {-1, 0, 1, 2, 3};
//        int[] result = StreamApp.streamToArray(intStream);
//        assertArrayEquals(expResult, result);
//    }
//
//    @Test
//    public void testStreamForEach() {
//        System.out.println("streamForEach");
//        String expResult = "-10123";
//        String result = StreamApp.streamForEach(intStream);
//        assertEquals(expResult, result);
//    }

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
        System.out.println(expAvg + " " + result);
    }


}
