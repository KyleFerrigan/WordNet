public class ShortestCommonAncestor {
    private Digraph DAG; // Directed Acylic Graph
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
        return -1; //todo change
    }
    // a shortest common ancestor of vertices v and w
    public int ancestor(int v, int w){
        // Check to see if either vertex are in range, throw exception if they are outside the prescribed range
        if (v < 0 || v > DAG.V()) throw new java.lang.IllegalArgumentException("v is out of range");
        if (w < 0 || w > DAG.V()) throw new java.lang.IllegalArgumentException("w is out of range");
        return -1; //todo change
    }
    // length of shortest ancestral path of vertex subsets A and B
    public int lengthSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB){
        // Check to see if either subset points to null
        if (subsetA == null) throw new java.lang.IllegalArgumentException("subsetA is null");
        if (subsetB == null) throw new java.lang.IllegalArgumentException("subsetB is null");
        return -1; //todo change
    }
    // a shortest common ancestor of vertex subsets A and B
    public int ancestorSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB){
        // Check to see if either subset points to null
        if (subsetA == null) throw new java.lang.IllegalArgumentException("subsetA is null");
        if (subsetB == null) throw new java.lang.IllegalArgumentException("subsetB is null");
        return -1; //todo change
    }
    // unit testing (required)
    public static void main(String[] args){

    }
}
