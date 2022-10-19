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

        do {
            System.out.print("What size of field would you like? (2,4,6,8,10): ");
            fieldSize = scanner.nextInt();
            scanner.nextLine();
            play.setFieldSize(fieldSize);
            if (fieldSize % 2 != 0 && fieldSize <= 10 && fieldSize > 1){
                System.out.println("Please provide different number");
            }
        }while(fieldSize % 2 != 0);
            play.generateGame();
        while(!play.alreadyWon()){
            //Show board to user only the first time
            if(flag){
               play.showPlayingField();
                flag = false;
            }
            //get user input
            Scanner in = new Scanner(System.in);
            System.out.print("Enter position of row of first card (1-4): ");
            while (!in.hasNextInt() || Integer.parseInt(in.nextLine()) < 1)
            {
                // warning statement
                System.out.println("Enter position of row of first card (1-4): ");
                in.nextLine();
            }
            pos1 = Integer.parseInt(in.nextLine()) -1;

            System.out.print("Enter position of column of first card (1-4): ");
            while (!in.hasNextInt() || Integer.parseInt(in.nextLine()) < 1)
            {
                // warning statement
                System.out.println("Enter position of column of first card (1-4): ");
                in.nextLine();
            }
            pos2 = Integer.parseInt(in.nextLine()) -1;

            System.out.print("Enter position of row of second card (1-4): ");
            while (!in.hasNextInt() || Integer.parseInt(in.nextLine()) < 1)
            {
                // warning statement
                System.out.println("Enter position of row of second card (1-4): ");
                in.nextLine();
            }
            pos3 = Integer.parseInt(in.nextLine()) -1;

            System.out.print("Enter position of column of second card (1-4): ");
            while (!in.hasNextInt() || Integer.parseInt(in.nextLine()) < 1)
            {
                // warning statement
                System.out.println("Enter position of column of first card (1-4): ");
                in.nextLine();
            }
            pos4 = Integer.parseInt(in.nextLine()) -1;

            play.guess(pos1, pos2, pos3, pos4);
        }
        //If user wins show whole field and ask for playing Again.
        System.out.println("You have won!");
        play.showHiddenField();
        System.out.println();
        System.out.println();

        System.out.print("Do you wanna play again?: [Y/N]");
        String userDecide = scanner.nextLine();
        if(userDecide.equalsIgnoreCase("N") || userDecide.equalsIgnoreCase("No")){
            System.out.println("K thx bye!");
            playAgain = false;
        } else {
            play.setCounter(0);
            flag = true;
        }

    }
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}