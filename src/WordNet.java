public class WordNet {
    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms){

    }
    // the set of all WordNet nouns
    public Iterable<String> nouns(){
        return null; //todo change
    }
    // is the word a WordNet noun?
    public boolean isNoun(String word){
        return false;//todo change
    }
    // a synset (second field of synsets.txt) that is a shortest common ancestor // of noun1 and noun2 (defined below)
    public String sca(String noun1, String noun2){
        return null;//todo change
    }
    // distance between noun1 and noun2 (defined below)
    public int distance(String noun1, String noun2){
        return -1;//todo change
    }
    // unit testing (required)
    public static void main(String[] args){

    }
}