package lesson6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int countOfTree = 100000;
        int countOfBalancedTree = 0;

        for (int i = 0; i < countOfTree; i++) {
            MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
            int x = 0;
            while (map.height() < 5) {
                x = random.nextInt(201) - 100;
                map.put(x, x);
            }
            if(map.isBalanced()){
                countOfBalancedTree++;
            }
        }

        System.out.println("balCount " + countOfBalancedTree + " countTree " + countOfTree);
    }
}
