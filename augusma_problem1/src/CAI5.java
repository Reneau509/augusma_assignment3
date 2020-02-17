// Reneau Augusma
// COP 3330, Spring 2020
// Programming Assignment 3 - Problem 1 Part 5

import java.util.Scanner;
import java.security.SecureRandom;

public class CAI5
{
    public static void quiz()
    {
        int i, count = 0, difficulty, num1, num2, problemType, userAnswer, correctAnswer;
        String choice;
        Scanner input = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        while (true)
        {
            System.out.println("Enter a difficulty level of 1, 2, 3, or 4: ");
            difficulty = readDifficulty(input);
            System.out.println("Enter a problem type of 1, 2, 3, 4, or 5: ");
            problemType = readProblemType(input);
            System.out.println("Please solve the following 10 problems.");

            for (i = 0; i < 10; i++)
            {
                num1 = generateQuestionArgument(random, difficulty);
                num2 = generateQuestionArgument(random, difficulty);
                correctAnswer = askQuestion(random, problemType, num1, num2);

                userAnswer = readResponse(input);

                if (isAnswerCorrect(userAnswer, correctAnswer))
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
            System.out.println("Would you like to solve a new problem set? (enter yes or no)");
            choice = input.next();

            if (!choice.equals("yes"))
                break;
        }
    }

    public static int readDifficulty(Scanner input)
    {
        return input.nextInt();
    }

    public static int readProblemType(Scanner input)
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

    public static int askQuestion(SecureRandom random, int problemType, int number1, int number2)
    {
        int result = 0;

        switch (problemType)
        {
            case 1:
                System.out.println("How much is " + number1 + " plus " + number2 + "?");
                result = number1 + number2;
                break;

            case 2:
                System.out.println("How much is " + number1 + " times " + number2 + "?");
                result = number1 * number2;
                break;

            case 3:
                System.out.println("How much is " + number1 + " minus " + number2 + "?");
                result = number1 - number2;
                break;

            case 4:
                System.out.println("How much is " + number1 + " divided by " + number2 + "?");
                result = number1 / number2;
                break;

            case 5:
                result = askQuestion(random,random.nextInt(4) + 1, number1, number2);
                break;
        }

        return result;
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

    public static void main(String[] args)
    {
        quiz();
    }
}
