import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GuessinTools play = new GuessinTools();
        Scanner scanner = new Scanner(System.in);
        int pos1, pos2, pos3, pos4;
        boolean flag = true;
        boolean playAgain = true;

    while(playAgain){
        while(!play.alreadyWon()){
            //Show board to user only the first time
            if(flag){
                play.showPlayingField();
                flag = false;
            }
            //get user input
            System.out.print("Enter coordinates od card A (1-4), (1-4): ");
            pos1 = scanner.nextInt() - 1;
            scanner.nextLine();
            pos2 = scanner.nextInt() - 1;
            scanner.nextLine();
            System.out.print("Enter coordinates od card B (1-4), (1-4): ");
            pos3 = scanner.nextInt() - 1;
            scanner.nextLine();
            pos4 = scanner.nextInt() - 1;
            scanner.nextLine();
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