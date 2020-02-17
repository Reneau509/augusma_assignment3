// Reneau Augusma
// COP 3330, Spring 2020
// Programming Assignment 3 - Problem 1 Part 2

import java.util.Scanner;
import java.security.SecureRandom;

public class CAI2
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
                displayCorrectResponse(random);
                break;
            }

            else
            {
                displayIncorrectResponse(random);
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
}
