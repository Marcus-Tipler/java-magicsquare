import java.util.Random;
import java.util.Scanner;

public class q1b_24062219 extends q1a_24062219 {
    public q1b_24062219() {
        super();
    }


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

        String[] sizeOfMatrix = execStart(); 
        int checkedSize = execVerify(sizeOfMatrix);
        int[][] execSquared = execSquare(checkedSize);
        execPrint(execSquared, checkedSize);
        int[][] shuffled = execRandom(checkedSize, execSquared); 
        // int[][] shuffled = execShift(execSquared, 1 - 1, 1 - 1, 1); 
        execPrint(shuffled, checkedSize);
    }


    // ----------------------------------------------------------------
    // Print instructions and Query user about size of array.
    // ----------------------------------------------------------------
    static String[] execStart() {
        System.out.println("Hello user! Welcome to the Magic Square Game!");
        Scanner requestSizeOfMatrix = new Scanner(System.in);
        System.out.println("Please enter an odd number for the size of the array (3, 5, 7, etc.): ");
        String sizeOfMatrix = requestSizeOfMatrix.nextLine();
        System.out.println("Matrix Size is: " + sizeOfMatrix);
        requestSizeOfMatrix.close();
        return new String[]{sizeOfMatrix};
    }


    // ----------------------------------------------------------------
    // Shifts the matrix based on Column, Row and Direction data.
    // ----------------------------------------------------------------
    static int[][] execShift(int[][] square, int row, int col, int dir) {
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
    static int[][] execRandom(int arraySize, int[][] array) {
        int[][] shuffled = null;
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


    
    // ----------------------------------------------------------------
    // Query the user about the shift they'd like to perform.
    // ----------------------------------------------------------------


    // ----------------------------------------------------------------
    // Verify the user input for the shift they'd like to perform.
    // ----------------------------------------------------------------

    
    // ----------------------------------------------------------------
    // Verify the completion of the matrix to a completed Magic Square.
    // ----------------------------------------------------------------


    // ----------------------------------------------------------------
    // Prints the end game results and text.
    // ----------------------------------------------------------------
}
