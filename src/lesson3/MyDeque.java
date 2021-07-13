package lesson3;

public class MyDeque<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyDeque(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyDeque(){
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    private int nextIndex(int index){
        return (index + 1) % list.length;
    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return list[begin];
    }

    public T peekRight(){
        if (isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return list[end-1];
    }

    public void insert(T item) {
        if (isFull()) {
            throw new RuntimeException("queue is full");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T removeLeft(){
        T item = peekLeft();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return item;
    }

    public T removeRight(){
        T item = peekRight();
        size--;
        list[end-1] = null;
        end = nextIndex(end);
        return item;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == list.length;
    }


//    todo remake method. add begin and end
    private void reCapacity(int newCapacity){
        T[] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArr, 0, size);
        list = tempArr;
    }
}
