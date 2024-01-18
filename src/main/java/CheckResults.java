// creation of class for checking a result, which is a subclass (child) of a superclass (parent) Common
public class CheckResults extends Common {
    private boolean checkWin(char playerField) {
        int count = 0;
        // check columns
        for (int i = 0; i < gameFieldArray.length; i++) {
            for (int j = 0; j < gameFieldArray.length; j++) {
                if (gameFieldArray[i][j] == playerField) {
                    count++;
                }
                if (count == gameFieldArray.length) {
                    return true;
                }
            }
            count = 0;
        }
        // check rows
        for (int i = 0; i < gameFieldArray.length; i++) {
            for (int j = 0; j < gameFieldArray.length; j++) {
                if (gameFieldArray[j][i] == playerField) {
                    count++;
                }
                if (count == gameFieldArray.length) {
                    return true;
                }
            }
            count = 0;
        }

        //check diagonal from top to bottom
        for (int i = 0; i < gameFieldArray.length; i++) {
            for (int j = 0; j < gameFieldArray.length; j++) {
                if (i == j && gameFieldArray[i][j] == playerField) {
                    count++;
                }
            }
        }
        if (count == gameFieldArray.length) {
            return true;
        }
        count = 0;

        //check diagonal from bottom to top
        for (int i = 0; i < gameFieldArray.length; i++) {
            for (int j = 0; j < gameFieldArray.length; j++) {
                if (i + j == gameFieldArray.length - 1 && gameFieldArray[i][j] == playerField) {
                    count++;
                }
            }
        }
        if (count == MainApp.GAME_FIELD_SIZE) {
            return true;
        }

        return false;
    }

    // check for result: draw or win
    public boolean checkDraw(char playerField) {
        if (checkWin(playerField)) {
            System.out.printf("Game over. %s is a winner!", playerField);
            return true;
        } else {
            for (int i = 0; i < gameFieldArray.length; i++) {
                for (int j = 0; j < gameFieldArray.length; j++) {
                    if (gameFieldArray[i][j] == MainApp.EMPTY_FIELD) {
                        return false;
                    }
                }
            }
            System.out.print("Game over. A draw");
            return true;
        }
    }
}