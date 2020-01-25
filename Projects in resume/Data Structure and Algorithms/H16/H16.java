/*
 * Program to get input from a file to create a hash table that handles collision via chaining.
 * Than find the total amount of successful and unsuccessful accesses in the hash table.
 * 
 */
package h16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author Barry Hoinacki Jr
 */
public class H16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Intialize the list.
           LinkedList<String>[] mainList = new LinkedList[121];
         for(int i = 0;i<121;i++){
              mainList[i] = new LinkedList<String>();
         }

        mainList = insertHash(mainList);//Call method to fill up list.
        totalSuccessfulAccesses(mainList);//Call method to find total number of successful accesses.
        totalUnsuccessfulAccesses(mainList);//Call method to find total number of unsuccessful accesses.
    }
   //Method to find and print out total of unsuccessful searches. 
    public static void totalSuccessfulAccesses(LinkedList[] mainList){
        int accesses = 0;
        int size = 0;
        int sum = 0;
        int b = 0;
        for (int i=0;i<121;i++){
            size = mainList[i].size();
            b = size;
            //While loop to use temp value to descrease in size each pass.
            //So if size of mainList[2] is 3, it will go 3+2+1 so that the total 6 would be added to accesses after the while loop.
            while (b > 0){
                sum = sum + b;
                b--;
            }//end while
            accesses = accesses + sum;
            
            sum = 0;
        }//end for
        System.out.println("Total amount of successful accesses is: " + accesses);
    }
   //Method to find and print out total of unsuccessful searches.
    public static void totalUnsuccessfulAccesses(LinkedList[] mainList){
        int accesses = 0;
        int size = 0;
        for (int i = 0;i<121;i++){
            size = mainList[i].size();//Get Size
            /* Add size plus 1 to the current number of accesses. 
            So if it was nothing, will still be one access. 
            And if one number was in there, would take 2 due to one needing to know the number is there and the second access to know that you've fallen off the list.
            */ 
            accesses = accesses + (size + 1);
                   
        }//For
        System.out.println("Total amount of unsuccessful accesses, the traditional way, is: " + accesses);
    }
    public static LinkedList[] insertHash(LinkedList[] hash){
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
        
         for (int i = 0;i<4000;i++){
            //Get the current word and the ascii values of the sum total of it's first two letters and than use the mod on the number.
          currentword = fileInput.next();
          char1 = currentword.charAt(0);
          char2 = currentword.charAt(1);
          val1 = (int)char1;
          val2 = (int)char2;
          total = val1 + val2;
          total = total % 121;

          hash[total].addFirst(currentword);//Add it to the front of the linked list in the hash table based on the resulting value.

          
        }//end for
        
        return hash;
    }
}