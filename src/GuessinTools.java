import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class GuessinTools {
    private static int counter = 0;
    private int fieldSize;
    private char[][] showUser;
    private char[][] guessingField;
    private char[][] filledField;


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
    public void showFilledField(){
        for (int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++){
                System.out.print(filledField[i][j] + " ");
            }
            System.out.println();
        }
    }



    public void copyFilledField(){
        char[][] filledField = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++){
                filledField[i][j] = guessingField[i][j];
            }
        }
        setFilledField(filledField);
    }

    // Logika hádání
    public void guess(int pos1, int pos2, int pos3, int pos4) throws InterruptedException {

        if((pos1 < fieldSize) && (pos2 < fieldSize) && (pos3 < fieldSize) && (pos4 < fieldSize)) {
            if(guessingField[pos1][pos2] != '#' && guessingField[pos3][pos4] != '#'){
                if ((pos1 == pos3 && pos2 == pos4)) {

                    System.out.println();
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

                    System.out.println();
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
                }

            } else {
            System.out.println();
            System.out.println("You have already guessed this combination!");
            showPlayingField();
            }
        }
        else {
            System.out.println();
            System.out.println("Enter valid numbers!");
            showPlayingField();
        }
    }

    // Logika zda user Vyhrál
    public boolean alreadyWon(){
        if (fieldSize == 2){
            return counter == 1;
        }else {
            return counter == ((fieldSize*fieldSize)/2) - 1;
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
        ArrayList<Character> listOfOptions = new ArrayList<>(Arrays.asList('A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J', 'J', 'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O', 'P', 'P', 'Q', 'Q', 'R', 'R', 'S', 'S', 'T', 'T', 'V', 'V', 'U', 'U', 'W', 'W', 'X', 'X', 'Y', 'Y', 'Z', 'Z','A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J', 'J', 'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O', 'P', 'P', 'Q', 'Q', 'R', 'R', 'S', 'S', 'T', 'T', 'V', 'V', 'U', 'U', 'W', 'W', 'X', 'X'));

        char[][] guessingField = new char[fieldSize][fieldSize];

        if (fieldSize == 10){
            for (int i = 0; i < fieldSize; i++){
                for(int j = 0; j < fieldSize; j++){
                    int random = (int) Math.floor(Math.random() * listOfOptions.size());
                    guessingField[i][j] = listOfOptions.get(random);
                    listOfOptions.remove(random);
        }
            }
        }else if(fieldSize == 8){
            listOfOptions.subList(64, listOfOptions.size()).clear();
                    for (int i = 0; i < fieldSize; i++){
                        for(int j = 0; j < fieldSize; j++){
                            int random = (int) Math.floor(Math.random() * listOfOptions.size());
                            guessingField[i][j] = listOfOptions.get(random);
                            listOfOptions.remove(random);
                        }
                    }
                } else if (fieldSize == 6) {
                    listOfOptions.subList(36, listOfOptions.size()).clear();
                    for (int i = 0; i < fieldSize; i++){
                        for(int j = 0; j < fieldSize; j++){
                            int random = (int) Math.floor(Math.random() * listOfOptions.size());
                            guessingField[i][j] = listOfOptions.get(random);
                            listOfOptions.remove(random);
                        }
                    }
                }else if (fieldSize == 4) {
                    listOfOptions.subList(16, listOfOptions.size()).clear();
                    for (int i = 0; i < fieldSize; i++){
                        for(int j = 0; j < fieldSize; j++){
                            int random = (int) Math.floor(Math.random() * listOfOptions.size());
                            guessingField[i][j] = listOfOptions.get(random);
                            listOfOptions.remove(random);
                        }
                    }
        } else{
            listOfOptions.subList(4, listOfOptions.size()).clear();
            for (int i = 0; i < fieldSize; i++){
                for(int j = 0; j < fieldSize; j++){
                    int random = (int) Math.floor(Math.random() * listOfOptions.size());
                    guessingField[i][j] = listOfOptions.get(random);
                    listOfOptions.remove(random);
        }
            }
        }

        setGuessingField(guessingField);
    }

    // Generate game
    public void generateGame(){
        generateShowUser();
        generateHiddenField();
        copyFilledField();
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
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
    public char[][] getFilledField() {
        return filledField;
    }

    public void setFilledField(char[][] filledField) {
        this.filledField = filledField;
    }
}