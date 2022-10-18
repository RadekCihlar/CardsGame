import java.util.ArrayList;
import java.util.Arrays;

public class GuessinTools {
    public GuessinTools() {
    }
    public static int counter = 0;
    private ArrayList<Integer> listOfOptions = new ArrayList<>(Arrays.asList(1,2,3,4,1,2,3,4,5,6,7,8,5,6,7,8));
    private char[][] showUser =  {{'#', '#', '#', '#'}, {'#', '#', '#', '#'}, {'#', '#', '#', '#'}, {'#', '#', '#', '#'}};

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        GuessinTools.counter = counter;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void generateField() {

    }

    private int min = 0;
    private int max;


    // generovani karet
    public void generateRandomCard() {
        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                max = listOfOptions.size();
                int random = (int) Math.floor(Math.random() * (max - min + 1) + min);
                int temp = listOfOptions.get(random);
                System.out.print(temp);
                listOfOptions.remove(random);
            }
            System.out.println();

        }

    public void showField(){
    for (int i = 0; i < 4; i++){
        for(int j = 0; j < 4; j++){
            System.out.print(showUser[i][j] + " ");
        }
        System.out.println();
    }
}
    public void guess(int pos1, int pos2, int pos3, int pos4){
        if(guessingField[pos1][pos2] == GuessingField[pos3][pos4]){
            guessingField[pos1][pos2] == showUser[pos1][pos2];
            guessingField[pos3][pos4] == showUser[pos3][pos4];

            System.out.println("Correct!");
            counter++;
        }
        else {
            System.out.println("Incorrect!");
            counter++;
        }
    }


}
