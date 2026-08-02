import java.util.Scanner;
public class AreaOfCircle{
	public static void main(String[] args){
		System.out.println("Enter radius: ");
		Scanner sc = new Scanner(System.in);
		double r = sc.nextDouble();
		double Area = 3.14 * r * r;
		System.out.println("Area of circle is: "+ Area);
		sc.close();
	}
}

		