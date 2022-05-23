import java.util.Scanner;

/**
* The Complex class involves a complex number data type is immutable, and can model numbers in the
* form of a + bi, with i being the square root of -1. Addition,
* multiplication, and exponent methods are all built in.
*
* @author John Joire
*/

public class Complex {
 
  private final double real;
  private final double imaginary;
 
  /** Initializes a new complex number
   *
   * @param real - the real term in the complex number
   * @param imaginary - the coefficient of the imaginary term in the complex number
   */
  public Complex(double real, double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
  }
 
  public double getReal() { return real; }
 
  public double getImaginary() { return imaginary; }
 
  /**
   * Adds the attached complex number to the parameter to return the sum of the two
   *
   * @param num - the second addend in the addition operation
   */
 
  public Complex plus(Complex num) {
    double real = this.real + num.real;
    double imaginary = this.imaginary + num.imaginary;
    return new Complex(real, imaginary);
  }
 
  public Complex plus(double num) {
    double real = this.real + num;
    double imaginary = this.imaginary;
    return new Complex(real, imaginary);
  }
 
  public Complex add(Complex num1, Complex num2) { return num1.plus(num2); }
 
  public Complex add(Complex num1, double num2) { return num1.plus(num2); }
 
  public Complex add(double num1, Complex num2) { return num2.plus(num1); }
 
  /**
   * Multiplies the attached complex number to the parameter to return the product of the two
   *
   * @param num - the second factor in the multiplication operation
   */
 
  public Complex times(Complex num) {
    double real = (this.real * num.real) - (this.imaginary * num.imaginary);
    double imaginary = (this.real * num.imaginary) + (this.imaginary * num.real);
    return new Complex(real, imaginary);
  }
 
  public Complex times(double num) {
    double real = this.real * num;
    double imaginary = this.imaginary * num;
    return new Complex(real, imaginary);
  }
 
  public Complex multiply(Complex num1, Complex num2) { return num1.times(num2); }
 
  public Complex multiply(Complex num1, double num2) { return num1.times(num2); }
 
  /**
   * Takes the exponent of the attached complex number to the parameter's power to return the exponent
   *
   * @param exp - the exponent of the exponent operation
   */
 
  public Complex powerOf(int exp) {
    Complex storedProduct = new Complex(this.real, this.imaginary);
    for (int i = 1; i < exp; i++) {
      storedProduct = storedProduct.times(this);
    }
    return storedProduct;
  }
 
  public Complex exponent(Complex base, int exp) { return base.powerOf(exp); }
 
  /**
   * Finds the distance of a complex number from the number 0 + 0i on the complex number plane and returns
   * this distance.
   */
 
  public double fromOrigin() {
    double distance = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
    return distance;
  }
 
  public String toString() {
    if (real == 0.0 && imaginary == 0.0) { return "0.0"; }
    if (real == 0.0) { return "" + imaginary + "i"; }
    if (imaginary == 0.0) { return "" + real; }
    return "" + real + "+" + imaginary + "i";
  }
 
  /**
   * A main method designed to test the methods of the Complex class
   */
 
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Real element: ");
    double real1 = scan.nextDouble();
    System.out.print(" Imaginary element: ");
    double imaginary1 = scan.nextDouble();
    Complex num1 = new Complex(real1, imaginary1);
    System.out.println("Complex number: " + num1);
   
    System.out.print("Real element: ");
    double real2 = scan.nextDouble();
    System.out.print(" Imaginary element: ");
    double imaginary2 = scan.nextDouble();
    Complex num2 = new Complex(real2, imaginary2);
    System.out.println("Complex number: " + num2);
   
    System.out.println("Sum of numbers: " + num1.plus(num2));
    System.out.println("Product of numbers: " + num1.times(num2));
   
    System.out.println("Number 1 squared: " + num1.powerOf(2));
    System.out.println("Number 2 cubed: " + num2.powerOf(3));
  }
}

