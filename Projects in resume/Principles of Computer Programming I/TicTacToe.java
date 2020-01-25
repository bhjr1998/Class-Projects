/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Barry Hoinacki Jr.
 */
import java.util.Scanner;
public class TicTacToe {

    /**
     * This program is to play the game Tic-Tac-Toe.
     * One player will be the X symbol another will be the O symbol.
     * Goal is to get three in a row before your opponent does.
     */
    public static void main(String[] args) {
        char[][]board = createEmptyBoard();//Call the method to make the game board.
        printBoard(board);//Call the method to print out the empty game board to make sure it was made and that the players can see it.
        char player = 'X';//Setting the first player to be the character 'X'
        int count = 0;
        boolean win = false;
        do{
            int place = 0;
            place = getPlaceFromUser(board, player);//Call the method to ask the user to where they would want to put their symbol on the game board.
            putToken(board, place, player);//Call the method to place the token on the place the user selected.
            win=checkIfWon(board, player);//Call the method to check if anyplayer has won.
            if(win){//Check to see if anyone won, and if they did say they did.
                printBoard(board);
                System.out.println("You won player: " + player);
            }
            //If no one won the loop continues
            else{
                count++;//Increase count so that when the max amount of rounds has been reached, the game can reach a draw.
                }
            //swap player to the other symbol so the second player's turn is next
            if (player == 'X'){
                player = 'O';
            }
            else {
                player = 'X';          
            }
            printBoard(board);//Print the board so the users know what is the current state of the board.
        }
            while(count !=9 && win == false);
        //Do a check to see if the loop if left to see if the game is a draw, and if it is, print out it was a draw.
        if (win == false){
                System.out.println("The game is a draw!");
        }
  }
    
    //This method is to ask the user where they would want to put their peice and send it back to the main method.    
    public static int getPlaceFromUser (char[][] board, char player){
        Scanner scnr = new Scanner(System.in);
        int position = 0;
        System.out.println("Type in where you want to put your symbol at, player " + player + " (1-9):");//Ask the user to put in what space they would want to put their peice.
        //Loop to see if the place the user inputted is already occupied or if it even exists. If it is occupied, it will tell the user to type in another position. If it is not occupied, it will place the user's symbol in the spot the user has decided.
        while (true){      
        position = scnr.nextInt();
        if (position == 1){
            if (board[0][0] == ' '){
                break;
            }
        }
        if (position == 2){
            if (board[0][2] == ' '){
                break;
            }
        }
        if (position == 3){
            if (board[0][4] == ' '){
                break;
            }
        }
        if (position == 4){
            if (board[2][0] == ' '){
                break;
            }
        }
        if (position == 5){
            if (board[2][2] == ' '){
                break;
            }
        }
        if (position == 6){
            if (board[2][4] == ' '){
                break;
            }
        }
        if (position == 7){
            if (board[4][0] == ' '){
                break;
            }
        }
        if (position == 8){
            if (board[4][2] == ' '){
                break;
            }
        }
        if (position == 9){
            if (board[4][4] == ' '){
                break;
            }
        }
        System.out.println("That spot is already occupied or does not exist, try again: ");
        }

        return position;//Return what position the user has chosen.
    }
        
    
    //Method to place the symbol on the gameboard where ever the current user chose.
    public static void putToken (char[][] board, int place, char player){
        if (place == 1){
            board [0][0] = player;
        }
        if (place == 2){
            board [0][2] = player;
        }
        if (place == 3){
            board [0][4] = player;
        }
        if (place == 4){
            board [2][0] = player;
        }
        if (place == 5){
            board [2][2] = player;
        }
        if (place == 6){
            board [2][4] = player;
        }
        if (place == 7){
            board [4][0] = player;
        }
        if (place == 8){
            board [4][2] = player;
        }
        if (place == 9){
            board [4][4] = player;
        }
    }
    //Method to create an empty game board for the users to play on.
    public static char[][] createEmptyBoard(){
        char[][]board = new char[5][5];
        int i = 0;
        int j = 0;
        for (i = 0;i<5;i++){
            for(j = 0;j<5;j++){
               board[i][j] = ' ';
            }
        }
        for (i=1;i<5;i = i+2){
            for(j =0;j<5;j++){
                board[i][j] = '_';
            }
        }
        for (i=0;i<5;i++){
            for(j=1;j<5;j = j+2){
                board[i][j] = '|';
            }
        }
        return board;
    }
    //Method to prinout out the current state of the game board.
    public static void printBoard(char [][] board){
        for (int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
    //Method to check if after a user placed their symbol on the game board if they have done it in a three-in-a-row winning condition.
    public static boolean checkIfWon(char board[][], char player){
        boolean win = false;
        if ((board[0][0] == player && board[0][2] == player && board[0][4] == player)){
         win = true;   
        }
        if ((board[2][0] == player && board[2][2] == player && board[2][4] == player)){
          win = true;  
        }
        if ((board[4][0] == player && board[4][2] == player && board[4][4] == player)){
          win = true;  
        }
        if ((board[0][0] == player && board[2][0] == player && board[4][0] == player)){
          win = true;  
        }
        if ((board[0][2] == player && board[2][2] == player && board[4][2] == player)){
          win = true;  
        }
        if ((board[0][4] == player && board[2][4] == player && board[4][4] == player)){
          win = true;  
        }
        if ((board[4][0] == player && board[4][2] == player && board[4][4] == player)){
          win = true;  
        }
        if ((board[0][0] == player && board[2][2] == player && board[4][4] == player)){
          win = true;  
        }
        if ((board[0][4] == player && board[2][2] == player && board[4][0] == player)){
          win = true;  
        }
            
        return win;
    }
    
}
