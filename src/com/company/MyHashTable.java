package com.company;

public class MyHashTable<K extends Comparable<K>, V> {
    private static class MyNode<K, V> {
        K key;
        V value;
        int hashCode;
        MyNode<K, V> next;

        MyNode(K key, V value ) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" +key + " "+ value+ "}";
        }
    }
    private MyArrayList<MyNode<K, V>> bucketArray;
    private float loadFactor = 0.75F;
    private int capacity = 7;
    private int length = 0;
    private MyNode<K, V>[] buckets;
    public MyHashTable() {buckets = new MyNode[capacity];
        bucketArray = new MyArrayList<MyNode<K,V>>();}
    public MyHashTable(int initialCapacity) {
        this.capacity = (int) (initialCapacity * loadFactor);
        buckets = new MyNode[capacity];}
    public void put(K key, V value) {
        int index = hash(key.hashCode());
        MyNode<K,V> newNode= new MyNode<K, V>(key,value);
        if (buckets[index]!=null){
            newNode.next=buckets[index];}
        else{
            buckets[index]=newNode;}length++;}
    private int hash(int hashcode) {
        return (hashcode & 0x7FFFFFFF) % capacity;
    }
    public void print() {
        int i;
        for (i = 0; i < capacity; i++)
            System.out.print("My buckets" + i + "have");
        for (MyNode<K, V> it = buckets[i]; it != null; it = it.next) {
            System.out.print(it.key + "-> ");
        }
        System.out.println();
    }

    public K getKey(V value){
        for (int i = 0; i < capacity; i++) {
            MyNode<K, V> buck = bucketArray.get(i);
            while (buck != null) {
                if ((buck.value).equals(value)) {
                    return buck.key;
                }
                buck = buck.next;
            }
        }
        return null;
    }
    public boolean contains(K key){
        if (bucketArray == null){
            return false;
        }
        else{
            for (int i = 0; i < length; i++){
                MyNode<K,V> point = bucketArray.get(i);
                if (point.key.equals(key)){
                    return true;
                }
            }
        }
        return false;
    }
    public V remove(K key)
    {int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        MyNode<K, V> head = bucketArray.get(bucketIndex);
        MyNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key) && hashCode == head.hashCode)
                break;
            prev = head;
            head = head.next;
        }
        if (head == null)
            return null;
        length--;
        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);
        return head.value;
    }
    private int getBucketIndex(K key)
    {
        int index = hash(key.hashCode());
        index = index < 0 ? index * -1 : index;
        return index;
    }

    private int hashCode(K key) {
        return hash(key.hashCode());
    }

    public V get(K key)
    {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        MyNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.hashCode == hashCode)
                if(head.key.equals(key))
                    return head.value;
            head = head.next;
        }
        return null;
    }
}