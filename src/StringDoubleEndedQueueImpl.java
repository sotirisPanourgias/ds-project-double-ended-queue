import java.util.NoSuchElementException;
import java.io.PrintStream;

public class StringDoubleEndedQueueImpl implements StringDoubleEndedQueue {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        String item;
        Node next;
        Node prev;
    }

    public StringDoubleEndedQueueImpl() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        if(size==0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void addFirst(String item) {
        Node first1 = first;
        first = new Node();
        first.item = item;
        first.next = first1;
        if (first1 != null) {
            first1.prev = first;
        }
        if (last == null) {
            last = first;
        }
        size++;
    }

    @Override
    public String removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        String item = first.item;
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }
        size--;
        return item;
    }

    @Override
    public void addLast(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        if (oldLast != null) {
            oldLast.next = last;
        }
        if (first == null) {
            first = last;
        }
        size++;
    }


    @Override
    public String removeLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        String item = last.item;
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        size--;
        return item;
    }

    @Override
    public String getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }else {
            return first.item;
        }
    }

    @Override
    public String getLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }else {
            return last.item;
        }
    }

    @Override
    public void printQueue(PrintStream stream) {
        Node n = first;
        while (n != null) {
            stream.print(n.item + " ");
            n = n.next;
        }
        stream.println();
    }

    @Override
    public int size() {
        return size;
    }
}
