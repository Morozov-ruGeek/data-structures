package lesson5;

public class Main {

    private static final Item[] items = {
            new Item(7, 9),
            new Item(3, 1),
            new Item(4, 6),
            new Item(9, 4)
    };
    final static int MAX_WEIGHT = 15;

    public static void main(String[] args) {
//      1. Написать программу по возведению числа в степень с помощью рекурсии.
        System.out.println(exponentiation(4, 3));


//      2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
        System.out.println(findBestRes(items.length - 1, MAX_WEIGHT));
    }

    private static int findBestRes(int numberOfItem, int maxWeight) {
        if (numberOfItem < 0) {
            return 0;
        }
        if (items[numberOfItem].getWeight() > maxWeight) {
            return findBestRes(numberOfItem - 1, maxWeight);
        } else {
            return Math.max(findBestRes(numberOfItem - 1, maxWeight), findBestRes(numberOfItem - 1, maxWeight - items[numberOfItem].getWeight()) + items[numberOfItem].getValue());
        }
    }


    private static int exponentiation(int number, int exponent) {
        if (exponent == 1) {
            return number;
        }
        return number * exponentiation(number, exponent - 1);
    }
}
