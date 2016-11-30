/**
 * Created by David Stovlbaek on 24/09/16.
 */
public interface MyQueue<E> {

    /**
     * @param data inserts the element into the Queue
     */
    void add(E data);

    /**
     * @return the first element added to the Queue and removes it before returning it
     * @throws IndexOutOfBoundsException if Queue is empty
     */
    E poll();

    /**
     * Removes the first element added to the Queue
     * @return true if removed successfully else return false
     * @throws IndexOutOfBoundsException if Queue is empty
     */
    boolean remove();

    /**
     * @return the first element added to the Queue but does not remove it after returning it
     * @throws IndexOutOfBoundsException if Queue is empty
     */
    E peek();

    /**
     * @return the size of the list
     */
    int size();
}
