package ua.edu.ucu.iterator;

import ua.edu.ucu.function.IntToIntStreamFunction;
import ua.edu.ucu.stream.AsIntStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FlatMapIterator implements Iterator<Integer>{
    private Iterator<Integer> iter;
    private Iterator<Integer> newIter;
    private IntToIntStreamFunction func;

    public FlatMapIterator(Iterator<Integer> iter, IntToIntStreamFunction func) {
        this.iter = iter;
        this.func = func;
    }

    public Integer next() {
        return newIter.next();
    }

    @Override
    public boolean hasNext() {
        if (newIter != null && newIter.hasNext()) {
            return true;
        }
        if (iter.hasNext()) {
            newIter = ((AsIntStream) func.applyAsIntStream(iter.next())).intIterator();
            return true;
        }
        return false;
    }
}
