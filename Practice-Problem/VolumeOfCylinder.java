import java.util.Scanner;
import java.util.Scanner;
public class VolumeOfCylinder {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the radius of the cylinder: ");
        double r = sc.nextDouble();
        System.out.println("Enter the height of the cylinder: ");
        Double h = sc.nextDouble();
        double volume = 3.14 * r * r *h;
        System.out.println("The volume of the cylinder is "+volume);
        sc.close();
    }
}
