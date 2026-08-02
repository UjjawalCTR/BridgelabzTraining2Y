import java.util.Scanner;

public class CelToFah {
    public static void main(String[] args){
        System.out.println("Enter Reading in Celsius: ");
        Scanner input = new Scanner(System.in);
        double C = input.nextDouble();
        double Fahrenheit = (C * 9/5) + 32;
        System.out.println("After converting into Fahrenheit reading is: " + Fahrenheit);
        input.close();
    }
}
