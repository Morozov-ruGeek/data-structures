package lesson4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> mll = new MyLinkedList<>();

        mll.insertFirst(5);
        mll.insertFirst(6);
        mll.insertFirst(2);
        mll.insertFirst(8);
        mll.insertLast(77);
        mll.insertLast(88);
        mll.insert(2, 55);
        System.out.println(mll);

        Iterator<Integer> iterator = mll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (Integer x : mll) {
            System.out.println(x);
        }
    }
}
