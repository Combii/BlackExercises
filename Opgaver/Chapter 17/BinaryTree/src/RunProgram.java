/**
 * Created by David Stovlbaek on 29/09/16.
 */
public class RunProgram {

   public static void main(String[] args) {

       IntTree t = new IntTree(5);
       t.myTreeEx8();


       System.out.println("Tree structure:");
       t.printSideways();
       t.printLevel(3);
       System.out.println();
       /*t.printPreOrder();
       System.out.println();
       /*
       t.printInOrder();
       t.printPostOrder();
       System.out.println();
       */

       //System.out.println(t);
    }
}
