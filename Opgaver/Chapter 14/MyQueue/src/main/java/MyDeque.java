/**
 * Created by David Stovlbaek on 25/09/16.
 */
public interface MyDeque<E> extends Iterable<E>{
    
    /**
     * @param data inserts the element into the tail of Deque
     */
    void addFirst(E data);

    /**
     * @param data inserts the element into the head of Deque
     *             same as add(E data)
     */
    void addLast(E data);

    /**
     * @return the first element added to the Deque and removes it before returning it
     *         same as poll()
     * @throws IndexOutOfBoundsException if Deque is empty
     */
    E pollFirst();

    /**
     * @return the last element added to the Deque and removes it before returning it
     *         same as poll()
     * @throws IndexOutOfBoundsException if Deque is empty
     */
    E pollLast();

    /**
     * Removes the first element added to the Deque
     * @return true if removed successfully else return false
     * @throws IndexOutOfBoundsException if Deque is empty
     */
    boolean removeFirst();

    /**
     * Removes the last element added to the Deque
     * @return true if removed successfully else return false
     * @throws IndexOutOfBoundsException if Deque is empty
     */
    boolean removeLast();

    /**
     * @return the first element added to the Deque but does not remove it after returning it
     * @throws IndexOutOfBoundsException if Deque is empty
     */
    E peek();

    /**
     * @return the first element added to the Deque but does not remove it after returning it
     *         same as peek()
     * @throws IndexOutOfBoundsException if Deque is empty
     */
    E peekFirst();

    /**
     * @return the last element added to the Deque but does not remove it after returning it
     * @throws IndexOutOfBoundsException if Deque is empty
     */
    E peekLast();

    /**
     * @return the size of the list
     */
    int size();

    /**
     * For old school Stack method
     * @param data inserts the element into the tail of Deque
     */
    void push(E data);

    /**
     * For old school Stack method
     * @return data from first element added and removes from List before return (First in First out)
     */
    E pop();

    /**
     * Checks if given Element exist in List
     * @return true if contains Data else false
     */
    boolean contains(E o);

}
