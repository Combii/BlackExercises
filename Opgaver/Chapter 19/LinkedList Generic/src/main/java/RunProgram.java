import java.util.ArrayList;

/**
 * Created by David Stovlbaek on 27/08/16.
 */
public class RunProgram {

    public static void main(String[] args) throws Exception {

        new ArrayList();

        LinkedListGeneric<Integer> list = new LinkedListGeneric<Integer>();

        Integer[] arr = new Integer[]{8, 7, -4, 19, 0, 43, -8, -7, 2};
        list.addAllArrToList(arr);


        list.get(5);

        /*list.add("3");
        list.add("3");
        list.add("3");
        list.add("3");


        for(String i : list){
            System.out.print(i + " ");
        }*/

        //System.out.println(list);


    }


}
