package com.tasks;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by sir.viters on 20.09.2016.
 */
class HigherLower {
    private int AIchoice;

    HigherLower() {
        Random generator = new Random();
        this.AIchoice = generator.nextInt(10) + 1;
    }

    void play() {
        while(true) {
            Scanner input = new Scanner(System.in);
            int userInput = Integer.parseInt(input.nextLine());
            switch (this.checkGuess(userInput)) {
                case -1:
                    System.out.println("Your guess is too low");
                    break;
                case 1:
                    System.out.println("Your guess is too high");
                    break;
                case 0:
                    System.out.println("Gratz!");
                    return;
            }
        }

    }

    private int checkGuess(int number) {
        if (number < this.AIchoice)
            return -1;
        else if (number == this.AIchoice)
            return 0;
        else
            return 1;
    }
}
