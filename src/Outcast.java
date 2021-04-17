public class Outcast {
    private WordNet WD;
    // constructor takes a WordNet object
    public Outcast(WordNet wordnet){
        this.WD = wordnet;
    }
    
    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns){
       String outCast = null; //
       int maximum = Integer.MIN_VALUE;
       // Go through the array of nouns
       // Compare the current with the maximum, update the outcast noun appropriately
       for (int i = 0; i < nouns.length; i++){
           for (int j = i + 1; j < nouns.length; j++){
               int curDistance = WD.distance(nouns[i], nouns[j]);
               if (curDistance > maximum){
                   maximum = curDistance;
                   outCast = nouns[j];
               }
           }
       }
       return outCast;
   }
    
    // test client (see below)
    public static void main(String[] args){

    }
}
