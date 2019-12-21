package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.iterator.FilterIterator;
import ua.edu.ucu.iterator.FlatMapIterator;
import ua.edu.ucu.iterator.MapIterator;
import ua.edu.ucu.iterator.StreamIterator;
import java.util.Iterator;

public class AsIntStream implements IntStream {
    private Iterator<Integer> iter;

    private AsIntStream(Iterator<Integer> iter) {
        this.iter = iter;
    }

    public static IntStream of(int... values) {
        return new AsIntStream(new StreamIterator(values));
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
        return new AsIntStream(new FilterIterator(iter, predicate));
    }

    @Override
    public void forEach(IntConsumer action) {
        for (int i : intIterable()) {
            action.accept(i);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        return new AsIntStream(new MapIterator(iter, mapper));
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
//        return new AsIntStream(new FlatMapIterator(iter, func));
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
