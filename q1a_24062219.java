
public class q1a_24062219 {


    // ----------------------------------------------------------------
    // Executes the square matrix creation and printing process
    // ----------------------------------------------------------------
    public static int[][] execSquare(int n) {
        int[][] square = new int[n][n];

        // Set the default values and initial value of the array
        int x = 0;
        int y = n / 2;
        square[x][y] = 1;

        // Fill the rest of the array with values based on the spiral pattern
        for (int i = 2; i <= n*n; i++) {
            int nx = ( x - 1 + n) % n;
            int ny = (y+1) % n;
            if (square[nx][ny] != 0) {
                nx = (x+1) % n;
                ny = y;
            }
            square[nx][ny] = i;
            y = ny;
            x = nx;
        }
        return square;
    }


    // ----------------------------------------------------------------
    // Executes the printing process of the square matrix
    // ----------------------------------------------------------------
    public static void execPrint(int[][] execSquared, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Aligns the columns properly
                if (execSquared[i][j] < 10)  System.out.print(" ");
                if (execSquared[i][j] < 100) System.out.print(" "); 
                System.out.print(execSquared[i][j] + " ");
            }
            System.out.println();
        }
    }


    // ----------------------------------------------------------------
    // Executes a verification and error checking on user input
    // ----------------------------------------------------------------
    public static int execVerify(String[] args) {
        if (args.length > 0) {
            int n = Integer.parseInt(args[0]);
            if (n % 2 == 0) throw new RuntimeException("\nThe entered value must be an odd number, please type the command and try again.\nUsage: java q1a_24062219 [odd number]");

            return n;
        }
        else
            throw new RuntimeException("\nUsage: java q1a_24062219 [odd number]");
    }
    

    // ----------------------------------------------------------------
    // Main method to execute the program
    // ----------------------------------------------------------------
    public static void main(String[] args) {
        int verified = execVerify(args);
        int[][] execSquared = execSquare(verified);
        execPrint(execSquared, verified);
    }
}