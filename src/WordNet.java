import java.util.*;

public class WordNet {
    HashMap hMap = new HashMap<Integer, String>();
    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms){
        if (synsets == null) throw new java.lang.IllegalArgumentException("synsets is null");
        if (hypernyms == null) throw new java.lang.IllegalArgumentException("hypernyms is null");
        Scanner scan = new Scanner(System.in);

    }

    // the set of all WordNet nouns
    public Iterable<String> nouns(){
        return null; //todo change
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word){
        if (word == null) throw new java.lang.IllegalArgumentException(word + " is null");
        return false;//todo change
    }

    // a synset (second field of synsets.txt) that is a shortest common ancestor // of noun1 and noun2 (defined below)
    public String sca(String noun1, String noun2){
        if (noun1 == null) throw new java.lang.IllegalArgumentException(noun1 + " is null");
        if (noun2 == null) throw new java.lang.IllegalArgumentException(noun2 + " is null");
        return null;//todo change
    }

    // distance between noun1 and noun2 (defined below)
    public int distance(String noun1, String noun2){
        if (noun1 == null) throw new java.lang.IllegalArgumentException(noun1 + " is null");
        if (noun2 == null) throw new java.lang.IllegalArgumentException(noun2 + " is null");
        return -1;//todo change
    }

    // unit testing (required)
    public static void main(String[] args){

    }
}
