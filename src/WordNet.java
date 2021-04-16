import java.util.*;
import java.io.*;

public class WordNet {
    private HashMap hMapSys = new HashMap<Integer, Bag<String>>();
    private HashMap hMapHyp = new HashMap<Integer, Bag<Integer>>();
    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) throws FileNotFoundException {
        if (synsets == null) throw new java.lang.IllegalArgumentException("synsets is null");
        if (hypernyms == null) throw new java.lang.IllegalArgumentException("hypernyms is null");

        File  sysnetsFile = new File("Data/sysnets.txt");
        File hypernymsFile = new File("Data/hypernyms.txt");

        Scanner scan = new Scanner(sysnetsFile);
        String nextLineCache; // Holds next line without iterating more than once
        String[] splitCache; //holds string from split function
        while (scan.hasNextLine()){
            nextLineCache = scan.nextLine(); //store next up so it can be used multiple times without iterating
            splitCache = new String[nextLineCache.split(",").length];//store length
            splitCache = nextLineCache.split(",");
            Bag bagTemp = new Bag<String>();

            bagTemp.add(splitCache[1]);
            bagTemp.add(splitCache[2]);
            hMapSys.put(Integer.parseInt(splitCache[0]),bagTemp);
        }

        scan = new Scanner(hypernymsFile);
        while (scan.hasNextLine()){
            nextLineCache = scan.nextLine(); //store next up so it can be used multiple times without iterating
            splitCache = new String[nextLineCache.split(",").length];//store length
            splitCache = nextLineCache.split(",");
            Bag bagTemp = new Bag<Integer>();

            bagTemp.add(Integer.parseInt(splitCache[1]));
            bagTemp.add(Integer.parseInt(splitCache[2]));
            hMapSys.put(Integer.parseInt(splitCache[0]),bagTemp);
        }


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
