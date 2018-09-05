package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Boolean[] checked=new Boolean[1000];// boolean file for checking for repeats

    public static void main(String[] args) {
        Arrays.fill(checked,false);

        // take in the users number and checks that it fulls the parameters
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number between 0-999");
        int  userGuess = scan.nextInt(); //the placement of the guess

        while (userGuess > 999 || userGuess <= 0) { // the check for parameters
            System.out.println("Please, Just follow the rules.");
            userGuess = scan.nextInt();
        }

        // start button bellow
        randomGuess(userGuess);
    }
// takes in the users number and makes one random guess at the number
    static void randomGuess(int userNum) {
        int count = 0;
        int y = (int) ((Math.random() * 1000));
        if (!checked[y]||y==userNum) {
            //System.out.println(y);
            count++;
            if (y == userNum) {
                System.out.println("The computer guessed the number correctly in " + count + " guesses. The Number was " + y);
                return;
            }
            checked[y]=true;
            randomGuess(userNum, count);

        }
        else{
          //System.out.println("Double");
            randomGuess(userNum, count);
        }
    }
// method called to continue the count and reiterate
    static void randomGuess(int userNum, int oldCount) {
        int newCount = oldCount;
        int y = (int) ((Math.random() * 1000));
        if (!checked[y]||y==userNum) {
            //System.out.println(y);
            newCount++;
            if(y == userNum){
                System.out.println("The computer guessed the number correctly in " + newCount + " guesses. The Number was " + y);
                return;
            }
            checked[y]=true;
            randomGuess(userNum, newCount);
        }
        else{
          // System.out.println("Double");
            randomGuess(userNum, newCount);
        }
    }
}
