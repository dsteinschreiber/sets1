package org.example;

public abstract class MyAbstractSet<T> implements MySet<T>{

    @Override
    public boolean equals(Object object){
        if (object == null){
            return false;
        }

        if (!(object instanceof  MyAbstractSet)){
            return false;
        }

        MyAbstractSet<T> that = (MyAbstractSet<T>) object;

        return that.isSubsetOf(this) && this.isSubsetOf(that);
    }

    @Override
    public abstract String toString();

}
