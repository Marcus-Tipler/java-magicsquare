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
        int[][] execSquared = execSquare(checkedSize); //FIXME: Whilst value is negative, loop and ask again.
        // execPrint(execSquared, checkedSize);

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
    static int[][] execShift(int[][] square, int i, int j, String d) {
        
    }

    
    // ----------------------------------------------------------------
    // Shuffle the matrix using RandInt and 'execShift' function.
    // ----------------------------------------------------------------


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
