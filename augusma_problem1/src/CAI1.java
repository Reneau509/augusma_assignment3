// Reneau Augusma
// COP 3330, Spring 2020
// Programming Assignment 3 - Problem 1 Part 1

import java.util.Scanner;
import java.security.SecureRandom;

public class CAI1
{
    public static void quiz()
    {
        int num1, num2, userAnswer;
        Scanner input = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        num1 = random.nextInt(10);
        num2 = random.nextInt(10);
        askQuestion(num1, num2);

        while (true)
        {
            userAnswer = readResponse(input);

            if (isAnswerCorrect(userAnswer, num1 * num2))
            {
                displayCorrectResponse();
                break;
            }

            else
            {
                displayIncorrectResponse();
            }
        }
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

    public static void displayCorrectResponse()
    {
        System.out.println("Very good!");
    }

    public static void displayIncorrectResponse()
    {
        System.out.println("No. Please try again.");
    }
}
