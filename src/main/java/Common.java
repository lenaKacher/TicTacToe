// creation of class which include methods for the whole project
public class Common {

    // declaration of gameFieldArray
    static char[][] gameFieldArray;

    // initialisation of the game field array and filling the array with spaces
    void gameFieldInit() {
        gameFieldArray = new char[MainApp.GAME_FIELD_SIZE][MainApp.GAME_FIELD_SIZE];
        for (int i = 0; i < gameFieldArray.length; i++) {
            for (int j = 0; j < gameFieldArray.length; j++) {
                gameFieldArray[i][j] = MainApp.EMPTY_FIELD;
            }
        }
        // calling the method to display the game field on the console
        printMap();
    }

    // method to display the game field on the console
    void printMap() {
        System.out.print("  ");

        // separate loop for the display of the first row
        for (int i = 1; i <= MainApp.GAME_FIELD_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\n");

        // loop for the display of the rest rows
        for (int i = 0; i < MainApp.GAME_FIELD_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MainApp.GAME_FIELD_SIZE; j++) {
                System.out.print(gameFieldArray[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    // method to check whether the cell with given coordinates valid or not
    boolean isCellValid(int x, int y) {
        // check the values of coordinates
        if (x < 0 || x >= MainApp.GAME_FIELD_SIZE || y < 0 || y >= MainApp.GAME_FIELD_SIZE) {
            return false;
        }
        // check for empty cell
        if (gameFieldArray[y][x] != MainApp.EMPTY_FIELD) {
            return false;
        }
        return true;
    }
}