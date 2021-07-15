package lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
    private MyNode first;
    private MyNode last;
    private int size;

//  2. Добавить итератор для класса MyLinkedList

    @Override
    public Iterator<E> iterator() {
        return new MyIter();
    }

    private class MyIter implements Iterator<E> {
        MyNode current = new MyNode(null, first);
        private int index;

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();

            current = current.getNext();
            return current.getValue();
        }
    }

    public void insertFirst(E item) {
        MyNode newMyNode = new MyNode(item, first);
        if (isEmpty()) {
            last = newMyNode;
        } else {
            first.setPrev(newMyNode);
        }
        first = newMyNode;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        E temp = first.getValue();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return temp;
    }

    public void insertLast(E item) {
        MyNode newMyNode = new MyNode(last, item, null);
        if (isEmpty()) {
            first = newMyNode;
        } else {
            last.setNext(newMyNode);
        }
        last = newMyNode;
        size++;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        E temp = last.getValue();
        if (last.getPrev() == null) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        size--;
        return temp;
    }


    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        return first.getValue();
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        return last.getValue();
    }

    public void insert(int index, E item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index: " + index);
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        if (index == size) {
            insertLast(item);
            return;
        }

        MyNode current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        MyNode newMyNode = new MyNode(current, item, current.getNext());
        current.setNext(newMyNode);
        newMyNode.getNext().setPrev(newMyNode);
        size++;
    }

    public boolean remove(E item) {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        if (first.getValue().equals(item)) {
            removeFirst();
            return true;
        }

        MyNode current = first;
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }

        if (current == last) {
            removeLast();
            return true;
        }

        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
        size--;
        return true;
    }

    public boolean contains(E item) {
        return index(item) > -1;
    }

    public int indexOf(E item) {
        return index(item);
    }

    private int index(E item) {
        MyNode current = first;
        int index = 0;
        while (current != null) {
            if (current.getValue().equals(item)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    private class MyNode {
        MyNode prev;
        E value;
        MyNode next;

        public MyNode(E value, MyNode next) {
            this.value = value;
            this.next = next;
        }

        public MyNode(MyNode prev, E value, MyNode next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public MyNode getNext() {
            return next;
        }

        public void setNext(MyNode next) {
            this.next = next;
        }

        public MyNode getPrev() {
            return prev;
        }

        public void setPrev(MyNode prev) {
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyNode current = first;
        while (current != null) {
            sb.append(current.getValue()).append(", ");
            current = current.getNext();
        }
        return sb.toString();
    }
}
