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
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_ORANGE = "\033[38;5;208m";
    public static final String ANSI_GREY = "\033[38;5;244m";

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
        q1b.execLoop();
    }


    // ----------------------------------------------------------------
    // Print instructions and Query user about size of array.
    // ----------------------------------------------------------------
    public String[] execStart() {
        System.out.println("[" + ANSI_CYAN + "WELCOME" + ANSI_RESET + "]" + ANSI_GREEN + "\nHello {user}! Welcome to the TEMPLE OF NOD!" + ANSI_RESET + "\n");
        System.out.println("[" + ANSI_CYAN + "STORY" + ANSI_RESET + "]" + "\n*you walk up to the temple entrance, and discover their " + ANSI_ORANGE + "front door is locked" + ANSI_RESET + ". \nWhat a shame!\n" + "There does however seem to be hope! The door seems to be " + ANSI_ORANGE + "locked with a puzzle" + ANSI_RESET + ".\nComplete the puzzle and defeat the EMPIRE OF NOD!" + "\n");
        System.out.println("[" + ANSI_CYAN + "INSTRUCTIONS" + ANSI_RESET + "]" + "\nThe puzzle located at the front entrance is a Magic Square. " + ANSI_ORANGE + "\nComplete the matrix to unlock the temple" + "." + ANSI_RESET + "\n");
        System.out.println("[" + ANSI_CYAN + "HOW TO" + ANSI_RESET + "]" + "\nTo complete the puzzle, make sure all rows, columns and diagonals are equal to the same value. \nTo swap a value, type the following: {row number} {column number} {direction}\nYou can only switch one value at a time." + ANSI_RESET + "\n");
        System.out.println(ANSI_GREEN + "GOOD LUCK!" + ANSI_RESET + "\n");
        System.out.print(ANSI_GREY + "Please enter an array size " + ANSI_RESET + ">> " + ANSI_GREY);
        String[] userInput = execScanner();
        System.out.println("\n[" + ANSI_CYAN + "STORY" + ANSI_RESET + "]" + "\nyou walk up to the puzzle towards the main entrance, it displays the following." + "\n");
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
    // Query the user about the shift they'd like to perform.
    // ----------------------------------------------------------------
    public void execInteract() {
        interactReturn = null;
        System.out.println("\n[" + ANSI_CYAN + "USAGE" + ANSI_RESET + "]" + "\nenter: {row number} {column number} {direction}\nexample: 1 1 up" + ANSI_RESET + "\n");
        System.out.print(ANSI_RESET + ">> " + ANSI_GREY);
        interactReturn = execScanner();
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
        System.out.println("");
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
    // Prints the end game results closes the program properly.
    // ----------------------------------------------------------------
    public void execEnding() {
        globalScanner.close(); // Prevent leaks in the program.
    }


    // ----------------------------------------------------------------
    // Initiate the Scanner for the entire program.
    // ----------------------------------------------------------------
    public String[] execScanner() {
        String userSizeOfMatrix = globalScanner.nextLine();
        System.out.println(ANSI_RESET + ">> " + ANSI_GREY + "You entered: " + userSizeOfMatrix + ANSI_RESET);
        return new String[]{userSizeOfMatrix};
    }
}
