/**
 * @author Evan Phillips
 *ComplexNum demo class
 */

package assg22_Phillipsev20;

public class ComplexNumDemo {

	public static void main(String[] args) {
		ComplexNum n1 = new ComplexNum(5,3.5);
		ComplexNum n2 = new ComplexNum(6,4.5);
		ComplexNum n3 = new ComplexNum(5,3.5);
		ComplexNum n4 = new ComplexNum();
		ComplexNum n5 = new ComplexNum(45);
		
		System.out.println("ComplexNum n1 is: " + n1 + "\n");
		
		System.out.println("Get real is: " + n1.getReal() + "\n"
				+ "Get Imaginary is: " + n1.getImaginary() + "\n");
		
		n2.setReal(-2);
		n2.setImaginary(8);
		System.out.println("set num is: " + n2 + "\n");
		
		System.out.println("ComplexNum n2 is: " + n2 + "\n");
		
		System.out.println("Add method: " + n1.add(n2));
		System.out.println("Sub method: " + n1.sub(n2));
		System.out.println("mul method: " + n1.mul(n2));
		System.out.println("Neg method: " + n1.neg()+ "\n");
		
		System.out.println("Same numbers/equals check: " + n1.equals(n3));
		System.out.println("Different numbers/equals check: " + n1.equals(n2) + "\n");
		
		System.out.println("this is the toString metheod: " + n1.toString()+ "\n");
		
		System.out.println("This is the default constructor: " + n4 + "\n");
		
		System.out.println("This is the single parameter constructor: " + n5);
		
	}

}
