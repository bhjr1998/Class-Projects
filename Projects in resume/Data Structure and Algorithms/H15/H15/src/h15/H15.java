/*
 * Get first 100 words from a txt files and put them into a hash table.
 * Than find the amount of accesses needed for both succesful and unsucessul searches within the hash table.
 * 
 */
package h15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * Barry Hoinacki Jr
 */
public class H15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[]hashTable = new String[121];//Create intial array
        for (int i = 0;i<121;i++) hashTable[i] = "";//Intialize them all with a blank string
        hashTable = insertHash(hashTable);//Call the method to insert the words and sort them into the hash table and also find the successful searches.
        totalAccessesNotInTable(hashTable);//Call the method to find the amount of unsuccessful searches in the hash table.
        //printTable(hashTable);
    }
    
    public static String[] insertHash(String[] hash){
        //intialize file
        File f = new File("words_no_duplicates.txt");
        Scanner fileInput = null;
        try {
            fileInput = new Scanner(f);
        } catch (FileNotFoundException e) {
        }
        //Intialize variables
        String currentword = "";
        int val1 = 0;
        int val2 = 0;
        int total = 0;
        char char1 = ' ';
        char char2 = ' ';
        int accesses = 0;
        int length = hash.length;
        //Start for loop with 100 being the 100 words.
        for (int i = 0;i<100;i++){
            //Get the current word and the ascii values of the sum total of it's first two letters and than use the mod on the number.
          currentword = fileInput.next();
          char1 = currentword.charAt(0);
          char2 = currentword.charAt(1);
          val1 = (int)char1;
          val2 = (int)char2;
          total = val1 + val2;
          total = total % 121;
          //While loop to check the length of the current spot in the hash table to see if a word is in there.
          while(hash[total].length() != 0){
          if (total < length-1) total++;//If not add to the number to search for the next spot in the table
          else total = 0;//But make it a 0 if the value doesn't go over the actual amount of spots in the array.
          accesses++;//Add 1 to the total amount of accesses.
          
          }//end while
          //When it's blank add the word and also add one to the amount of accesses done.
          hash[total] = currentword;
          accesses++;
        }//end for
        
        //Start finding the average amount of successful searches.
        double accessavg = 0.0;
        accessavg = (double) accesses / 100.0;
        //Print out succesful searches and the average.
        System.out.println("The total number of probes in a successful search is " + accesses);
        System.out.println("The average number of probes in a successful search is " + accessavg);
        return hash;
    }
    
     public static void totalAccessesNotInTable(String[] hash){
         int accesses = 0;
         int length = hash.length;
         //Start for loop with 100 being the 100 words.
         for(int i = 0;i<length;i++){
         int k=i;
         //While loop to check the length of the current spot in the hash table to see if a word is in there.
          while(hash[k].length() != 0){
          if (k < length-1) k++; //If not add to the number to search for the next spot in the table
          else k = 0;//But make it a 0 if the value doesn't go over the actual amount of spots in the array.
          accesses++;//Add 1 to the total amount of accesses.
          
          }//end while
          accesses++;//Add 1 to the total amount of accesses when it finds a blank spot.
        }//end for
         
        //Start finding the average amount of unsuccessful searches.
        double accessavg = 0.0;
        accessavg = (double) accesses / 121.0;
        //Print out unsuccesful searches and the average.
        System.out.println("The total number of probes in a unsuccessful search is " + accesses);
        System.out.println("The average number of probes in a unsuccessful search is " + accessavg);
     }
     
     public static void printTable(String[] hash){
         int length = hash.length;
         for (int i = 0;i< length; i++){
             System.out.println(hash[i]);
         }
     }
    
}
