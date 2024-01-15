import java.util.Scanner;

// creation of class Moves for describing moves of players, which is a subclass (child) of a superclass (parent) Common
public class Moves extends Common {

    // creation of objects of class Scanner
    Scanner scanner;

    // method for realisation of a computer's move (0-Player)
        public void compMove() {
            int x, y;
            System.out.println("Now it's computer's move: ");

            // creation of coordinates for computer's move by generation of random numbers...
            do {
                x = (int) (Math.random() * MainApp.GAME_FIELD_SIZE);
                y = (int) (Math.random() * MainApp.GAME_FIELD_SIZE);

            // ...until valid values are generated
            } while (!isCellValid(x, y));

            // and then assign this value to the corresponding cell of array
            gameFieldArray[y][x] = MainApp.O_FIELD;
        }

    // method for realisation of a human's move (X-Player)
        public void humanMove() {
            scanner = new Scanner(System.in);
            int x, y;

            // input of coordinates for human's move...
            do {
                System.out.printf("Now it's a human's move. Input coordinates X Y (from 1 to %d): ", MainApp.GAME_FIELD_SIZE);
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;

            // ...until valid values are inputted
            } while (!isCellValid(x, y));

            // and then assign this value to the corresponding cell of array
            gameFieldArray[y][x] = MainApp.X_FIELD;
        }
    }
