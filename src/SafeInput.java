import java.util.Scanner;

public class SafeInput {
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean playAgain = false;
        boolean valid = false;
        String retString = "";

        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();

            if (retString.equalsIgnoreCase("y")){
                playAgain = true;
                valid = true;
            } else if (retString.equalsIgnoreCase("n")) {
                valid = true;
            }
            else {
                System.out.println("Please enter y or n");
            }
        }
        while (!valid);
        return playAgain;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = 0;
        boolean valid = false;
        String trash = "";

        do {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine();
                if (retInt >= low && retInt <= high) {
                    valid = true;
                } else {
                    System.out.println("Input is out of range enter a number between " + low + " and " + high);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("\n" + trash + " is not a valid whole number try again");
            }
        }
        while (!valid);
        return retInt;
    }
}
