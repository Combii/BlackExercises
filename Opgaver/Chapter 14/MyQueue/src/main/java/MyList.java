import java.util.Iterator;

/**
 * Created by David Stovlbaek on 25/09/16.
 */
public interface MyList<E> extends Iterable<E>{

    /**
     * @param data inserts the element into the Queue
     */
    void add(E data);

    /**
     * @return the size of the list
     */
    int size();

    /**
     * @return ListNode
     * @throws IndexOutOfBoundsException if index out of bounds
     */
    ListNode get(int index);

    void set(int index, int value) throws Exception;

    void clearList();

    void transferFrom(LinkedListGeneric list1);

    boolean notEquals(LinkedListGeneric list2);

    void removeRange(int startIndex, int endIndex) throws IllegalArgumentException;

    void moveNode(int oldIndex, int newIndex);

    void addAllArrToList(E[] arr);

    /**
     * Checks if given Element exist in List
     * @return true if contains Data else false
     */
    boolean contains(E o);

}
