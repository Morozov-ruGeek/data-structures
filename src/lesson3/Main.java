package lesson3;

public class Main {
    public static void main(String[] args) {

        String str = "magma tree";
        System.out.println(str);
        SymbolRevers symbolRevers = new SymbolRevers();
        symbolRevers.symbolRevers(str);
        symbolRevers.stringReverse(str);
    }
}
