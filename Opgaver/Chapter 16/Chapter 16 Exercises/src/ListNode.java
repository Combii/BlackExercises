/**
 * Created by David Stovlbaek on 21/08/16.
 */
public class ListNode  {

    public int value;      // value stored in this node
    public ListNode prev;  // link to prev node in the list
    public ListNode next;  // link to next node in the list

    // post: constructs a node with value 0 and null link
    public ListNode() {
        this(0, null);
    }

    // post: constructs a node with given value and null link
    public ListNode(int value) {
        this(value, null);
    }

    // post: constructs a node with given value and given link
    public ListNode(int value, ListNode prev)
    {
        this.value = value;
        this.prev = prev;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    public void setNext(ListNode next){
        this.next = next;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
