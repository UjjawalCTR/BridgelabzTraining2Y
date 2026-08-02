import java.util.Scanner;
public class PerimeterOfRectangle {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter Length of the Rectangle: ");
        double l =  sc.nextDouble();
        System.out.println("Enter breadth of the Rectangle: ");
        double b = sc.nextDouble();
        double perimeter = 2*(l+b);
        System.out.println("The Perimeter of Rectangle is: "+perimeter);
        sc.close();

    }
}
