package org.example;

public class MySet<T> extends MyAbstractSet<T> {

    private MyList<T> backing = new MyList<>();

    public static <T> MySet<T> of(T... elements){
        MySet<T> result = new MySet<>();

        for (T element: elements) {
            result.add(element);
        }

        return result;
    }

    @Override
    public MyAbstractSet<T> add(T element) {
        this.backing.append(element);
        return this;
    }

    @Override
    public MyAbstractSet<T> remove(T element) {
        return null;
    }

    @Override
    public boolean contains(T element) {
        return this.backing.contains(element);
    }
}
