package com.reachUp.AStar.dataStructure;

/**
 * This interface implementation, we are learned during
 * the course in the academy.
 * @param <E> generics type
 */
public interface MyList<E> extends Iterable<E> {

    /**
     * Method add element at the end
     * @param element generic type
     */
    public void add(E element);

    /**
     * Method add element at the given index
     * @param index
     * @param element generic type
     */
    public void add(int index, E element);

    /**
     * Method clear list
     */
    public void clear();

    /**
     * Method check if the given element exists
     * @param element generic type
     * @return true if the element exists
     */
    public boolean contains(E element);

    /**
     * Methods if element exists on the given index
     * @param index position in the list
     * @return element i = on the index
     */
    public E get(int index);

    /**
     * Method searching element by index
     * @param element generic type
     * @return index of first matching el in the list
     */
    public int IndexOf(E element);

    /**
     * Method check for empty list
     * @return true if is empty
     */
    public boolean isEmpty();

    /**
     * Method shows the last matching element
     * @param element generic type
     * @return index
     */
    public int lastIndexOf(E element);

    /**
     * Method shows matching element
     * @param element generic type
     * @return index
     */
    public int indexOf(E element);

    /**
     * Method remove first el, shift el to left
     * @param element generic type
     * @return true if the element has removed
     */
    public boolean remove(E element);

    /**
     * Method remove at the position, shift the el to left
     * @param index generic type
     * @return the removed element
     */
    public E remove (int index);

    /**
     * Method replace the el at the index with specified el
     * @param index
     * @param element generic type
     * @return the new set
     */
    public E set(int index, E element);

    /**
     * Method specified the size of list
     * @return length
     */
    public int size();
}
