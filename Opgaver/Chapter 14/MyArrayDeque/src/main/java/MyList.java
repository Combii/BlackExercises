/**
 * Created by David Stovlbaek on 25/09/16.
 */
public interface MyList<E> {

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
    E get(int index);

    void remove(int index);

    void clearList();

    /**
     * Checks if given Element exist in List
     * @return true if contains Data else false
     */
    boolean contains(E o);

}
