// creation of a main class of the project, where we run our game
public class MainApp {
    // declaration and initialisation of constants
    public static final int GAME_FIELD_SIZE = 3;
    public static final char EMPTY_FIELD = ' ';
    public static final char X_FIELD = 'X';
    public static final char O_FIELD = '0';
    public static void main(String[] args) {

        // creation of objects of classes CheckResults, Moves and Common
        CheckResults checkResults = new CheckResults();
        Common common = new Common();
        Moves moves = new Moves();

        // calling public method gameFieldInit of the class Common
        common.gameFieldInit();

        // doing this loop until getting draw or win for X-Player or 0-Player
        while (true) {
            moves.humanMove(); // a move of X-Player
            common.printMap(); // displaying the game field on the console
            if (checkResults.checkDraw(MainApp.X_FIELD)) { // checking results after move of X-Player
                break;
            }

            moves.compMove(); // a move of 0-Player
            common.printMap(); // // displaying the game field on the console
            if (checkResults.checkDraw(MainApp.O_FIELD)) { // checking results after move of 0-Player
                break;
            }
        }
    }
}
