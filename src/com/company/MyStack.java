package com.company;

public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> list = new MyLinkedList<T>();

    public Object peek() {
        return list.get(getSize() - 1);
    }

    public void push(T o) {
        list.add(o);
    }

    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }
    public int getSize() {
        return list.size();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    @Override
    public String toString() {
        return "stack: " + list.toString();
    }
}
