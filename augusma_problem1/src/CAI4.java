// Reneau Augusma
// COP 3330, Spring 2020
// Programming Assignment 3 - Problem 1 Part 4

import java.util.Scanner;
import java.security.SecureRandom;

public class CAI4
{
    public static void quiz()
    {
        int i, count = 0, difficulty, num1, num2, userAnswer;
        String choice;
        Scanner input = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        while (true)
        {
            System.out.println("Enter a difficulty level (1 - 4): ");
            difficulty = readDifficulty(input);
            System.out.println("Please solve the following 10 problems.");

            for (i = 0; i < 10; i++)
            {
                num1 = generateQuestionArgument(random, difficulty);
                num2 = generateQuestionArgument(random, difficulty);
                askQuestion(num1, num2);

                userAnswer = readResponse(input);

                if (isAnswerCorrect(userAnswer, num1 * num2))
                {
                    displayCorrectResponse(random);
                    count++;
                }

                else
                {
                    displayIncorrectResponse(random);
                }
            }

            displayCompletionMessage(count);
            count = 0;
            System.out.println("Would you like to solve a new problem set? (yes or no)");
            choice = input.next();

            if (choice.equals("no"))
                break;
        }
    }

    public static int readDifficulty(Scanner input)
    {
        return input.nextInt();
    }

    public static int generateQuestionArgument(SecureRandom random, int difficulty)
    {
        int number = 0;

        switch (difficulty)
        {
            case 1:
                number = random.nextInt(10);
                break;

            case 2:
                number = random.nextInt(100);
                break;

            case 3:
                number = random.nextInt(1000);
                break;

            case 4:
                number = random.nextInt(10000);
                break;

            default:
                break;
        }

        return number;
    }

    public static void askQuestion(int number1, int number2)
    {
        System.out.println("How much is " + number1 + " times " + number2 + "?");
    }

    public static int readResponse(Scanner input)
    {
        return input.nextInt();
    }

    public static boolean isAnswerCorrect(int userAnswer, int correctAnswer)
    {
        return userAnswer == correctAnswer;
    }

    public static void displayCorrectResponse(SecureRandom random)
    {
        int index = random.nextInt(5) + 1;

        switch(index)
        {
            case 1:
                System.out.println("Very good!");
                break;

            case 2:
                System.out.println("Excellent!");
                break;

            case 3:
                System.out.println("Nice work!");
                break;

            case 4:
                System.out.println("Keep up the good work!");
                break;

            default:
                break;
        }
    }

    public static void displayIncorrectResponse(SecureRandom random)
    {
        int index = random.nextInt(5) + 1;

        switch(index)
        {
            case 1:
                System.out.println("No. Please try again.");
                break;

            case 2:
                System.out.println("Wrong, Try once more.");
                break;

            case 3:
                System.out.println("Don't give up!");
                break;

            case 4:
                System.out.println("No. Keep trying.");
                break;

            default:
                break;
        }
    }

    public static void displayCompletionMessage(int correct)
    {
        int percentage = correct * 10;
        System.out.println("Your score: " + percentage + "%");

        if (percentage < 75)
            System.out.println("Please ask your teacher for extra help.");

        else
            System.out.println("Congratulations, you are ready to go to the next level!");
    }
}
