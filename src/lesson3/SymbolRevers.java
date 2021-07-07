package lesson3;

import java.util.EmptyStackException;

public class SymbolRevers {

    public void symbolRevers(String string){
        if(string == null) {
//            todo add method reCapacity
            throw new EmptyStackException();
        }
        char[] charArray = string.toCharArray();
        char[] reverseCharArray = new char[charArray.length];
        for (int i = charArray.length-1; i >= 0; i--) {
            reverseCharArray[i] = charArray[i];
            System.out.print(reverseCharArray[i]);
        }
    }

    public void stringReverse(String string){
        char[] charArray = string.toCharArray();
        MyStack stack = new MyStack<>(charArray.length);
        for(int i = charArray.length; i >= 0; i--){
            stack.push(charArray[i]);
            System.out.println(stack.pop());
        }
    }
}
