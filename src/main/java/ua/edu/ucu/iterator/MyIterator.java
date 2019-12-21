package ua.edu.ucu.iterator;

import java.util.Iterator;

public class MyIterator implements Iterator<Integer>{
    private int[] intArray;
    private int i = 0;

    public MyIterator(int... values) {
        intArray = values;
    }

    @Override
    public Integer next(){
        return intArray[i++];
    }

    @Override
    public boolean hasNext(){
        return i < intArray.length;
    }
}
