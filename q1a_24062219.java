
public class q1a_24062219 {
    // ----------------------------------------------------------------
    // Executes the square matrix creation and printing process
    // ----------------------------------------------------------------
    static int[][] execSquare(int n) {
        int[][] square = new int[n][n];

        // Set the default values and initial value of the array
        int x = 1;
        int y = ((n+1)/2);
        square[x][y] = 1;

        // Fill the rest of the array with values based on the spiral pattern
        for (int i = 2; i <= n*n; i++) {
            int nx = ((x-1)+n) % n;
            int ny = ((y-1)+n) % n;
            if (square[nx][ny] == 0) {
                x = nx;
                y = ny;
            }
            else {
                x = (x+1)%n; 
            }
            square[x][y] = i;
        }
        return square;
    }

    // ----------------------------------------------------------------
    // Executes the printing process of the square matrix
    // ----------------------------------------------------------------
    static void execPrint(int[][] execSquared, int n) {
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
    static int execVerify(String[] args) {
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
        int n = execVerify(args);
        int[][] execSquared = execSquare(n);
        execPrint(execSquared, n);
    }
    
}