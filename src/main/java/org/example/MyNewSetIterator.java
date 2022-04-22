package org.example;

import java.util.Iterator;

public class MyNewSetIterator<T> implements Iterator<T> {

    private Iterator<T> backingIterator;

    public MyNewSetIterator(Iterator<T> backingIterator){
        this.backingIterator = backingIterator;
    }

    @Override
    public boolean hasNext() {
        return backingIterator.hasNext();
    }

    @Override
    public T next() {
        return backingIterator.next();
    }
}

// IntelliJ can create delegate methods for you
