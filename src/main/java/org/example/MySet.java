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
}
