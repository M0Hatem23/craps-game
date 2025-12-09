import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Random;

public class Main
{
    private static SecureRandom secureRandom = new SecureRandom();

    private enum Status {CONTINUE,  WON, LOST}

    private static int rollDice ()
    {
        int first = 1 + secureRandom.nextInt(6);
        int second = 1 + secureRandom.nextInt(6);

        System.out.printf("Player rolled %d + %d = %d%n", first, second, first+second);
        return first + second;
    }

    public static void main(String[] args)
    {
        int sumOfDice = rollDice();
        Status gameStatus;
        int myPoint = 0;
        switch (sumOfDice)
        {
            case 7, 11:
                gameStatus = Status.WON;
            break;

            case 2, 3, 12:
                gameStatus = Status.LOST;
            break;

            default:
                gameStatus = Status.CONTINUE;
                myPoint = sumOfDice;
                System.out.printf("Points is %d%n", myPoint);
            break;
        }

        while (gameStatus == Status.CONTINUE)
        {
            sumOfDice = rollDice();

            if (sumOfDice == myPoint)
                gameStatus = Status.WON;
            else if (sumOfDice == 7)
                gameStatus = Status.LOST;
        }

        if (gameStatus == Status.WON)
            System.out.println("Player wins");
        else
            System.out.println("Player loses");
    }
}