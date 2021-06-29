package lesson2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        MyArrayList<Integer> mal = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            mal.add(random.nextInt(20));
        }

        System.out.println(mal);

        mal.bubbleSort();

        System.out.println(mal);

    }
}
