
import BooksGraphTree.AbstractGraph;
import BooksGraphTree.UnweightedGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by David Stovlbaek on 19/10/16.
 */
public class Exercises {
    public static void main(String[] args) throws IOException {

        UnweightedGraph<Integer> graph = createGraphFromFile();
        System.out.println(graph);
        System.out.println(checkIfConnected(graph));
    }


    public static UnweightedGraph<Integer> createGraphFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Write file path: ");
        String file = sc.nextLine();
        sc.close();
        return createGraphFromFile(new File(file));
    }

    private static UnweightedGraph<Integer> createGraphFromFile(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);

        List<AbstractGraph.Edge> edges = new ArrayList<>();
        int ammountOfVertices = Integer.parseInt(sc.next());

        while(sc.hasNext()){
            int vertex = Integer.parseInt(sc.next());
            Scanner tempSc = new Scanner(sc.nextLine());

            while(tempSc.hasNext()){
                edges.add(new AbstractGraph.Edge(vertex,Integer.parseInt(tempSc.next())));
            }
        }
        sc.close();
        return new UnweightedGraph<>(edges, ammountOfVertices);
    }
    
    public static boolean checkIfConnected(UnweightedGraph graph){
        return graph.bfs(graph.getSize()-1).getNumberOfVerticesFound() == graph.getSize();
    }
}
