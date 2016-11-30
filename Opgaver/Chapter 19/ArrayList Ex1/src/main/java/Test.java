import java.util.Random;

/**
 * Created by David Stovlbaek on 13/09/16.
 */
public class Test {

    public static void main(String[] args) {
        MyArrayListGeneric<Integer> list = new MyArrayListGeneric<Integer>();
        Random randomGenerator = new Random();

        for(int i = 0; i < 21; i++){
        list.add(randomGenerator.nextInt(10));
        }

        System.out.println("Size: "+ list.getSize());
        System.out.println("Length: "+ list.getLength());
        while(10 != list.getSize()){
            list.remove(list.getSize()-1);
        }
        System.out.println("Size: "+ list.getSize());

        System.out.println("Length: "+ list.getLength());

        //System.out.println(list.get(4));
    }
}
