import java.util.Arrays;

/**
 * Created by David Stovlbaek on 13/09/16.
 */
public class MyArrayListGeneric <T>{

    private T[] arr;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyArrayListGeneric(){arr = (T[]) new Object[10];
    }

    public int getSize() {
        return size;
    }

    public int getLength(){return arr.length;}

    public T get(int index){
        if(index > size) throw new NullPointerException();
        return arr[index];
    }

    public void add(T data){
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
        T[] newArr = (T[]) new Object[(arr.length * 3)/2 + 1];

        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    @SuppressWarnings("unchecked")
    private void compressArr(int index){
        T[] newArr = (T[]) new Object[(arr.length/2)/2+1];

        System.arraycopy(arr, 0, newArr, 0, size);

        arr = newArr;
    }

    @Override
    public String toString() {
        String rString = "[";

        for(int i = 0; i < size; i++){
            if(size-1 == i){
                rString += arr[i] + "]";
            }
            else {
                rString += arr[i] + ", ";
            }
        }
        return rString;
    }
}
