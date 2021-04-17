import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShortestCommonAncestor {
    private Digraph DAG; // Directed Acylic Graph
    private BreadthFirstDirectedPaths dag1, dag2;
   // constructor takes a rooted DAG as argument
   public ShortestCommonAncestor(Digraph G){
        if (G == null) throw new java.lang.IllegalArgumentException("Digraph is null");
        this.DAG = G;
   }

   // length of shortest ancestral path between v and w
   public int length(int v, int w){
        // Check to see if either vertex are in range, throw exception if they are outside the prescribed range
        if (v < 0 || v > DAG.V()) throw new java.lang.IllegalArgumentException("v is out of range");
        if (w < 0 || w > DAG.V()) throw new java.lang.IllegalArgumentException("w is out of range");
        
        // Create two graphs for the two vertices
        dag1 = new BreadthFirstDirectedPaths(DAG, v);
        dag2 = new BreadthFirstDirectedPaths(DAG, w);
        
        int vertex = DAG.V();
        int minLength = Integer.MAX_VALUE;
        // Go through the vertices and measure out the length, update the length whenever the distance (edges) to the two graphs are greater than the length
        for (int i = 0; i < vertex; i++){
            if (dag1.hasPathTo(i) && dag2.hasPathTo(i)){
                if (minLength > dag1.distTo(i) + dag2.distTo(i)) {
                    minLength = dag1.distTo(i) + dag2.distTo(i);
                }
            }
        }
        // If the length never changed, then the vertex is its own ancestor, otherwise return the length
        if (minLength == Integer.MAX_VALUE) return -1;
        return minLength;
   }

   // a shortest common ancestor of vertices v and w
   public int ancestor(int v, int w){
        // Check to see if either vertex are in range, throw exception if they are outside the prescribed range
        if (v < 0 || v > DAG.V()) throw new java.lang.IllegalArgumentException("v is out of range");
        if (w < 0 || w > DAG.V()) throw new java.lang.IllegalArgumentException("w is out of range");
          
        // Create two graphs for the two vertices
        dag1 = new BreadthFirstDirectedPaths(DAG, v);
        dag2 = new BreadthFirstDirectedPaths(DAG, w);
        
        int vertex = DAG.V();
        int minLength = Integer.MAX_VALUE;
        int result = -1;
        // Go through the vertices and measure out the length, update the length whenever the distance (edges) to the two graphs are greater than the length
        // Store the number into result
        for (int i = 0; i < vertex; i++){
            if (dag1.hasPathTo(i) && dag2.hasPathTo(i)){
                if (minLength > dag1.distTo(i) + dag2.distTo(i)){
                    minLength = dag1.distTo(i) + dag2.distTo(i);
                    result = i;
                }
            }
        }
        // If the length never changed, then the vertex is its own ancestor (-1), otherwise it is the updated length
        return result;
   }

   // length of shortest ancestral path of vertex subsets A and B
   public int lengthSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB){
        // Check to see if either subset points to null
        if (subsetA == null) throw new java.lang.IllegalArgumentException("subsetA is null");
        if (subsetB == null) throw new java.lang.IllegalArgumentException("subsetB is null");
        
        // Create two graphs for the two subsets
        dag1 = new BreadthFirstDirectedPaths(DAG, subsetA);
        dag2 = new BreadthFirstDirectedPaths(DAG, subsetB);
        
        int vertex = DAG.V();
        int minLength = Integer.MAX_VALUE;
        // Go through the subsets and measure out the length, update the length whenever the distance (edges) to the two graphs are greater than the length
        for (int i = 0; i < vertex; i++){
            if (dag1.hasPathTo(i) && dag2.hasPathTo(i)){
                if (minLength > dag1.distTo(i) + dag2.distTo(i)) {
                    minLength = dag1.distTo(i) + dag2.distTo(i);
                }
            }
        }
        // If the length never changed, then the vertex of the subsets are its own ancestor, otherwise return the length
        if (minLength == Integer.MAX_VALUE) return -1;
        return minLength;
   }

   // a shortest common ancestor of vertex subsets A and B
   public int ancestorSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB){
        // Check to see if either subset point to null
        if (subsetA == null) throw new java.lang.IllegalArgumentException("subsetA is null");
        if (subsetB == null) throw new java.lang.IllegalArgumentException("subsetB is null");
                  
        // Create two graphs for the two subsets
        dag1 = new BreadthFirstDirectedPaths(DAG, subsetA);
        dag2 = new BreadthFirstDirectedPaths(DAG, subsetB);
        
        int vertex = DAG.V();
        int minLength = Integer.MAX_VALUE;
        int result = -1;
        // Go through the subsets and measure out the length, update the length whenever the distance (edges) to the two graphs are greater than the length
        // Store the number into result
        for (int i = 0; i < vertex; i++){
            if (dag1.hasPathTo(i) && dag2.hasPathTo(i)){
                if (minLength > dag1.distTo(i) + dag2.distTo(i)){
                    minLength = dag1.distTo(i) + dag2.distTo(i);
                    result = i;
                }
            }
        }
        // If the length never changed, then the vertex of the subsets are its own ancestor (-1), otherwise it is the updated length
        return result;
   }

   // unit testing (required)
   public static void main(String[] args) throws FileNotFoundException{
       File inFile = new File("Data/digraph1.txt");
       Scanner input = new Scanner(inFile);
       Digraph G = new Digraph(input);
       
       ShortestCommonAncestor sca = new ShortestCommonAncestor(G);
       Scanner input1 = new Scanner(System.in);
       while (input1.hasNext()){
           int v = input1.nextInt();
           int w = input1.nextInt();
           int length = sca.length(v, w);
           int ancestor = sca.ancestor(v, w);
           System.out.printf("length = %d, ancestor = %d\n", length, ancestor);
       }
    }
}
