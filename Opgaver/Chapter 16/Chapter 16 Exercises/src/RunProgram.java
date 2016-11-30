/**
 * Created by David Stovlbaek on 27/08/16.
 */
public class RunProgram {

    public static void main(String[] args) throws Exception {

        LinkedIntList list = new LinkedIntList();

        int[] arr = new int[]{8, 7, -4, 19, 0, 43, -8, -7, 2};
        list.addAllArrToList(arr);

        /*for(int i : list){
            System.out.print(i + " ");
        }*/

        System.out.println(list);

        list.shift();

        System.out.println(list);

        //System.out.println(list);

        //list.shift();

        //System.out.println(list);

        //list.removeAll(3);

        //System.out.println(list.removeEvens());

        //System.out.println(list.deleteBack());

        //System.out.println(list.hasTwoConsecutive());

        //System.out.println(list.lastIndexOf(100));

        //System.out.println(list.isSorted());

        //System.out.println(list.countDuplicates());

        //System.out.println(list.lastIndexOf(18));

        //list.remove(1);
        //System.out.println(list.size());

        //System.out.println(list);

        //System.out.println(list.isSorted());

        //System.out.println(list.get(3));

        //System.out.println(list.get(3).value);

        //list.set(3, 400);

        //System.out.println(list.head);
        //System.out.println(list.tail);

        //System.out.println(list.get(4).prev);

        //System.out.println(list.get(4));

        //System.out.println(list.max());

        //System.out.println(list.size());


    }


}
