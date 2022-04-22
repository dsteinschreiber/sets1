package org.example;

import java.lang.management.MemoryType;
import java.util.Iterator;

public class MySet<T> extends MyAbstractSet<T> implements Iterable<T> {

    private MyList<T> backing = new MyList<>();


    // Example of package private
    MyList<T> getBacking() {
        return backing;
    }

    public static <T> MySet<T> of(T... elements) {
        MySet<T> result = new MySet<>();

        for (T element : elements) {
            result.add(element);
        }

        return result;
    }

    @Override
    public MyAbstractSet<T> add(T element) {
        if (!this.contains(element)) {
//            this.backing.append(element);
            this.backing.push(element);
            // same result, much quicker (O(1) instead of O(n))
        }
        return this;
    }

    @Override
    public MyAbstractSet<T> remove(T element) {
//        MyListElement<T> cursor = this.backing.head;
//        MyList<T> result = new MyList<>();
//
//        while (cursor != null){
//            if (cursor.value != element){
//                result.append(cursor.value);
//            }
//            cursor = cursor.next;
//        }
//        this.backing = result;

        this.backing = this.backing.filter(value -> value != element);

        return this;
    }

    @Override
    public boolean contains(T element) {
        return this.backing.contains(element);
    }

    @Override
    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    @Override
    public int size() {
        return this.backing.size();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null){
            return false;
        }

        if (!(object instanceof  MySet)){
            return false;
        }

        MySet<T> that = (MySet<T>) object;

        return that.isSubsetOf(this) && this.isSubsetOf(that);

    }

    @Override
    public String toString() {
        return this.backing.toString();
    }

    @Override
    public boolean isSubsetOf(MyAbstractSet<T> that) {
        for (T value: this.backing) {
            if (!(that.contains(value))){
                return false;
            }
        }
        return true;




//        MyListElement<T> cursor = this.backing.head;
//
//        while (cursor != null){
//            if (!(that.contains(cursor.value))){
//                return false;
//            }
//            cursor = cursor.next;
//        }
//
//        return true;
    }


//    @Override
//    public Iterator<T> iterator() {
//        return new MySetIterator<T>(this);
//    }

    @Override
    public Iterator<T> iterator() {
        return new MyNewSetIterator<T>(this.backing.iterator());
    }
}
