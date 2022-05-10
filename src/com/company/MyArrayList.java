package com.company;

import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private T[] l;
    private int s;
    private Object[] elements;
    private int length;
    public MyArrayList(){
        this.l = (T[]) new Object[200];
    }
    public void add(T a) {
        if (this.s+1 < this.l.length){
            this.l[this.size()] = a;
        } else {
            this.resize();
            this.l[this.size()] = a;
        }
        this.s++;
    }

    @Override
    public void add(T item, int index) {
        add(index,item);
    }

    public void clear() {
        this.s=0;
    }
    @Override
    public boolean remove(T item) {
        return false;
    }
    @Override
    public void add(int index, T element) {
        if (index >= 0 || index < this.size()){
            if (this.size() + 1 > l.length)
                this.resize();
            for (int i = this.size(); i > index; i--)
                this.set(i, this.get(i-1));
            this.set(index, element);
            s++;
        } else
            throw new IndexOutOfBoundsException("size cann't less than index");
    }
    public T get(int i) {
        if (i >= 0 && i < this.size())
            return l[i];
        else
            throw new IndexOutOfBoundsException("Length shouldn't be less than index and index greater or equal to 0");
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }
    public T[] toArray() {
        return this.l;
    }
    private void resize()
    {
        T[] resA = (T[]) new Object[2*(this.l.length)];
        for (int i = 0; i < this.size(); i++)
            resA[i] = this.l[i];
        this.l = resA;
    }
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {
        Comparable<T> a,b;
        for (int i = 0; i < length; i++) {
            a= (Comparable<T>) l[i];
            for (int j = i+1; j <length ; j++) {
                b=(Comparable<T>) l[j];
                if(a.compareTo((T) b)>0){
                    T temp = l[i];
                    l[i]=l[j];
                    l[j]=temp;
                    a=b;
                }
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return length==0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void put(T key) {

    }

    public void set(int index, T element) {
        if (index >= 0 || index < this.size()){
            this.l[index] = element;
        } else
            throw new IndexOutOfBoundsException("index size incorrect");
    }
    public int size() {
        return this.s;
    }
    @Override
    public T remove(int index) {
        if (index >= 0 && index < this.size())
        {
            T temp = l[index];
            for (int i = index; i < this.size() - 1; i++)
                l[index] = l[index + 1];
            s--;
        }
        else
            throw new IndexOutOfBoundsException("index size incorrect");
        return null;
    }
    public static <T extends Comparable<T>> void sort(MyArrayList<T> l) {
        sor(l, null);
    }
    public static <T> void sort(MyArrayList<T> l, Comparator<T> comparator) {
        sor(l, comparator);
    }
    private static <T> void sor(MyArrayList<T> l, Comparator<T> comparator) {
        int N = l.length;
        Object elements[] = l.elements;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int compareR = 0;
                if (comparator == null) {
                    compareR = ((Comparable<T>)elements[j]).compareTo((T)elements[j+1]);
                } else {
                    compareR = comparator.compare((T)elements[j], (T)elements[j+1]);
                }
                if (compareR > 0) {
                    T temp = (T)elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                }
            }
        }
    }
    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < this.size(); i++)
            out += "["+get(i).toString()+"]";

        return out;
    }
}