import java.util.Random;
import java.util.Scanner;

public class q1b_24062219 extends q1a_24062219 {
    public q1b_24062219() {
        super();
    }
    // Setting up a 'storage bank' for variables.
    public static String[] sizeOfMatrix;
    public static int checkedSize;
    public static int[][] execSquared;
    public static int[][] shuffled;
    public static String[] interactReturn;

    public static void main(String[] args) {
        // ----------------------------------------------------------------
        // <STEP 1> Print instructions and Query user about size of array.
        // <STEP 2> Verify user input.
        // <STEP 3> Make finished square.
        // <STEP 4> Shuffle square using 'execShift' n**2 times.
	    // <STEP 5> Prompt user with instructions and printed square.
        // <STEP 6> Start a loop that queries and performs the users
        // requested actions until the matrix is that of a magic square.
        // ----------------------------------------------------------------
        q1b_24062219 q1b = new q1b_24062219();
        sizeOfMatrix = q1b.execStart(); 
        checkedSize = q1b.execVerify(sizeOfMatrix);
        execSquared = q1b.execSquare(checkedSize);
        shuffled = q1b.execRandom(checkedSize, execSquared); 
        q1b.execPrint(shuffled, checkedSize);
        q1b.execExplain();
        interactReturn = q1b.execInteract();
        q1b.execTEST();
    }


    // ----------------------------------------------------------------
    // Print instructions and Query user about size of array.
    // ----------------------------------------------------------------
    public String[] execStart() {
        System.out.println("Hello user! Welcome to the Magic Square Game!");
        System.out.println("Please enter an odd number for the size of the array (3, 5, 7, etc.): ");
        String userSizeOfMatrix = globalScanner.nextLine();
        System.out.println("Matrix Size is: " + userSizeOfMatrix);
        // requestSizeOfMatrix.close();
        return new String[]{userSizeOfMatrix};
    }


    // ----------------------------------------------------------------
    // Shifts the matrix based on Column, Row and Direction data.
    // ----------------------------------------------------------------
    public int[][] execShift(int[][] square, int row, int col, int dir) {
        // Random randInt = new Random();
        int[][] aCopy = (int[][])square.clone();
        // int m = randInt.nextInt(i + 1);
        // int n = randInt.nextInt(j + 1);

        // Swap the elements at the current indices using a buffer.
        int n = square.length;

        switch (dir) {
            case 1 -> { // Right
                int buffer = aCopy[col][(row - 1 + n) % n];
                aCopy[col][(row - 1 + n) % n] = aCopy[col][row];
                aCopy[col][row] = buffer;
            }
            case 2 -> { // Down
                int buffer = aCopy[(col + 1 + n) % n][row];
                aCopy[(col + 1 + n) % n][row] = aCopy[col][row];
                aCopy[col][row] = buffer;
            }
            case 3 -> { // Left
                int buffer = aCopy[col][(row + 1 + n) % n];
                aCopy[col][(row + 1 + n) % n] = aCopy[col][row];
                aCopy[col][row] = buffer;
            }
            default -> { // Up
                int buffer = aCopy[(col - 1 + n) % n][row];
                aCopy[(col - 1 + n) % n][row] = aCopy[col][row];
                aCopy[col][row] = buffer;
            }
        }
        return aCopy;
    }

    
    // ----------------------------------------------------------------
    // Shuffle the matrix using RandInt and 'execShift' function.
    // ----------------------------------------------------------------
    public int[][] execRandom(int arraySize, int[][] array) {
        shuffled = null;
        Random randInt = new Random();
        for (int i = 0; i < arraySize*arraySize; i++) {
            int row = randInt.nextInt(0, 3);
            int col = randInt.nextInt(0, 3);
            int dir = randInt.nextInt(1, 4);
            shuffled = execShift(array, row, col, dir);
        }
        return shuffled;
    }


    // ----------------------------------------------------------------
    // Prompt the user with instructions and the shuffled matrix.
    // ----------------------------------------------------------------
    public void execExplain() {
        System.out.println("All you have to do is the following");
    }

    
    // ----------------------------------------------------------------
    // Query the user about the shift they'd like to perform.
    // ----------------------------------------------------------------
    public String[] execInteract() {
        System.out.println("TEST");
        System.out.println("ANOTHER TEST: ");
        String userSizeOfMatrix = globalScanner.nextLine();
        System.out.println("TEST is: " + userSizeOfMatrix);
        globalScanner.close();
        return new String[]{userSizeOfMatrix};
    }


    // ----------------------------------------------------------------
    // Verify the user input for the shift they'd like to perform.
    // ----------------------------------------------------------------

    
    // ----------------------------------------------------------------
    // Verify the completion of the matrix to a completed Magic Square.
    // ----------------------------------------------------------------


    // ----------------------------------------------------------------
    // Prints the end game results and text.
    // ----------------------------------------------------------------



    // ----------------------------------------------------------------
    // Initiate the Scanner for the entire program.
    // ----------------------------------------------------------------
    public Scanner globalScanner = new Scanner(System.in);

    public void execTEST() {
        System.out.println(checkedSize);
    }
}
