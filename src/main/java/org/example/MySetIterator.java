package org.example;

import java.util.Iterator;

public class MySetIterator<T> implements Iterator<T> {

    private final MyListSet<T> setInstance;

    private MyListElement<T> cursor;

    public MySetIterator(MyListSet<T> setInstance){
        this.setInstance = setInstance;
        cursor = setInstance.getBacking().head;
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public T next() {
        MyListElement<T> previousCursor = cursor;
        cursor = cursor.next;
        return previousCursor.value;
    }
}
