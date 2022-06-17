

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    public void play() {
        //start game
        printGameRules();
        String choice = input.nextLine().toLowerCase();

        //initialize variables
        ScoreBoard scoreBoard = new ScoreBoard();
        while (!choice.equals("quit")) //do the following if the user does not put in "quit"
        {
            int choicenum = getChoiceNum(choice);
            if(choicenum == 0) {
                while(choicenum == 0) //continue while user input is still not valid
                {
                    System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
                    choice = input.nextLine().toLowerCase();
                    choicenum = getChoiceNum(choice);

                }
            }

            int compnum = getChoiseComputer();


            completeGamePlay(scoreBoard, choicenum, compnum);
            printResults(scoreBoard);
            choice = input.nextLine().toLowerCase(); //prompt for new user input
        }

    }

    private void printResults(ScoreBoard scoreBoard) {
        System.out.println("wins:" + scoreBoard.getWins() + "\nloses:" + scoreBoard.getLosses() + "\nties:" + scoreBoard.getTie()); //print out number of wins, ties, and loses
        System.out.println("Let's play again! \n \n"); //start game again
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private void completeGamePlay(ScoreBoard scoreBoard, int choicenum, int compnum) {
        if(choicenum == compnum) //tie cases
        {
            System.out.println("It's a tie");
            scoreBoard.incrementTie();
        } else if (choicenum == 1 && compnum == 3)
        {
            System.out.println("you win!");
            scoreBoard.incrementWins();
        } else if (choicenum == 3 && compnum == 2)
        {
            System.out.println("you win!");
            scoreBoard.incrementWins();
        } else if (choicenum == 2 && compnum ==1)
        {
            System.out.println("you win!");
            scoreBoard.incrementWins();
        } else {
            System.out.println("you lose.");
            scoreBoard.incrementLosses();
        }
    }

    private int getChoiceNum(String choice){
       int choicenum = 0;
        if (choice.equals("rock"))
        {
            choicenum = 1;
        }
        else if (choice.equals("paper"))
        {
            choicenum = 2;
        }
        else if (choice.equals("scissors"))
        {
            choicenum = 3;
        } else if (choice.equals("quit")) {
            System.exit(0); //quit program
        }
        return choicenum;
    }

    private int getChoiseComputer() {
        int compnum = (int) (random.nextInt(3)) + 1;
        if (compnum == 1) System.out.println("Computer chose rock");
        if (compnum == 2) System.out.println("Computer chose paper");
        if (compnum == 3) System.out.println("Computer chose scissors");

        return compnum;
    }

    private void printGameRules() {
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }
}
