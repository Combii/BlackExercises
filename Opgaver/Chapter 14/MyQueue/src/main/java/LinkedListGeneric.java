import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.util.*;

/**
 * Created by David Stovlbaek on 21/08/16.
 */

// Class LinkedListGeneric can be used to store a list of integers
public class LinkedListGeneric<E> implements MyQueue<E>, MyDeque<E>, MyList<E>, Iterable<E> {

    public ListNode head; // first value in the list
    public ListNode tail; // last value in the list
    private int size = 0;


    // post: constructs an empty list
    public LinkedListGeneric() {
        head = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    public ListNode get(int index) throws IndexOutOfBoundsException {
        if (index > size() || index < 0) throw new IndexOutOfBoundsException("Index higher or lower than list size.");
        ListNode node;

        if (size / 2 < index) {
            node = head;
            for (int i = size - 1; i >= index + 1; i--)
                node = node.prev;
        } else {
            node = tail;
            for (int i = 1; i <= index; i++)
                node = node.next;
        }
        return node;
    }

    @SuppressWarnings("unchecked")
    public void add(E value) {

        ListNode newNode = new ListNode(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(head);
            head.setNext(newNode);
            head = newNode;
        }
        size++;
    }

    public boolean remove(int index) throws IndexOutOfBoundsException {

        if(size == 1){
            tail = null;
            head = null;
            size--;
            return true;
        }

        if (index == 0) {
            tail = tail.next;
            tail.prev = null;
            size--;
            return true;
        } else if (index == size - 1) {
            head = head.prev;
            head.next = null;
            size--;
            return true;
        }

        ListNode node = get(index);
        if (node.next != null && node.prev != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
            return true;
        }
        return false;
    }

    public boolean contains(E o) {
        Iterator<E> it = iterator();
        if (o==null) {
            while (it.hasNext())
                if (it.next()==null)
                    return true;
        } else {
            while (it.hasNext())
                if (o.equals(it.next()))
                    return true;
        }
        return false;
    }

    public void set(int index, int value) throws Exception {

        if (size < index || size > index) {
            throw new Exception("Index higher or lower than list size.");
        }
        get(index).value = value;

    }

    public void clearList() {
        head = null;
        tail = null;
    }

    public void transferFrom(LinkedListGeneric list1) {

        list1.tail.prev = head;
        head.next = list1.tail;
        head = list1.head;

        list1.head = null;
        list1.tail = null;
    }

    public boolean notEquals(LinkedListGeneric list2) {
        if (list2.size != size) {
            return true;
        }

        ListNode current = tail;
        ListNode current2 = list2.tail;

        while (current != null) {
            if (current.value != current2.value) {
                return true;
            }
            current = current.next;
            current2 = current2.next;
        }
        return false;
    }

    public void removeRange(int startIndex, int endIndex) throws IllegalArgumentException {
        if (startIndex > endIndex || endIndex > size) {
            throw new IllegalArgumentException();
        }
        int counter = startIndex;
        while (counter != endIndex + 1) {
            remove(startIndex);
            counter++;
        }
    }

    public void moveNode(int oldIndex, int newIndex) throws IndexOutOfBoundsException{
        if (newIndex > size || oldIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        ListNode newNode = get(oldIndex);
        remove(oldIndex);

        if (newIndex == 0) {
            newNode.next = tail;
            tail = newNode;
            tail.next.prev = tail;
            size++;
        } else if (newIndex == size) {
            newNode.prev = head;
            head = newNode;
            head.prev.next = head;
            size++;
        } else {
            ListNode node = get(newIndex);
            newNode.next = node;
            node.prev.next = newNode;
            newNode.prev = node.prev;
            node.prev = newNode;
            size++;
        }

    }

    public void addAllArrToList(E[] arr) {
        for (E i : arr) {
            add(i);
        }
    }

    /**
     * MyQueue Methods
     */
    @SuppressWarnings("unchecked")
    public E poll() throws IndexOutOfBoundsException{
        ListNode temp = tail;
        remove();
        return (E) temp.value;
    }

    public boolean remove() throws IndexOutOfBoundsException{
        try {
            remove(0);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public E peek() throws IndexOutOfBoundsException{
        return (E) tail.value;
    }

    /**
     * MyDeQueue Methods
     */
    @SuppressWarnings("unchecked")
    public void addFirst(E data){
        if(size == 0) {
            add(data);
        }
        else{
            ListNode newNode = new ListNode(data);
            newNode.next = tail;
            tail = newNode;
            tail.next.prev = tail;
            size++;
        }
    }

    public void addLast(E data){
        add(data);
    }

    public E pollFirst() throws IndexOutOfBoundsException{
        return poll();
    }

    @SuppressWarnings("unchecked")
    public E pollLast() throws IndexOutOfBoundsException{
        ListNode temp = head;
        remove(size-1);
        return (E) temp.value;
    }

    public boolean removeFirst(){
        return remove();
    }

    public boolean removeLast(){
        return remove(size-1);
    }

    public E peekFirst() throws IndexOutOfBoundsException{
        return peek();
    }

    @SuppressWarnings("unchecked")
    public E peekLast() throws IndexOutOfBoundsException{
        return (E) head.value;
    }

    public void push(E data){
    addFirst(data);
    }

    public E pop(){
    return pollFirst();
    }

    @Override
    public String toString() {
        String rString = "[";

        ListNode current = tail;

        while (current != null) {
            rString += current;
            if (current.next != null) {
                rString += ", ";
            }
            current = current.next;
        }
        rString += "]";

        return rString;
    }

    public Iterator<E> iterator() {
        return new ListIterator<E>();
    }

    private class ListIterator<E> implements Iterator<E>{
        ListNode current = null;
        int counter = 0;

        public ListIterator(){
            current = LinkedListGeneric.this.tail;
        }

        public boolean hasNext(){
            return current != null;
        }

        @SuppressWarnings("unchecked")
        public E next(){
            E number = (E) current.value;
            current = current.next;
            counter++;
            return number;
        }

        public void remove(){
            try{
                LinkedListGeneric.this.remove(counter);
            }
            catch(Exception e){
                current = null;
            }
        }


    }

}