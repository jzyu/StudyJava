package jzyu.com.github.collection.myversion;

import java.util.Iterator;

/**
 * Author: weplant
 * Date  : 2017/11/2.
 */
public class MyLinkedList<E> implements MyList<E> {

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private Node<E> head;
    private Node<E> tail;

    @Override
    public int size() {
        return size;
    }

    Node<E> getNode(int index) {
        Node<E> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    private void checkElementIndex(int index) {
        if (! (index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("index out range!");
        }
    }

    private void checkPositionIndex(int index) {
        if (! (index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException("index out range!");
        }
    }

    private void checkNotNull(Object o) {
        if (o == null) {
            throw new NullPointerException("can't be null!");
        }
    }

    private void linkLast(E element) {
        Node<E> t = tail;

        Node<E> newNode = new Node<>(element, tail, null);
        tail = newNode;

        if (t == null) {
            head = newNode;
        } else {
            t.next = newNode;
        }

        size++;
    }

    private void linkBefore(E element, Node<E> node) {
        Node<E> prev = node.prev;

        Node<E> newNode = new Node<>(element, prev, node.next);
        node.prev = newNode;

        if (prev == null) {
            head = newNode;
        } else {
            prev.next = newNode;
        }

        size++;
    }

    private E unlink(Node<E> node) {
        E element = node.element;
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
        }

        node.element = null;
        size--;

        return element;
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return getNode(index).element;
    }

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, getNode(index));
        }
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(getNode(index));
    }

    @Override
    public void removeAll() {
        Iterator<E> iter = iterator();
        while (iter.hasNext()) {
            iter.remove();
        }
    }

    @Override
    public int indexOf(Object o) {
        checkNotNull(o);

        int index = 0;
        for (Node<E> node = head; node != null; node = node.next) {
            if (o.equals(node.element)) {
                return index;
            }

            index++;
        }

        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E> {

        int cursor = 0;
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public E next() {
            int i = cursor;
            E next = get(cursor);

            lastRet = i;
            cursor = i + 1;

            return next;
        }

        @Override
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            MyLinkedList.this.remove(lastRet);

            if (cursor > lastRet)
                cursor--;
            lastRet = -1;
        }
    }
}
