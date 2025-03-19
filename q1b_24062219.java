import java.util.Random;
import java.util.Scanner;

public class q1b_24062219 extends q1a_24062219 {
    public q1b_24062219() {
        super();
    }
    // Setting up a 'storage bank' for variables.
    public static int checkedSize;
    public static int[][] execSquared, shuffled;
    public static String[] sizeOfMatrix, interactReturn;
    public static boolean matrixCompleted;
    public Scanner globalScanner = new Scanner(System.in);

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
        q1b.execRandom(checkedSize, execSquared); 
        q1b.execPrint(shuffled, checkedSize);
        q1b.execExplain();
        q1b.execLoop();
    }


    // ----------------------------------------------------------------
    // Print instructions and Query user about size of array.
    // ----------------------------------------------------------------
    public String[] execStart() {
        System.out.println("Hello user! Welcome to the Magic Square Game!");
        System.out.println("Please enter an odd number for the size of the array (3, 5, 7, etc.): ");
        String[] userInput = execScanner();
        System.out.println("You've chosen a matrix of size: " + userInput[0]);
        // requestSizeOfMatrix.close();
        return userInput;
    }


    // ----------------------------------------------------------------
    // Shifts the matrix based on Column, Row and Direction data.
    // ----------------------------------------------------------------
    public int[][] execShift(int[][] square, int row, int col, int dir) {
        int[][] aCopy = (int[][])square.clone();

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
    public void execRandom(int arraySize, int[][] array) {
        shuffled = null;
        Random randInt = new Random();
        for (int i = 0; i < arraySize*arraySize; i++) {
            int row = randInt.nextInt(0, 3);
            int col = randInt.nextInt(0, 3);
            int dir = randInt.nextInt(1, 4);
            shuffled = execShift(array, row, col, dir);
        }
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
    public void execInteract() {
        interactReturn = null;
        System.out.println("TEST");
        System.out.println("ANOTHER TEST: ");
        String[] userInput = execScanner();
        System.out.println("TEST is: " + userInput[0]);
        // globalScanner.close();
        interactReturn = userInput;
    }


    // ----------------------------------------------------------------
    // Verify the user input for the shift they'd like to perform.
    // ----------------------------------------------------------------
    public void execVerifyDirection() {
        String[] test;
        int row, col, translatedDir = 0;
        String dir;
        while (true) {
            try {
                test = interactReturn[0].split(" ");
                row = Integer.parseInt(test[0]);
                col = Integer.parseInt(test[1]);
                dir = test[2];
                if (null != dir) switch (dir) {
                    case "r" -> translatedDir = 1;
                    case "d" -> translatedDir = 2;
                    case "l" -> translatedDir = 3;
                    case "u" -> translatedDir = 4;
                    default -> {
                        System.out.println("print met");
                        throw new NumberFormatException("Invalid direction");
                    }
                }
                if (row > checkedSize) {throw new NumberFormatException("Invalid");}
                if (col > checkedSize) {throw new NumberFormatException("Invalid");}
                if (row < 1) {throw new NumberFormatException("Invalid");}
                if (col < 1) {throw new NumberFormatException("Invalid");}
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid row, column and direction (e.g. 1 2 R).");
                test = null;
                execInteract();
            }
        }
        System.out.println("This is Test[0] from the execVerifDir function: " + test[0]);
        execShift(shuffled, row - 1, col - 1, translatedDir);
    }

    
    // ----------------------------------------------------------------
    // Verify the completion of the matrix to a completed Magic Square.
    // ----------------------------------------------------------------
    public void matrixCompletionTracker () {
        int diagSum1 = 0, diagSum2 = 0;

        // Checking the correctness of the diagonals
        for (int i = 0; i < checkedSize; i++)
        {
            diagSum1 += shuffled[i][i];
            diagSum2 += shuffled[i][checkedSize-1-i];
        }
        if(diagSum1!=diagSum2) {return;} 
        // returning false if the diagonals aren't correct.

        // Checking the correctness of the rows and columns.
        for (int i = 0; i < checkedSize; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < checkedSize; j++)
            {
                rowSum += shuffled[i][j];
                colSum += shuffled[j][i];
            }
            if (rowSum != colSum || colSum != diagSum1) {return;} 
            // returning false if the rows and columns aren't correct.
        }
        
        matrixCompleted = true; // returns true if the matrix is completed.
    }


    // ----------------------------------------------------------------
    // Loops the game until the matrix is completed.
    // ----------------------------------------------------------------
    public void execLoop () {
        matrixCompleted = false;
        while (!matrixCompleted) {
            execInteract();
            execVerifyDirection();
            execPrint(shuffled, checkedSize);
            matrixCompletionTracker();
        }
    }

    // ----------------------------------------------------------------
    // Prints the end game results and text.
    // ----------------------------------------------------------------
    public void execEnding() {
        globalScanner.close(); // Prevent leaks in the program.
    }


    // ----------------------------------------------------------------
    // Initiate the Scanner for the entire program.
    // ----------------------------------------------------------------
    public String[] execScanner() {
        System.out.println(">> ");
        String userSizeOfMatrix = globalScanner.nextLine();
        System.out.println("Your input was: " + userSizeOfMatrix);
        return new String[]{userSizeOfMatrix};
    }
}
