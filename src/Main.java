import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GuessinTools play = new GuessinTools();
        Scanner scanner = new Scanner(System.in);
        int pos1, pos2, pos3, pos4;
        boolean flag = true;
        boolean playAgain = true;
        int fieldSize;





        while(playAgain){
            // Validate input and enter user for field size
            do {
                System.out.print("What size of field would you like? (2,4,6,8,10): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number");
                    System.out.println();
                    System.out.print("Enter again please: ");
                    scanner.nextLine();
                }
                fieldSize = scanner.nextInt();
                scanner.nextLine();
                if (fieldSize > 10 || fieldSize < 2){
                    System.out.println("You are out of bounds!");
                    System.out.println();
                }
            } while (fieldSize >= 11 || fieldSize <= 1);
            play.setFieldSize(fieldSize);
            play.generateGame();

        while(!play.alreadyWon()){
            // Generates the game!


            if(flag){
               play.showPlayingField();
                flag = false;
                playAgain = false;
            }
            System.out.println();
            play.showHiddenField();

            //get user input
            System.out.println();
            System.out.println("Enter positive number coordinates of card A (1-" + fieldSize + "), (1-" + fieldSize + "): ");
            System.out.println();

            do {
                System.out.print("Please enter a Row: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number!");
                    System.out.println();
                    System.out.print("Enter row again: ");
                    scanner.nextLine();
                }
                pos1 = scanner.nextInt() - 1;
            } while (pos1 < -0);

            do {
                System.out.print("Please enter a column: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number!");
                    System.out.println();
                    System.out.print("Enter column again: ");
                    scanner.nextLine();
                }
                pos2 = scanner.nextInt() - 1;
            } while (pos2 < -0);

            System.out.println();
            System.out.println("Enter positive number coordinates of card B (1-" + fieldSize + "), (1-" + fieldSize + "): ");
            System.out.println();

            do {
                System.out.print("Please enter a Row: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number!");
                    System.out.println();
                    System.out.print("Enter row again: ");
                    scanner.nextLine();
                }
                pos3 = scanner.nextInt() - 1;
            } while (pos3 < -0);

            do {
                System.out.print("Please enter a column: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number!");
                    System.out.println();
                    System.out.print("Enter column again: ");
                    scanner.nextLine();
                }
                pos4 = scanner.nextInt() - 1;
            } while (pos4 < -0);

            play.guess(pos1, pos2, pos3, pos4);
        }

            System.out.println("You have won!");
            System.out.println();

            play.showFilledField();

            System.out.println();

            System.out.print("Do you wanna play again? [Y/N]: ");
            String userDecide = scanner.next();

        if(userDecide.equalsIgnoreCase("N") || userDecide.equalsIgnoreCase("No")){
            System.out.println();
            System.out.println("K thx bye!");
            break;
        } else {
            play.setCounter(0);
            playAgain = true;
            flag = true;
        }
        }
        System.out.println();
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}