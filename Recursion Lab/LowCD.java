import java.util.Scanner;

public class LowCD  {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = 2;
        System.out.println("Enter the first number: ");
        int num1 = input.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = input.nextInt();
        int lCD = lowcom(num1, num2, x);
        System.out.println("The lowest common divisor is: " + lCD);
    }
    public static int lowcom(int num1, int num2, int x) {
        if (num1 % x == 0 && num2 % x == 0) {
            return x;
        }
        else {
            return lowcom(num1, num2, x+1);
        }
    }
}
