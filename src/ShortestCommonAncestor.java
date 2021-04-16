public class ShortestCommonAncestor {
    private Digraph graph;
    // constructor takes a rooted DAG as argument
    public ShortestCommonAncestor(Digraph G){
        graph = new Digraph(G);
    }
    // length of shortest ancestral path between v and w
    public int length(int v, int w){
        return -1; //todo change
    }
    // a shortest common ancestor of vertices v and w
    public int ancestor(int v, int w){
        return -1; //todo change
    }
    // length of shortest ancestral path of vertex subsets A and B
    public int lengthSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB){
        return -1; //todo change
    }
    // a shortest common ancestor of vertex subsets A and B
    public int ancestorSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB){
        return -1; //todo change
    }
    // unit testing (required)
    public static void main(String[] args){

    }
}