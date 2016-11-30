package GraphMatrix;

import java.util.Arrays;

/**
 * Created by David Stovlbaek on 20/10/16.
 */
public class GraphMatrix {

    public static void main(String[] args) {
        int[][] myGraph1 = new int[6][6];

        myGraph1[0][1] = 1;
        myGraph1[0][2] = 1;
        myGraph1[0][3] = 1;

        myGraph1[1][0] = 1;
        myGraph1[1][2] = 1;

        myGraph1[2][0] = 1;
        myGraph1[2][3] = 1;
        myGraph1[2][4] = 1;
        myGraph1[2][0] = 1;

        myGraph1[3][1] = 1;
        myGraph1[3][2] = 1;
        myGraph1[3][4] = 1;
        myGraph1[3][5] = 1;

        myGraph1[4][2] = 1;
        myGraph1[4][3] = 1;
        myGraph1[4][5] = 1;

        myGraph1[5][3] = 1;
        myGraph1[5][4] = 1;

        int counter = 0;
        for (int[] arr : myGraph1) {
            System.out.println(counter + ": " + Arrays.toString(arr));
            counter++;
        }
    }

    public static boolean checkGraphEquals(int[][] graph1, int[][] graph2){
        if(graph1.length != graph2.length)
            return false;

        for (int i = 0; i < graph1.length; i++) {
            for (int j = 0; j < graph1.length; j++) {
                if(graph1[i][j] != graph2[i][j]) return false;
            }
        }
        return true;
    }
}
