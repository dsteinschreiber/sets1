package org.example;

public abstract class MyAbstractSet<T> {
    public abstract MyAbstractSet<T> add(T element);
    public abstract MyAbstractSet<T> remove(T element);
    public abstract boolean contains(T element);
    public abstract boolean isEmpty();
    public abstract int size();
    @Override
    public abstract boolean equals(Object that);
    @Override
    public abstract String toString();
    public abstract boolean isSubsetOf(MyAbstractSet<T> that);
}
