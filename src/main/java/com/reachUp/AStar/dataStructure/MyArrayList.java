package com.reachUp.AStar.dataStructure;

public class MyArrayList <E> extends MyAbstractList<E> {

    public static final int INITIAL_CAPACITY = 16;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];

    //default list
    public MyArrayList() {

    }

    public MyArrayList(E[] objects) {
       super(objects);
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[]) new Object[size * 2 + 1];
            System.arraycopy(
                    data,
                    0,
                    newData,
                    0,
                    size
            );
            data = newData;
        }
    }

    @Override
    public void add(int index, E element) { //move to the right
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    @Override
    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public int IndexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        for (int i = size - 1; i >= 0; i--) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E element = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
            data[size - 1] = null;
        }
        size--;
        return element;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E old = data[index];
        data[index] = element;
        return old;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(size * 5).append("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        return result.append("]").toString();
    }

    public void trimSize() {
        if (size != data.length) {
            E[] newData = (E[])(new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        } // if size == capacity no need to trim
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Class iterator
     */
    private class ArrayListIterator implements java.util.Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return (current < size);
        }

        @Override
        public E next() {
            return data[current];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }
    }
}
