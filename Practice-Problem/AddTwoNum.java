import java.util.Scanner;
public class AddTwoNum {
    public static void main(String[] args){
        System.out.println("Enter first number: ");
        Scanner input = new Scanner(System.in);
        double num1 = input.nextDouble();
        System.out.println("Enter second number: ");
        double num2 = input.nextDouble();
        double sum = num1 + num2;
        System.out.println("The sum of first number and second number is: " + sum);
        input.close();
    }
}
