import java.util.Scanner;
public class ConvertingKilometersToMiles {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Distance In Kilometers: ");
        double kilometers = sc.nextDouble();
        double miles = kilometers*0.621371;
        System.out.println("The Distance In Miles Is: "+miles);
        sc.close();
    }
}
