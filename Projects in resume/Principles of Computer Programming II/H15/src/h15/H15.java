/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package h15;

/**
 *
 * @author bh19601
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class H15 {

    /**
     * @param args the command line arguments
     */
 
 
 //Class for Rectangles.
    public static class Rectangle implements Comparable<Rectangle>{
        //Declaring attricutes.
        private double width;
        private double length;
        //Constructors for blank slates or for input from main.
        public Rectangle (){
        length = 0;
        width = 0;
    }
        public Rectangle (double l, double w){
            length = l;
            width = w;
        }
        //Methods to either individually set attributes or to return their value to main.
        public void setLength (double l){
            length = l;
        }
        public void setWidth (double w){
            width = w;
    }
        public double getLength (){
            return length;
        }
        public double getWidth (){
            return width;
        }
     public double perimeter (){
         return (length *2) + (width*2);
     }
     //Find the area of a rectangle.
     public double area (){
         return length * width;
     }
     //Method for printing out the radius in string format.
     public String toString(){
         return "The width is: " + width + " and the length is: " + length;
     }
     //Method to compare two different objects to find which one is the biggest.
     public int compareTo(Rectangle b){
         if (this.area() > b.area()) return 1;
         if (this.area() < b.area()) return -1;
         return 0;
     }
    }


    //Class for Feet and Inches
    public static class FeetInches implements Comparable<FeetInches>{
    //Declaring attricutes.
    private int feet;
    private int inches;
    
    //Constructors for blank slates or for input from main.
    public FeetInches()
    {
        feet = 0;
        inches = 0;
    }
    public FeetInches(int f, int i)
    { 
        feet = f + i/12;
        inches = i%12;
        
    }
    //Methods to either individually set attributes or to return their value to main.
    public void setFeet(int f){
        feet = f;
       
    }
    public void setInches(int i){
        feet = feet + i/12;
        inches = i%12;
    }
    public int getFeet(){
        return feet;
    }
    public int getInches(){
        return inches;
    }
    //Method for printing out the radius in string format.
    public String toString()
    {
        return "Feet: " + feet + "  Inches: " + inches ;      
    }
    //Method to compare two different objects to find which one is the biggest.
    public int compareTo(FeetInches b)
    {
        if (this.feet > b.feet) return 1;
        if (this.feet < b.feet) return -1;
        return 0;
    }
    }
	
	//Class for fractions.
	    public static class Fraction implements Comparable<Fraction>
    {
        //Declaring attricutes.
       private int numerator;
       private int denominator;
        //Constructors for blank slates or for input from main.
        public Fraction()
        {
            numerator = 0;
            denominator=1;
        }
         public Fraction(int n, int d)
        {  

            //Send numerator and denominator to the gcd method to find the gcd to reduce the fraction.
            if (n == 0){
             numerator = n;
             denominator = d;
            }
            else{
            int g=gcd(n,d);
            
            n = n / g;
            d= d / g;
            //Various checks to change the numerator and denominator if they are negatives.
            if (n <= -1 && d <= -1){
                n = n * -1;
                d = d * -1;
            }

            if (n >= 0 && d <= -1){
                n = n * -1;
                d = d * -1;
            }
            numerator = n;
            denominator = d;
            }

            
        }
       //Methods to either individually set attributes or to return their value to main.
        public int getNumerator() {
            return numerator;
        }

       
        public void setNumerator(int n) {
            if (n == 0){
            numerator = 0;
        }
            else{
            int d=denominator;
            int g=gcd(n,d);

            n = n / g;
            d= d / g;
            numerator = n;
            denominator = d;
        }
        }

       
        public int getDenominator() {
            return denominator;
        }

        
        public void setDenominator(int d) {
            int n=numerator;
            if (n == 0){
                denominator = d;
            }
            else{
                
            
            int g=gcd(n,d);
            n = n / g;
            d = d / g;
            numerator = n;
            denominator = d;
        }
        }
        //Method for printing out the radius in string format.        
        public String toString()
        {
            return numerator + "/" + denominator;
        }
       //Finding the greatest common denominator to be able to simplify fractions.
       private int gcd(int int1, int int2)
       {           
           int small = 0;
           
           if (int1 < int2) small = int1;
           else small = int2;
       
           while (int1 % small != 0 || int2 % small != 0)
           {         
            small--;
           }
           return small;
       }
       
       //Method to compare two different objects to find which one is the biggest.
      public int compareTo (Fraction b){
           if (((double)this.numerator / (double)this.denominator) > ((double)b.numerator / (double)b.denominator)) return 1;
           if (((double)this.numerator / (double)this.denominator) < ((double)b.numerator / (double)b.denominator)) return -1;
           return 0;
       }
    }
	
	 //Class for Circles.
    public static class Circle implements Comparable<Circle>{
    //Declaring attributes.
    private double radius;
    //Constructors for blank slates or for input from main.
    public Circle ()
    {
        radius = 0;
    }
    public Circle(double r)
    {
        radius = r;
    }
    //Methods to either individually set attributes or to return their value to main.
    public double getRadius()
    {
        return radius;
    }
    public void setRadius(double r)
    {
        radius = r;
    }
    //Method to find the area of a circle.
    public double area()
    {
        return Math.PI*radius*radius;
    }
    //Method to find the circumference of a circle.
    public double circumference()
    {
       return 2 * Math.PI*radius;  
    }
    //Method for printing out the radius in string format.
    public String toString()
    {
        return "The radius of the circle is: " + radius;
    }
    //Method to compare two different objects to find which one is the biggest.
    public int compareTo(Circle b)
    {
        if (this.area() > b.area()) return 1;
        if (this.area() < b.area()) return -1;
        return 0;
    }
}
    //Method of binary search to find a specific fraction in an arrary.
    public static int binarySearch (Fraction[] A, int high, int low, Fraction key){
        //System.out.println(high + " " + low + " " + key.toString());
        int rangeSize = (high-low) + 1;
        int mid = (low + high)/2;
        if (A[mid].compareTo(key) == 0) return mid;
        if (rangeSize == 1){
            if (A[mid] == key) return mid;
            else return -1;
        }
        if (key.compareTo(A[mid]) == -1) return binarySearch(A, mid, low, key);
        else return binarySearch(A, high, mid+1, key);
    }
    //Method of binary search to find a specific Rectangle in an arrary.r 
        public static int binarySearch (Rectangle[] A, int high, int low, Rectangle key){
        //System.out.println(high + " " + low + " " + key.toString());
        int rangeSize = (high-low) + 1;
        int mid = (low + high)/2;
        if (A[mid].compareTo(key) == 0) return mid;
        if (rangeSize == 1){
            if (A[mid] == key) return mid;
            else return -1;
        }
        if (key.compareTo(A[mid]) == -1) return binarySearch(A, mid, low, key);
        else return binarySearch(A, high, mid+1, key);
    }
        //Method of binary search to find a specific Circle in an arrary.
            public static int binarySearch (Circle[] A, int high, int low, Circle key){
        //System.out.println(high + " " + low + " " + key.toString());
        int rangeSize = (high-low) + 1;
        int mid = (low + high)/2;
        if (A[mid].compareTo(key) == 0) return mid;
        if (rangeSize == 1){
            if (A[mid] == key) return mid;
            else return -1;
        }
        if (key.compareTo(A[mid]) == -1) return binarySearch(A, mid, low, key);
        else return binarySearch(A, high, mid+1, key);
    }
            //Method of binary search to find a specific Feet/Inches in an arrary.
                public static int binarySearch (FeetInches[] A, int high, int low, FeetInches key){
        //System.out.println(high + " " + low + " " + key.toString());
        int rangeSize = (high-low) + 1;
        int mid = (low + high)/2;
        if (A[mid].compareTo(key) == 0) return mid;
        if (rangeSize == 1){
            if (A[mid] == key) return mid;
            else return -1;
        }
        if (key.compareTo(A[mid]) == -1) return binarySearch(A, mid, low, key);
        else return binarySearch(A, high, mid+1, key);
    }
	
	    public static void main(String[] args) {
	//Declaring various variables for later use.
       int numerator = 0;
       int denominator = 0;
       double radius = 0;
       int feet = 0;
       int inches = 0;
       double width = 0;
       double length = 0;   
       int count = 0;
	   
	   //Declaring what the input file is so the program knows where to grab input from.
       Scanner scnr = new Scanner(System.in);
       File f = new File("BinarySearch.in");
       Scanner fileInput = null;
       try{
           fileInput = new Scanner (f);
       }
       catch (FileNotFoundException e){
           
       }
	   //Create array of rectangles.
	   Rectangle[] RList = new Rectangle[12];
       while (count < 12){
           length = fileInput.nextDouble();
           width = fileInput.nextDouble();
           RList[count] = new Rectangle(length, width);
           count++;
       }
	   count = 0;//Reset count to 0 for next creation of arrays.
	   
	   //Create array of circles.
	   Circle[] CList = new Circle[20];
       while (count < 20){
           radius = fileInput.nextDouble();
           CList[count] = new Circle(radius);
           count++;
       }
	   count = 0;//Reset count to 0 for next creation of arrays.
		
	   //Create array of Fractions.
       Fraction[] FList = new Fraction[24];
       while (count < 24){
           numerator = fileInput.nextInt();
           denominator = fileInput.nextInt();
           FList[count] = new Fraction(numerator, denominator);
           count++;
       }
	   count = 0;//Reset count to 0 for next creation of arrays.
	   
	   //Create array of Feet/Inches pairs.
	  FeetInches[] FIList = new FeetInches[16];
       while (count < 16){
           feet = fileInput.nextInt();
           inches = fileInput.nextInt();
           FIList[count] = new FeetInches(feet, inches);
           count++;
		   }
       count = 0;//Reset count to 0.
       
       //Print out the array of rectangles
       System.out.println("Contents of the array of rectangle is: ");
       while (count < 12){
           System.out.println(RList[count].toString());
           count++;
       }
       count = 0;
       //Print out the array of circles
       System.out.println("Contents of the array of circles is: ");
       while (count < 20){
           System.out.println(CList[count].toString());
           count++;
       }
          count = 0; 
       //Print out the array of fractions
          System.out.println("Contents of the array of fractions is: ");
       while (count < 24){
           System.out.println(FList[count].toString());
           count++;
       }
           count = 0;
       //Print out the array of feet/inches
           System.out.println("Contents of the array of feet/inches is: ");
       while (count < 16){
           System.out.println(FIList[count].toString());
           count++;
       }
           count = 0;
	//Ask the user for the first rectangle they want to find and create it.
       System.out.println("Type in the length of the first rectangle you want to find: ");
       length = scnr.nextDouble();
       System.out.println("Type in the width of the first rectangle you want to find: ");
       width = scnr.nextDouble();
       Rectangle rectangle1 = new Rectangle(length, width);
       
       	//Ask the user for the second rectangle they want to find and create it.
       System.out.println("Type in the length of the second rectangle you want to find: ");
       length = scnr.nextDouble();
       System.out.println("Type in the width of the second rectangle you want to find: ");
       width = scnr.nextDouble();
       Rectangle rectangle2 = new Rectangle(length, width);
       
       	   //Ask the user for the first circle they want to find and create it.
       System.out.println("Type in the radius of the first circle you want to find: ");
       radius = scnr.nextDouble();
       Circle circle1 = new Circle(radius);
       
       	   //Ask the user for the second circle they want to find and create it.
       System.out.println("Type in the radius of the second circle you want to find: ");
       radius = scnr.nextDouble();
       Circle circle2 = new Circle(radius);
       
	   //Ask the user for the first fraction they want to find and create it.
       System.out.println("Type in numerator of the first fraction you want to find: ");
       numerator = scnr.nextInt();
       System.out.println("Type in denominator of the first fraction you want to find: ");
       denominator = scnr.nextInt();
       Fraction fraction1 = new Fraction(numerator, denominator);
	   
	   //Ask the user for the 2nd fraction they want to find and create it.
       System.out.println("Type in numerator of the second fraction you want to find: ");
       numerator = scnr.nextInt();
       System.out.println("Type in denominator of the second fraction you want to find: ");
       denominator = scnr.nextInt();
       Fraction fraction2 = new Fraction(numerator, denominator);  

            //Ask the user for thre first feet/inches they want to find and create it.
       System.out.println("Type in the feet of the first feet/inches you want to find: ");
       feet = scnr.nextInt();
       System.out.println("Type in the inches of the first feet/inches you want find: ");
       inches = scnr.nextInt();
       FeetInches feetinches1 = new FeetInches(feet, inches);
       
                   //Ask the user for thre first feet/inches they want to find and create it.
       System.out.println("Type in the feet of the second feet/inches you want to find: ");
       feet = scnr.nextInt();
       System.out.println("Type in the inches of the second feet/inches you want find: ");
       inches = scnr.nextInt();
       FeetInches feetinches2 = new FeetInches(feet, inches);
       
	   
       //Start the binary searches for the circles, fractions, rectangles, and feet/inches.
       //Also to print out the restuls (the position in the array the specific object is, or return a -1 if it was not found.
       System.out.println("The location of the first fraction is: " + binarySearch(FList, 24, 0, fraction1));
       System.out.println("The location of the second fraction is: " + binarySearch(FList, 24, 0, fraction2));
       System.out.println("The location of the first circle is: " + binarySearch(CList, 20, 0, circle1));
       System.out.println("The location of the second circle is: " + binarySearch(CList, 20, 0, circle2));
       System.out.println("The location of the first rectangle is: " + binarySearch(RList, 12, 0, rectangle1));
       System.out.println("The location of the second rectangle is: " + binarySearch(RList, 12, 0, rectangle2));
       System.out.println("The location of the first feet/inches is: " + binarySearch(FIList, 16, 0, feetinches1));
       System.out.println("The location of the second feet/inches is: " + binarySearch(FIList, 16, 0, feetinches2));
	   
	   
    
}
}
