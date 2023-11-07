
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playagain = true;
        int totalrounds = 0;
        int totalattempts = 0;

        while (playagain){
            totalrounds++;
            int attempts = 0;
            int numberofguess = random.nextInt(100) +1;

            System.out.println("\nRound " + totalrounds  + " Guess the number between 1 and 100");

            while (true){
                System.out.println("Enter your guess: ");
                try {
                    int userguess = scanner.nextInt();
                    attempts++;

                    if (userguess < numberofguess){
                        System.out.println("Too low!!!.Try a higher number.");
                    }else if(userguess > numberofguess){
                        System.out.println("Too high!!!.Try a lower number.");
                    }else {
                        System.out.println("Congratulations!!!.You guessed the number "+ numberofguess+ " correctly in "+ attempts+" attempts.");
                        totalattempts += attempts;
                        break;
                    }
                }catch (java.util.InputMismatchException e){
                    System.out.println("Please enter the valid number.");
                    scanner.next();
                }
            }
            System.out.print("Do you want to play again?? (Yes/No)");
            String play = scanner.next().toLowerCase();
            if (!play.equals("yes")){
                playagain = false;
            }
        }
        System.out.print("\nTotal Rounds: " +totalrounds + " | Total attempts: "+totalattempts+ " | Average Attempts per Round: " +(double) totalattempts/totalrounds);
        scanner.close();
    }
}
