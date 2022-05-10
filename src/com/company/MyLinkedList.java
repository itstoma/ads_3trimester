package com.company;

import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<Object> {
    public MyLinkedList() {}
    class Node1<Object>{
        Object data;
        public int d;
        public T cargo;
        Node1<Object> next, prev;
        Node1(Object data) {

            this.data = data;}

        public void next(Node1 node) {
            next = node;
        }
        public Node1 (int d){
            next = null;
            this.d = d;
        }
        public int data() {
            return  d;
        }

        public Node1 gnext() {
            return next;
        }
    }
    private int length = 0;
    private Node1<Object> start, end;
    @Override
    public int indexOf(Object target) {
        Node1 node = start;
        for (int i=0; i<length; i++) {
            if (equals(target, node.cargo)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    private boolean equals(Object target, Comparable cargo) {
        return true;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node1<Object> node = start;
        int a=0;
        while (node!=null){if(node.data.equals(o)) a=-1;
            a++;node=node.next;}return -1;}
    @Override
    public void sort() {
        Node1<Object> nodei=start,nodej;
        Comparable<T> a,b;
        while (nodei!=null){
            nodej=nodei.next;
            a=(Comparable<T>) nodei.data;
            while (nodej!=null){
                b=(Comparable<T>) nodej.data;
                if(a.compareTo((T)b)>0) {
                    Object temp = nodei.data;
                    nodei.data = nodej.data;
                    nodej.data = temp;
                    a = (Comparable<T>) nodei.data;
                }
                nodej=nodej.next;
            }
            nodei=nodei.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<Object> iterator() {
        return null;
    }

    @Override
    public void put(Object key) {

    }

    public void add(Object item) {
        Node1<Object> newNode = new Node1<>(item);
        if (start == null) {
            start = end = newNode;
        } else {newNode.prev = end;
            end.next = newNode;
            end = newNode;}
        length++;

    }
    public Object get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("Index is greater than or equal to 0");
        Node1<Object> temp = start;
        while (index != 0) {
            temp = temp.next;
            index--;
        }
        return temp.data;
    }
    public int size() {
        return length;
    }
    @Override
    public boolean contains(Object o) {
        Node1 cur = start;
        while(cur!=null){
            if(cur.data == o){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    @Override
    public Object remove(int index) {
        if(index<0 || index>length){
            throw new IndexOutOfBoundsException("Length shouldn't be less than index and index greater or equal to 0");
        }
        int i=0;
        Node1<Object> node=start,prev,next;
        Object x=node.data;
        if (index==0){
            start=start.next;
            length--;
            return x;
        }
        while (node!=null){
            if(i==index){
                prev=node.prev;
                next=node.next;
                prev.next=next;
                length--;
                return node.data;
            }
            node=node.next;i++;
        }
        return null;
    }

    @Override
    public void add(Object item, int index) {
        if(index==length){
            add(item);
            return;
        }
        if(index>length) throw new ArithmeticException("index cann't be more than length");
        if(index<0) throw new ArithmeticException("index greater than -1");
        int i=0;
        Node1<Object> node=start,x = new Node1<>(item),prev;
        while (node!=null){
            if(i==index){
                prev=node.prev;
                x.prev=prev;
                if(prev!=null) prev.next=x;
                node.prev=x;
                x.next=node;
                length++;
                if(i==0) start=x;
                return;
            }
            node=node.next;i++;
        }
    }
    @Override
    public boolean remove(Object item) {
        Node1<Object> node=start,prev,next;
        while(node!=null){
            if(node.data.equals(item)){
                prev=node.prev;
                next=node.next;
                prev.next=next;
                next.prev=prev;
                length--;
                return true;
            }
            node=node.next;
        }
        return false;
    }
    @Override
    public void clear() {
        Node1 cur = this.start;
        while(cur!=null){
            Node1 curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        this.start = null;
        this.end = null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < this.size(); i++)
            out += "["+get(i).toString()+"]";
        return out;
    }
}