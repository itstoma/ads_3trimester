package com.company;

import java.util.Iterator;
public class BST<K extends Comparable<K>,V> implements Iterable<K> {
    private class Node {
        K key;
        V value;
        Node left, right;
        int length = 1;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    public void put(K key, V value) {
        Node newNode = new Node(key, value);
        root = put(root, newNode);
    }
    private Node put(Node current, Node node) {
        if (current == null) {
            return node;
        }
        int cmp = node.key.compareTo(current.key);
        if (cmp > 0) {
            current.right = put(current.right, node);
        } else if (cmp < 0) {
            current.left = put(current.left, node);
        } else {
            current.value = node.value;
        }
        current.length = size(current.left) + size(current.right) + 1;
        return current;
    }
    public V get(K key){
        return get(root, key);
    }
    private V get(Node current, K key)  {
        int cmp = key.compareTo(current.key);
        if (current==null || current.key==key)
            return null;
        if (cmp > 0)
            return get(root.left, key);
        return get(root.right, key);
    }
    public void delete(K node) {
        root = delete(root, node);
    }
    private Node delete(Node current, K key) {
        if (current == null) {
            return null;
        }
        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            current.left = delete(current.left, key);
        } else if (cmp > 0) {
            current.right = delete(current.right, key);
        } else {
            if (current.left == null)
                return current.right;
            else if (current.right == null)
                return current.left;
            current.key = minNode(root.right);
            current.right = delete(current.right, current.key);
        }
        current.length = size(current.left) + size(current.right) - 1;
        return current;
    }

    public int size(Node node) {
        return node == null ? 0 : node.length;
    }

    public int size() {
        return size(root);
    }

    private K minNode(Node current) {
        K minimum = current.key;
        while (current.left != null) {
            current = current.left;
            minimum = (current.left).key;
        }
        return minimum;
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTIterator(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    private class BSTIterator implements Iterator<K> {
        MyList<K> arr = new MyArrayList<>();
        Iterator<K> iterator;

        public BSTIterator(Node root) {
            traverse(root);
            iterator = arr.iterator();
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public K next() {
            return iterator.next();
        }

        private void traverse(Node current) {
            if (current == null) return;
            if (current.left != null) traverse(current.left);
            arr.put(current.key);
            if (current.right != null) traverse(current.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value + " ");
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}