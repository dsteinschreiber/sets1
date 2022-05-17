package org.example;

public interface MySet<T> {
    MySet<T> add(T element);
    MySet<T> remove(T element);
    boolean contains(T element);
    boolean isEmpty();
    int size();
    boolean isSubsetOf(MySet<T> that);
}
