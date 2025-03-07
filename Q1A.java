
public class Q1A {
    static void execSquare(int n) {
        int[][] square = new int[n][n];

        int x = 1;
        int y = ((n+1)/2);
        square[x][y] = 1;

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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (square[i][j] < 10)  System.out.print(" ");  // for alignment
                if (square[i][j] < 100) System.out.print(" ");  // for alignment
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        if (args.length > 0) {
            int n = Integer.parseInt(args[0]);
            if (n % 2 == 0) throw new RuntimeException("n must be odd");

            execSquare(n);
        }
        else
            System.out.println("Usage: java Q1A.java [odd number]");
    }
}