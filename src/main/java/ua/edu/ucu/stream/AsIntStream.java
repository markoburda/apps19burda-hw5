package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.iterator.MyIterator;
import java.util.Iterator;

public class AsIntStream implements IntStream {
    private Iterator<Integer> iter;

    private AsIntStream(Iterator<Integer> iter) {
        this.iter = iter;
    }

    public static IntStream of(int... values) {
        return new AsIntStream(new MyIterator(values));
    }

    private Iterable<Integer> intIterable(){
        return () -> iter;
    }

    @Override
    public Double average() {
        isEmpty();
        double sum = 0.0;
        int size = 0;
        for (int i : intIterable()){
            sum += i;
            size++;
        }
        return sum/size;
    }

    @Override
    public Integer max() {
        isEmpty();
        int intMin = Integer.MIN_VALUE;
        for(int i : intIterable()){
            if(i > intMin)
               intMin = i;
        }
        return intMin;
    }

    @Override
    public Integer min() {
        isEmpty();
        int intMin = Integer.MAX_VALUE;
        for( int i : intIterable() ){
            if(i < intMin)
                intMin = i;
        }
        return intMin;
    }

    @Override
    public long count() {
        long count = 0;
        for(int i : intIterable()){
            count++;
        }
        return count;
    }

    private void isEmpty(){
        if(!iter.hasNext()){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Integer sum() {
        isEmpty();
        int sum = 0;
        for (int i : intIterable()){
            sum += i;
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void forEach(IntConsumer action) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
