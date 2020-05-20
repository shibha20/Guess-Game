package guessapp;
import java.util.Scanner;

/**
 *
 * @author Shilpa
 * 
 * This program randomly generates a number between 1 and 10 with flexibility to increase that range if wished. It lets the player guess the randomly generated input.
 * A player can input numbers from 1 to 10.All other inputs in any data type are considered invalid. 
 * Also, a valid guess is the one between 1 and 10, and one that has not been already guessed. 
 * The program notifies the user when a  correct guess is made with total number of valid guesses made to find the correct number.
 * 
 */

public class GuessApp {

    public static void main(String[] args) {
  
        
        System.out.println("*****Welcome To The Guessing Game*****");
        System.out.println("");
        
        //producing gameLogic object which generates random integet from 1 to 10
        //can be passed a parameter (an int) to change range of 1 to 10. 
        GameLogic G1= new GameLogic();
        
        //generate random number from gameLogic
        int randNum = G1.generator();
       
        //takes valid inputs and checks them for correctness
        loopInputForCorrectednness(randNum,G1); 
    }
    
    //input the guess
    public static int guessTaker(){
        Scanner sc = new Scanner(System.in);
        int guess =0;
        System.out.println("Enter a guess between 1 and 10:"); 
        
        //check if the input is integer 
        if(sc.hasNextInt()) {
            int finalguess = sc.nextInt();
            guess =finalguess;
        }
        
        return guess; //return 0 if the input is not string (this will be later declared invalid by guessChecker method in GameLogic
    }
   
    //Inputing  from user until the program finds a valid guess
    public static int loopInputForValidity(int randNum,GameLogic G1){
        Boolean invalidityStatus = false; //initially the input is valid (non invalid) 
        int validGuess;
            do {
                int guess = guessTaker(); //input from user
                invalidityStatus = G1.guessChecker(randNum, guess);   //sets the invalidity status
                validGuess = guess; 
            }while (invalidityStatus != false);     //loop to get another input when previous input is found to be invalid (i.e when invalidityStatus= true)
            //stop the loop when invalidityStatus is false i.e. the input is not invalid. 
         return validGuess;
    }
    
    
    //Input a valid guess from user and decide on them until the program finds a correct guess
     public static void loopInputForCorrectednness(int randNum,GameLogic G1){
        Boolean correctedness= true; //inititally the input status is correct 
            do {
                //loop to get a valid input
                int inputToCheck = loopInputForValidity (randNum, G1);    
                //check if the input was correct
                correctedness = G1.guessDecider(randNum, inputToCheck); 
                //loop to get a valid input again if an incorrect guess was inputted 
            }while (correctedness != true);         //stop the loop when there is a correct input
    }
}
