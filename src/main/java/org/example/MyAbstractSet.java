package org.example;

public abstract class MyAbstractSet<T> {
    public abstract MyAbstractSet<T> add(T element);
    public abstract MyAbstractSet<T> remove(T element);
    public abstract boolean contains(T element);
}