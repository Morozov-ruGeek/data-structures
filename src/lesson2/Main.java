package lesson2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        MySortedArrayList<Integer> msal = new MySortedArrayList<>();
        for (int i = 0; i < 10; i++) {
            msal.add(random.nextInt(10000));
        }
        long startTime = System.currentTimeMillis();
        msal.binaryFind(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");

    }
}
