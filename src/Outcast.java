import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

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
   public static void main(String[] args) throws FileNotFoundException{
       WordNet test = new WordNet("data/synsets.txt","data/hypernyms.txt"); //create new WordNet
       Outcast cast = new Outcast(test);
       for (int i = 0; i < 3; i++){
           Scanner input = new Scanner(System.in);
           System.out.print("Enter the file name: ");
           String fileName = input.nextLine();
           System.out.print("Enter the file size: ");
           int fileSize = input.nextInt();
           
           File inFile = new File(fileName);
           Scanner input1 = new Scanner(inFile);
           String[] nouns = new String[fileSize];
           
           int j = 0;
           while(input1.hasNextLine()){
               nouns[j] = input1.nextLine();
               j++;
           }
           System.out.println(fileName + ": " + cast.outcast(nouns));
       }
   }
}
