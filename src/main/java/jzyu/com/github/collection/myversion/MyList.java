package jzyu.com.github.collection.myversion;

import java.util.Iterator;

/**
 * Author: weplant
 * Date  : 2017/11/2.
 */
public interface MyList<E> {
    E get(int index);
    //void set(int index, E element);

    void add(int index, E element);
    void add(E element);
    E remove(int index);
    void removeAll();

    int size();
    int indexOf(Object o);
    boolean contains(Object o);

    Iterator<E> iterator();
}
