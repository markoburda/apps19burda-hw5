package ua.edu.ucu.iterator;

import ua.edu.ucu.function.IntPredicate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilterIterator implements Iterator<Integer>{
    private Iterator<Integer> iter;
    private IntPredicate predicate;
    private Integer next;

    public FilterIterator(Iterator<Integer> iter, IntPredicate predicate) {
        this.iter = iter;
        this.predicate = predicate;
        this.next = null;
    }

    @Override
    public Integer next() {
        if (!iter.hasNext()){
            throw new NoSuchElementException();
        }
        Integer temp = next;
        next = null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        if(next != null){
            return true;
            }
        else{
            Integer temp;
            while(iter.hasNext()) {
                temp = iter.next();
                if (predicate.test(temp)) {
                    next = temp;
                    return true;
                }
            }
            next = null;
            return false;
        }
    }
}
