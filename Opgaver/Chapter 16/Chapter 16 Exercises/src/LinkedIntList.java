import java.util.*;

/**
 * Created by David Stovlbaek on 21/08/16.
 */

// Class LinkedIntList can be used to store a list of integers
public class LinkedIntList implements Iterable<Integer> {

    public ListNode head; // first value in the list
    public ListNode tail; // last value in the list
    private int size = 0;


    // post: constructs an empty list
    public LinkedIntList() {
        head = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    public ListNode get(int index) throws Exception {

        if (index > size() || index < 0) throw new NullPointerException("Index higher or lower than list size.");
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

    public void add(int value) {

        ListNode newNode = new ListNode(value, null);

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

    public boolean remove(int index) throws Exception {

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

    public void set(int index, int value) throws Exception {

        if (size < index || size > index) {
            throw new Exception("Index higher or lower than list size.");
        }
        get(index).value = value;

    }

    public int max() {
        ListNode current = head;
        int max = Integer.MIN_VALUE;

        while (current != null) {
            if (max < current.value) {
                max = current.value;
            }
            current = current.prev;
        }
        return max;
    }

    public boolean isSorted() {

        if (size == -1) return true;

        ListNode current = tail;

        int min = Integer.MIN_VALUE;

        while (current != null) {
            if (min <= current.value) {
                min = current.value;
                current = current.next;
            } else return false;
        }
        return true;
    }

    public void sort() {

        ListNode current = tail;

        int[] sortList = new int[size];
        int counter = 0;

        while (current != null) {
            sortList[counter] = current.value;
            counter++;
            current = current.next;
        }

        Arrays.sort(sortList);

        head = null;
        tail = null;

        for (int i = 0; i < sortList.length; i++) {
            if (i == 0) {
                add(sortList[i]);
            } else {
                add(sortList[i]);
            }
        }
    }

    public int countDuplicates() throws Exception {
        if (!isSorted()) throw new Exception("List is not sorted. Use method sort()");

        ListNode current = tail;
        int counter = 0;

        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                counter++;
            }
            current = current.next;
        }
        return counter;
    }

    public int lastIndexOf(int value) {

        ListNode current = head;
        int counter = size - 1;

        while (current != null) {

            if (current.value == value)
                return counter;

            current = current.prev;
            counter--;
        }
        return -1;
    }

    public boolean hasTwoConsecutive() {

        ListNode current = tail;

        while (current != null && current.next != null) {
            if (current.value == current.next.value - 1) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int deleteBack() throws Exception {
        if (head == null) throw new NoSuchElementException();

        int rInt = get(0).value;
        remove(0);
        return rInt;
    }

    public void clearList() {
        head = null;
        tail = null;
    }

    public void switchPairs() {

        ListNode current = tail;
        ListNode temp;
        int counter = 0;
        head = null;

        int tempSize = size;
        size = 0;

        while (tempSize - 1 > counter) {
            temp = current;
            current = current.next;

            add(current.value);
            add(temp.value);

            current = current.next;
            counter += 2;
        }
        if (tempSize % 2 != 0) {
            add(current.value);
        }

    }

    public void stutter() {
        stretch(2);
    }

    public void stretch(int i) {

        if (i <= 0) {
            head = null;
            tail = null;
            return;
        }
        if (i == 1) return;

        ListNode current = tail;

        int counter = 0;
        head = null;

        int tempSize = size;
        size = 0;

        while (tempSize > counter) {
            for (int k = 0; k < i; k++) {
                add(current.value);
            }
            current = current.next;
            counter += 1;
        }
    }

    public void compress() {

        ListNode current = tail;

        int counter = 0;
        head = null;

        int tempSize = size;
        size = 0;

        while (tempSize - 1 > counter) {

            add(current.value + current.next.value);

            current = current.next.next;
            counter += 2;

        }
        if (tempSize % 2 != 0) {
            add(current.value);
        }

    }

    public void split() {

        ListNode current = tail;
        LinkedIntList postiveList = new LinkedIntList();
        LinkedIntList negativeList = new LinkedIntList();

        while (current != null) {
            if (current.value < 0) {
                negativeList.add(current.value);
            } else {
                postiveList.add(current.value);
            }
            current = current.next;
        }
        postiveList.tail.prev = negativeList.head;
        negativeList.head.next = postiveList.tail;

        tail = negativeList.tail;
        head = postiveList.head;
    }

    public void transferFrom(LinkedIntList list1) {

        list1.tail.prev = head;
        head.next = list1.tail;
        head = list1.head;

        list1.head = null;
        list1.tail = null;
    }

    public void removeAll(int number) throws Exception {

        ListNode current = tail;

        for (int i = 0; i < size; i++) {
            if (number == current.value) {
                remove(i);
                current = get(i);
                i--;
            } else {
                current = current.next;
            }
        }
    }

    public boolean notEquals(LinkedIntList list2) {
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

    public LinkedIntList removeEvens() throws Exception {
        LinkedIntList list2 = new LinkedIntList();

        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                list2.add(get(i).value);
            }
        }
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (counter % 2 == 0) {
                remove(i);
                i--;
            }
            counter++;
        }

        return list2;
    }

    public void removeRange(int startIndex, int endIndex) throws Exception {
        if (startIndex > endIndex || endIndex > size) {
            throw new IllegalArgumentException();
        }
        int counter = startIndex;
        while (counter != endIndex + 1) {
            remove(startIndex);
            counter++;
        }
    }

    public void doubleList() {

        int counter = 0, finalSize = size + 1;
        ListNode current = tail;

        while (counter != finalSize) {
            add(current.value);
            current = current.next;
            counter++;
        }
    }

    public void rotate() {
        ListNode tempNode = head;

        tail = null;
        head = null;

        while (tempNode != null) {
            add(tempNode.value);
            tempNode = tempNode.prev;
        }
    }

    public void shift() throws Exception {
        int counter = 0, check = 0;

        while (counter != size - 1) {
            if (counter % 2 != 0) {
                moveNode(counter - check, size);
                check++;
            }
            counter++;
        }
    }

    public LinkedIntList removeEvensByValue() throws Exception {
        LinkedIntList newList = new LinkedIntList();

        ListNode current = tail;
        int checkSize = size;

        while (current != null) {
            if (current.value % 2 == 0) {
                removeAll(current.value);
                for (int i = 0; i < checkSize - size; i++) {
                    newList.add(current.value);
                }
                checkSize = size;
                current = tail;
            } else {
                current = current.next;
            }
        }
        return newList;
    }
/*
    public void moveNodeIllegal(int oldIndex, int newIndex) throws Exception {

        int nodeValue = get(oldIndex).value;
        remove(oldIndex);
        moveNodeLegit(newIndex - 1, nodeValue);
    }
*/
    public void moveNode(int oldIndex, int newIndex) throws Exception{
        if (newIndex > size || oldIndex < 0) {
            throw new NullPointerException();
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
/*
    private void addByIndex(int index, int value) throws Exception {
        if (index > size || index < 0) {
            throw new NullPointerException();
        }
        ListNode newNode = new ListNode(value);

        if (index == 0) {
            newNode.next = tail;
            tail = newNode;
            tail.next.prev = tail;
            size++;
        } else if (index == size) {
            //add(value); Could also just use this.
            newNode.prev = head;
            head = newNode;
            head.prev.next = head;
            size++;
        } else {
            ListNode node = get(index);
            newNode.next = node;
            node.prev.next = newNode;
            newNode.prev = node.prev;
            node.prev = newNode;
            size++;
        }
    }
*/
    public void addAllArrToList(int[] arr) {
        for (int i : arr) {
            add(i);
        }
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

    public Iterator<Integer> iterator() {
        return new IntListIterator();
    }

    private class IntListIterator implements Iterator<Integer>{

        ListNode current = null;

        public IntListIterator(){
            current = LinkedIntList.this.tail;
        }

        public boolean hasNext(){
            return current != null;
        }

        public Integer next(){
            int number = current.value;
            current = current.next;
            return number;
        }


    }

}