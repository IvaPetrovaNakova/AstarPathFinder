package com.reachUp.AStar.dataStructure;

public interface MyList<E> extends Iterable<E> {

    public void add(E element); //add at the end

    public void add(int index, E element); //add at the index

    public void clear(); //clear list

    public boolean contains(E element); //return true if the element exists

    public E get(int index); //return element i=on the index if he exists

    public int IndexOf(E element); //return index of first matching el in the list

    public boolean isEmpty(); //

    public int lastIndexOf(E element);//last matching element, return index

    public int indexOf(E element); //match element and return

    public boolean remove(E element); //remove first element, shift element to left, return true if the element is remove

    public E remove (int index); //remove at the position, shift the el to left, return the removed element

    public E set(int index, E element); //replace the element at the index with speciefed el and return the new set

    public int size(); //return length

}
