/**
 * @author Evan Phillips
 *ComplexNum class
 */

package assg22_Phillipsev20;

public class ComplexNum {
	
	private double real, imaginary;
	
	/**
	 * default constructor
	 */
	
	public ComplexNum() {
		this.real = 0;
		this.imaginary = 0;
	}
	
	/**
	 * @param real
	 */
	public ComplexNum(double real) {
		this.real = real;
		this.imaginary = 0;
	}
	/**
	 * @param real
	 * @param imaginary
	 */
	public ComplexNum(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	/**
	 * 
	 * @return real
	 */
	public double getReal() {
		return this.real;
	}
	/**
	 * 
	 * @return imaginary
	 */
	public double getImaginary() {
		return this.imaginary;
	}
	/**
	 * set new real
	 * @param real
	 */
	public void setReal(double real) {
		this.real = real;
	}
	/**
	 * set new imaginary
	 * @param imaginary
	 */
	public void setImaginary(double imaginary) {
		this.imaginary = imaginary;
	}
	/**
	 * 
	 * @param add
	 * @return new addition number from the two objects
	 */
	public ComplexNum add(ComplexNum add){
		double realVal = this.real + add.real;
		double imaginaryVal = this.imaginary + add.imaginary;
		return new ComplexNum(realVal, imaginaryVal);
	}
	/**
	 * 
	 * @param sub
	 * @return new subtraction number from the two objects
	 */
	public ComplexNum sub(ComplexNum sub) {
		double realVal = this.real - sub.real;
		double imaginaryVal = this.imaginary - sub.imaginary;
		return new ComplexNum(realVal, imaginaryVal);
	}
	/**
	 * 
	 * @param mul
	 * @return new multiplication number of the two objects 
	 */
	public ComplexNum mul(ComplexNum mul) {
		double realVal = (this.real * mul.real) - (this.imaginary * mul.imaginary);
		double imaginaryVal = (this.real * mul.imaginary) + (this.imaginary * mul.real);
		return new ComplexNum(realVal, imaginaryVal);
	}
	/**
	 * 
	 * @return negative numbers
	 */
	public ComplexNum neg() {
		double realVal = this.real * (-1);
		double imagimaryVal = this.imaginary * (-1);
		return new ComplexNum(realVal, imagimaryVal);
	}
	/**
	 * sets the format
	 */
	@Override
	public String toString() {
		String num = "";
		
		if (this.real != 0) {
			if (this.imaginary < 0) {
				num = this.real + " - " + this.imaginary + "i";
			}
			else if(this.imaginary > 0) {
				num = this.real + " + " + this.imaginary + "i";
			}
			else {
				num += this.real;
			}
		}
		else {
			if(this.imaginary != 0) {
				num += this.imaginary + "i";
			}	
			else {
				num += 0;
			}
		}
		
		return num;
	}
	/**
	 * checks if the objects/numbers are the same
	 */
	@Override
	public boolean equals(Object obj) {
		ComplexNum temp = (ComplexNum) obj;
		return this.real == temp.real && this.imaginary == temp.imaginary;
	}
}
