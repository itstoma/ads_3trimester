package com.company;

public class MyArrayList <T> implements MyList<T> {
    private Object [] array;
    private int size =0;
    private int capacity =5;

    public MyArrayList(){ array= new Object[capacity];}
    public T get(int index) {return (T) array[index];}

    public void add(T newitem) {
        if (size == capacity){
            increaseBuffer();
        }
        array[size++] = newitem;
    }

    @Override
    public void add(T newitem, int index) {
        if (size == capacity){
            increaseBuffer();
        }
        for (int i=size;i>index-1;i++);{
            array[i]=array[i-1];
        }
        array[index-1]=newitem;
        size++;
    }
    public void
}
