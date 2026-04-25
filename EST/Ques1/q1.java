import java.util.*;
public class EST_1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a: ");      
        int a = scn.nextInt();
        System.out.print("Enter b: ");
        int b = scn.nextInt();
        int[] result = extendedEuclid(a, b);
        System.out.println("gcd: " + result[0] + ", x: " + result[1] + ", y: " + result[2]);
    }

    public static int[] extendedEuclid(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0}; // gcd, x, y
        }
        int[] result = extendedEuclid(b, a % b);
        int gcd = result[0];
        int x1 = result[1];
        int y1 = result[2];
        int x = y1;
        int y = x1 - (a / b) * y1;
        return new int[]{gcd, x, y};
    }
}
