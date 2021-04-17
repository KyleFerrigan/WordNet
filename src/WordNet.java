import java.util.*;
import java.io.*;

public class WordNet {
    private HashMap hMapSys = new HashMap<Integer, Bag<String>>();
    private HashMap hMapHyp = new HashMap<Integer, Bag<Integer>>();
    private Digraph DAG;
    private Iterable<String> nounCache;
    ShortestCommonAncestor SCA;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) throws FileNotFoundException {
        if (synsets == null) throw new java.lang.IllegalArgumentException("synsets is null");
        if (hypernyms == null) throw new java.lang.IllegalArgumentException("hypernyms is null");

        File  synsetsFile = new File(synsets);
        File hypernymsFile = new File(hypernyms);

        Scanner scan = new Scanner(synsetsFile);
        String nextLineCache; // Holds next line without iterating more than once
        String[] splitCache; //holds string from split function
        while (scan.hasNextLine()){
            nextLineCache = scan.nextLine(); //store next up so it can be used multiple times without iterating
            splitCache = new String[nextLineCache.split(",").length];//store length

            splitCache = nextLineCache.split(",");

            Bag bagTemp = new Bag<String>();

            bagTemp.add(splitCache[2]);
            bagTemp.add(splitCache[1]);

            hMapSys.put(Integer.parseInt(splitCache[0]),bagTemp);
        }

        scan = new Scanner(hypernymsFile);
        while (scan.hasNextLine()){
            nextLineCache = scan.nextLine(); //store next up so it can be used multiple times without iterating
            splitCache = new String[nextLineCache.split(",").length];//store length
            splitCache = nextLineCache.split(",");
            Bag bagTemp = new Bag<Integer>();

            for (int i = 1; i<splitCache.length; i++){
                bagTemp.add(Integer.parseInt(splitCache[i]));
            }
            hMapHyp.put(Integer.parseInt(splitCache[0]),bagTemp);
        }

        //populate digraph
        DAG = new Digraph(hMapHyp.size());//Assumed sysnet and hypernym are the same size
        for(int i = 0; i<hMapHyp.size(); i++){
            Iterator itr = ((Iterable<Integer>)((Bag<Integer>)(hMapHyp.get(i)))).iterator();
            for (int j = 0; j<((Bag<Integer>)hMapHyp.get(i)).size(); j++){ //Depending on size of bag, iterate
                DAG.addEdge(i,(int)itr.next()); //add as many edges as there are todo iterator might not work right without instantiating earlier between i and j loop
            }
        }
    }

    // the set of all WordNet nouns
    public Iterable<String> nouns(){
        ArrayList nouns = new ArrayList();
        String[] nounsSplitTemp;//temporary data variable to
        for(int i = 0; i<hMapSys.size(); i++){//iterates through whole synsets hashmap
            Iterator<String> itr = ((Bag<String>)hMapSys.get(i)).iterator();//get iterator of the bag in order to retrieve data
            nounsSplitTemp = itr.next().split(" ");//split nouns based on spaces
            for (int j = 0; j<nounsSplitTemp.length; j++){//for the amount of nouns in this key
                if (!nouns.contains(nounsSplitTemp[j])){//check against current nouns to only get unique nouns
                    nouns.add(nounsSplitTemp[j]);//add to unique nouns
                }
            }
        }
        nounCache = nouns;
        return (Iterable<String>) nouns;
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word){
        if (word == null) throw new java.lang.IllegalArgumentException(word + " is null");

       /* if (nounCache == null){//if cached, skip re-running nouns
            nouns();
        }
        Iterator itr = nounCache.iterator();
        while(itr.hasNext()){
            if (itr.next().toString().equals(word)){
                return true;
            }
        }
        return false;*/

        String[] splitCache;
        for (int i = 0; i<hMapSys.size(); i++){
            Iterator itr = ((Bag<String>)hMapSys.get(i)).iterator();
            while (itr.hasNext()){
                String strCache = itr.next().toString();
                splitCache = strCache.split(" ");
                for(int j= 0; j<splitCache.length; j++){
                    if (word.equals(splitCache[j])){//if equals to current string and hasnt already been found
                        return true;
                    }

                }

            }
        }
        return false;
    }

    // a synset (second field of synsets.txt) that is a shortest common ancestor of noun1 and noun2 (defined below)
    public String sca(String noun1, String noun2){
        if (noun1 == null) throw new java.lang.IllegalArgumentException(noun1 + " is null");
        if (noun2 == null) throw new java.lang.IllegalArgumentException(noun2 + " is null");
        //if (isNoun(noun1)||isNoun(noun2)) throw new java.lang.IllegalStateException(noun1 + "or" + noun2 + "is not a noun"); //todo renable this before turning in


        //Find number associated with noun
        int noun1Num = -1;
        int noun2Num = -1;
        String[] splitCache;
        for (int i = 0; i<hMapSys.size(); i++){
            Iterator itr = ((Bag<String>)hMapSys.get(i)).iterator();
            while (itr.hasNext()){
                String strCache = itr.next().toString();
                splitCache = strCache.split(" ");
                for(int j= 0; j<splitCache.length; j++){
                    if (noun1.equals(splitCache[j]) && noun1Num == -1){//if equals to current string and hasnt already been found
                        noun1Num = i;
                    }
                    if (noun2.equals(splitCache[j]) && noun2Num == -1){//if equals to current string and hasnt already been found
                        noun2Num = i;
                    }
                    if (noun2Num != -1 && noun1Num != -1){//if both are already found
                        break; //break for efficiency no need to search further
                    }
                }

            }
        }

        //Find closest ancestor using SCA Digraph
        if (SCA == null){//If SCA hasnt already been initialized
            SCA = new ShortestCommonAncestor(DAG);//Initialize SCA
        }
        int ancest = SCA.ancestor(noun1Num, noun2Num);//Find nearest ancestor for given nouns

        //Find Nouns associated with nearest ancestor number
        Iterator itr = ((Bag<String>) hMapSys.get(ancest)).iterator(); //create iterator to get information from bag
        String strCache = itr.next().toString(); //Grab first item in iterator which is the nouns
        return strCache;
    }

    // distance between noun1 and noun2 (defined below)
    public int distance(String noun1, String noun2){
        if (noun1 == null) throw new java.lang.IllegalArgumentException(noun1 + " is null");
        if (noun2 == null) throw new java.lang.IllegalArgumentException(noun2 + " is null");
        if (isNoun(noun1)||isNoun(noun2)) throw new java.lang.IllegalStateException(noun1 + "or" + noun2 + "is not a noun");//Error checking to make sure nouns exist

        //Find number associated with noun
        int noun1Num = -1;
        int noun2Num = -1;
        String[] splitCache;
        for (int i = 0; i<hMapSys.size(); i++){
            Iterator itr = ((Bag<String>)hMapSys.get(i)).iterator();
            while (itr.hasNext()){
                String strCache = itr.next().toString();
                splitCache = strCache.split(" ");
                for(int j= 0; j<splitCache.length; j++){//for the length of the number of words in the current key
                    if (noun1.equals(splitCache[j]) && noun1Num == -1){//if equals to current string and hasnt already been found
                        noun1Num = i;//set location of noun1num
                    }
                    if (noun2.equals(splitCache[j]) && noun2Num == -1){//if equals to current string and hasnt already been found
                        noun2Num = i;//set location of noun2num
                    }
                    if (noun2Num != -1 && noun1Num != -1){//if both found
                        break; //break for efficiency no need to search further
                    }
                }
            }
        }

        //Digraph distance using SCA
        if (SCA == null){
            SCA = new ShortestCommonAncestor(DAG);
        }
        return SCA.length(noun1Num, noun2Num);
    }

    // unit testing (required)
    public static void main(String[] args) throws FileNotFoundException {
        WordNet test = new WordNet("Data/synsets.txt","Data/hypernyms.txt");
        /*Iterator itr =  test.nouns().iterator();
        int count = 0;
        while(itr.hasNext()) {
            count++;
            System.out.println(itr.next());
        }
        System.out.println("Unique Words: " + count);*/
        System.out.println(test.isNoun("Parvati"));
        System.out.println(test.sca("zymosis","fermentation"));
    }
}
