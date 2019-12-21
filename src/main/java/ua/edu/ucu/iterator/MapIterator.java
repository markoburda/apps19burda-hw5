package ua.edu.ucu.iterator;

import ua.edu.ucu.function.IntUnaryOperator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MapIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private IntUnaryOperator mapper;

    public MapIterator(Iterator<Integer> iter, IntUnaryOperator mapper) {
        this.iter = iter;
        this.mapper = mapper;
    }

    @Override
    public Integer next() {
        if (!iter.hasNext()){
            throw new NoSuchElementException();
        }
        return mapper.apply(iter.next());
    }

    public boolean hasNext() {
        return iter.hasNext();
    }
}