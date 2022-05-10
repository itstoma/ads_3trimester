package com.company;

public class MyQueue<T extends Comparable<T>> extends MyLinkedList {
    MyLinkedList list = new MyLinkedList();
    private int size = 0;
    private Node1 fr, rear;
    private int newItem;
    public MyQueue() {fr = rear = null;}
    public int size() {
        return list.size();
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public T peek(){
        if (list.size() == 0)
            return null;
        return (T) list.get(list.size()-1);
    }
    public T poll() throws Exception {
        if (list.size() == 0)
            throw new Exception("Queue is incorrect");
        return (T) list.remove(0);
    }
    public void enqueue(int data) {
        Node1 node = new Node1(data);
        if (isEmpty())
            fr = node;
        else
            rear.next(node);
        rear = node;
        size++;
    }
    public int dequeue() throws Exception {
        if (isEmpty())
            poll();
        int result = fr.data();
        fr = fr.gnext();
        size--;
        if (isEmpty())
            rear = null;
        return result;
    }

    public int big() throws Exception {
        if (isEmpty())
            throw new Exception("No insert");
        return fr.data();
    }

    public String toString() {
        String result = "";
        Node1 current = fr;
        while (current != null) {
            result = result + current + "\n";
            current = current.gnext();
        }
        return result;
    }
}