
public class Q1A {
    public static void main(String[] args) {
        if (args.length > 0) {
            int n = Integer.parseInt(args[0]);
            if (n % 2 == 0) throw new RuntimeException("n must be odd");
        }
        else
            System.out.println("Usage: java Q1A.java [odd number]");
    }
}