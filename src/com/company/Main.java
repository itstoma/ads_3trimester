package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        MyLinkedList<String> linkedList1 = new MyLinkedList<>();

        int n=5;
        for (int i=0; i<n; i++){
            linkedList.add(i);
        }
        System.out.println(linkedList.toString());
        linkedList.add(2,1);
        System.out.println(linkedList.toString());
    }
}
