package com.company;

public interface MyList {
    int size();
    boolean contains(Object o);
    void add(T item);
    void add(T item, int index);
    boolean remove(T item);
    T remove(int index);
    void clear();

    void add(int index, T element);

    T get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    void sort();

    boolean isEmpty();
}
