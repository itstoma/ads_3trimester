package com.company;

import java.util.NoSuchElementException;
public class MyHeap <T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChildInd(int index) {
        return 2 * index + 1;
    }

    private int rightChildInd(int index) {
        return 2 * index + 2;
    }

    private void traverseUp() {
        int k = heap.size() - 1;
        while (k > 0) {
            int p = parent(k);
            T to = heap.get(k);
            T parent = heap.get(p);
            if (to.compareTo(parent) > 0) {
                swap(k, p);
                k = p;
            } else {
                break;
            }
        }
    }

    private void heapify() {
        int k = 0;
        int left = leftChildInd(k);
        int right = rightChildInd(k);
        while (left < heap.size()) {
            int largest = left;
            if (right < heap.size() && heap.get(right).compareTo(heap.get(left)) > 0) {
                T temp = heap.get(k);
                swap(k,largest);
                k = largest;
                left = leftChildInd(k);
            }
            break;
        }
    }

    public void adding(T to) {
        heap.add(to);
        traverseUp();
    }

    public T delete() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("No heap");
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }
        T hold = getMin();
        heap.set(0, heap.remove(heap.size() - 1));
        heapify();
        return hold;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void swap(int x, int y) {
        Integer temp = (Integer) heap.get(x);
        heap.set(x, heap.get(y));
        heap.set(y, (T) temp);
    }

    public T getMin() {
        return heap.get(0);
    }

    public T getMax() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty.");
        return heap.get(0);
    }

    public String toString() {
        return "heap:" + heap.toString();
    }
}
