/**
 * Created by David Stovlbaek on 13/09/16.
 */
public class MyArrayListGeneric <E> implements MyQueue<E>, MyDeque<E>{

    private E[] arr;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyArrayListGeneric(){arr = (E[]) new Object[10];
    }

    public int size() {
        return size;
    }

    private E[] getArr() {
        return arr;
    }

    public E get(int index){
        if(index > size) throw new NullPointerException();
        return arr[index];
    }

    public void add(E data){
        if(size + 1 > arr.length){
            extendArr();
            arr[size] = data;
        }
        else{
            arr[size] = data;
        }
        size++;
    }

    public void remove(int index){
        if(index >= size) throw new NullPointerException();

        if(arr.length/2/2 >= size-1 && size > 5){
            compressArr(index);
        }
            for (int i = index; i < size; i++) {
                try {
                    if (arr[i + 1] != null) {
                        arr[i] = arr[i + 1];
                    } else {
                        arr[i] = null;
                    }
                } catch (Exception e) {
                    arr[i] = null;
                }
            }
            size--;
    }

    @SuppressWarnings("unchecked")
    private void extendArr(){
        E[] newArr = (E[]) new Object[(arr.length * 3)/2 + 1];

        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    @SuppressWarnings("unchecked")
    private void compressArr(int index){
        E[] newArr = (E[]) new Object[(arr.length/2)/2+1];

        System.arraycopy(arr, 0, newArr, 0, size);

        arr = newArr;
    }

    @Override
    public String toString() {
        String rString = "[";

        for(int i = 0; i < size; i++){
            if(size-1 == i){
                rString += arr[i];
            }
            else {
                rString += arr[i] + ", ";
            }
        }
        rString += "]";

        return rString;
    }

    /**
     * My Queue Methods
     */
    public E poll(){
        E tempData = get(0);
        remove(0);
        return tempData;
    }

    public boolean remove(){
        try {
            remove(0);
        }
        catch(NullPointerException e){
            return false;
        }
        return true;
    }

    public E peek(){
        return get(0);
    }

    /**
     * My Deque Methods
     */
    public void addFirst(E data){
        MyArrayListGeneric<E> newList = new MyArrayListGeneric<E>();
        newList.add(data);

        for(int i = 0; i < size; i++){
            newList.add(arr[i]);
        }
        arr = newList.getArr();
        size = newList.size();
    }

    public void addLast(E data){
        add(data);
    }

    public E pollFirst(){
        return poll();
    }

    public E pollLast(){
        E tempData = get(size-1);
        remove(size-1);
        return tempData;
    }

    public boolean removeFirst(){
        try{
            remove(0);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean removeLast(){
        try{
            remove(size-1);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public E peekFirst(){
        return peek();
    }

    public E peekLast(){
        return get(size-1);
    }

    public void push(E data){
        addLast(data);
    }

    public E pop(){
       return pollLast();
    }

}
