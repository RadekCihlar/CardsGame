import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class GuessinTools {
    private static int counter = 0;
    private int fieldSize;
    private ArrayList<Character> listOfOptions = new ArrayList<>();
    private char[][] showUser;
    private char[][] guessingField;


    // Ukazuje herní pole, které je skryté a hráč vidí
    public void showPlayingField(){
        for (int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++){
                System.out.print(showUser[i][j] + " ");
            }
            System.out.println();
        }
    }
    // Ukazuje skryté herní pole, které hráč ne
    public void showHiddenField(){
        for (int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++){
                System.out.print(guessingField[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Logika hádání
    public void guess(int pos1, int pos2, int pos3, int pos4) throws InterruptedException {

        if(guessingField[pos1][pos2] != '#' && guessingField[pos3][pos4] != '#'){
            if((pos1 < fieldSize) && (pos2 < fieldSize) && (pos3 < fieldSize) && (pos4 < fieldSize)) {
                if ((pos1 == pos3 && pos2 == pos4)) {
                System.out.println("Enter different card coordinates!");
                System.out.println();

                showPlayingField();
            } else if (guessingField[pos1][pos2] == guessingField[pos3][pos4]) {
                showUser[pos1][pos2] = guessingField[pos1][pos2];
                showUser[pos3][pos4] = guessingField[pos3][pos4];
                guessingField[pos3][pos4] = '#';
                guessingField[pos1][pos2] = '#';

                System.out.println("Correct!");
                counter++;

                showPlayingField();
            } else {
                System.out.println("Inccorect!");
                System.out.println();
                showUser[pos1][pos2] = guessingField[pos1][pos2];
                showUser[pos3][pos4] = guessingField[pos3][pos4];
                showPlayingField();
                TimeUnit.SECONDS.sleep(5);
                System.out.println();
                showUser[pos1][pos2] = '#';
                showUser[pos3][pos4] = '#';
                showPlayingField();
            }
        } else {
            System.out.println("Enter valid numbers!");
        }
    }
        else {
            System.out.println("You have already guessed this combination!");
        }
}

    // Logika zda user Vyhrál
    public boolean alreadyWon(){
        if (fieldSize == 2){
            return counter == 1;
        }else {
            return counter == (fieldSize*2) - 1;
        }

    }
    public static void showTempField(){
    }
    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        GuessinTools.counter = counter;
    }
    // Generate list of possible combinations!
    public void generateListOfOptions(){
        for (int j = 0; j < 2; j++){
            for (int i = 1; i <= (fieldSize*fieldSize) / 2; i++){
                char x = (char)(i+'0');
                listOfOptions.add(x);
            }
        }
    }
    //Generate field that we show!
    public void generateShowUser(){
        char[][] showUser = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++){
                showUser[i][j] = '#';
            }
        }
        setShowUser(showUser);
    }
    // Generate playing field
    public void generateHiddenField(){
        char[][] guessingField = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++){
                int random = (int) Math.floor(Math.random() * listOfOptions.size());
                guessingField[i][j] = listOfOptions.get(random);
                listOfOptions.remove(random);
            }
        }
        setGuessingField(guessingField);
    }
    //
    // Generate game
    public void generateGame(){
        generateListOfOptions();
        generateShowUser();
        generateHiddenField();
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public ArrayList<Character> getListOfOptions() {
        return listOfOptions;
    }

    public void setListOfOptions(ArrayList<Character> listOfOptions) {
        this.listOfOptions = listOfOptions;
    }

    public char[][] getShowUser() {
        return showUser;
    }

    public void setShowUser(char[][] showUser) {
        this.showUser = showUser;
    }

    public char[][] getGuessingField() {
        return guessingField;
    }

    public void setGuessingField(char[][] guessingField) {
        this.guessingField = guessingField;
    }
}

