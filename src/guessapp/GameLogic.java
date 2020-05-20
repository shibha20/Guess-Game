/*
 * limit is the range within which random value is too be calculated
 *arrli is the array of incorrect guesses
 */

package guessapp;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Shilpa
 */

public class GameLogic  {
    int limit; 
 
    
    ArrayList <Integer> arrli = new ArrayList <Integer> ();
  
    //Default Constructor for when range for random number generation is not passed
    public GameLogic(){
        limit = 10; 
    }
    
    //parameterized Constructor for when range for random number generation  passed
    public GameLogic(int limInputted){
        this.limit=  limInputted;
    }
  
    //random number generator
    public int generator(){
        Random rand = new Random();
        int randNum = rand.nextInt(limit)+1;
        return randNum; 
    }
    
    //create an array of invalid guess 
    public void arrayofGuesses(int incorrectGuess){
       arrli.add(incorrectGuess);
    }
        
        //check if the guess is invalid
    public  Boolean guessChecker(int randNum,int guess){  
        //initially the input is valid therefore guessStatus if false 
            Boolean guessStatus= false; 
            if (guess < 1 || guess >10)
            {   
                System.out.println("You must guess a number between 1 and 10!");
                guessStatus=true;       //updates guessStatus to true if guess is invalid
                
            }         
            //else check if the input is already taken 
            else {
                for (int element : arrli){
                    if (element == guess){
                        System.out.println("You already guessed that!");
                        guessStatus=true; //updates guessStatus to true if guess is invalid

                    }
                }
            }
                return guessStatus; 
    }
   
        // check if the valid guess is correct
    public Boolean guessDecider(int randNum,int guess){
        Boolean correctGuessStatus = false;  //initially the input is incorrect
        if (randNum == guess){
            arrayofGuesses(guess);
            System.out.println("You made the correct guess in " + arrli.size() + " guesses!");
            correctGuessStatus = true; //updates correctGuessStatus to true if the guess is correct
        }
        else {
            arrayofGuesses(guess);
            System.out.println("The guess is not correct."); 
        }
        return correctGuessStatus;
    }
    
  
}     
