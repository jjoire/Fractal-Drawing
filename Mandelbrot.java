import java.awt.Color;

/**
* The Mandelbrot class creates a picture of a fractal that graphically demonstrates
* the recursion of the formula n^2 + c where n and c are both complex numbers
* 
* EASY - add to the Complex class giving it features to find the conjugate of complex numbers, reciprocals of complex numbers, maybe even doing exponents of a complex number to a complex number using sinusoidal functions
* MEDIUM - actually replicate the real Mandelbrot fractal, with exciting colors
* HARD - create a zoom feature for the graphic that displays the repeating nature of a fractal
* 
* @author John Joire
*/

public class Mandelbrot {
 
  private final int SCALE = 1000;
  private Complex c;
  
  /**
   * Initializes a new Mandelbrot object
   *
   * @param c - the added complex number in the operation n^2 + c
   */
  public Mandelbrot(Complex c) {
    this.c = c;
  }
  
  /**
   * Initializes a new Mandelbrot object
   *
   * @param real - the real coefficient of the added complex number in the operation n^2 + c
   * @param imagincary - the coefficient of the imaginary term of the added complex number in the operation n^2 + c
   */
  public Mandelbrot(double real, double imaginary) {
    c = new Complex(real, imaginary);
  }
  
  /**
   * Draws the fractal graphic using the Picture class, assigning a complex number to each pixel and 
   * determining the color of each pixel based on how many times it takes for that pixel to recurse through
   * the mandelbrotRecursion method
   */
  public void drawMandelbrot() {
    Picture mandelbrot = new Picture(SCALE, SCALE);
    for (int i = 0; i < SCALE; i++) {
      for (int j = 0; j < SCALE; j++) {
        Complex pixel = toComplex(i,j);
        Color pixelColor = getColorFor(mandelbrotRecursion(pixel, 0));
        mandelbrot.set(i, j, pixelColor);
      }
    }
    mandelbrot.show();
  }
  
  /**
   * A helper method for the drawMandelbrot method, taking two doubles and creating a workable complex number to draw,
   * seeing as the complex number 1000 + 1000i would be well out of the range of the Mandelbrot recursion. Currently, 
   * the constants are hard-coded into the method, so if you would like to change the scale of the image you may have
   * to change them.
   * 
   * @param num1 - the real term of the complex number to be modified
   * @param num2 - the coefficient of the imaginary term of the complex number to be modified
   */
  
  private Complex toComplex(double num1, double num2) {
    double real = (num1 - 500) / 400;
    double imaginary = (num2 - 500) / 400;
    return new Complex(real, imaginary);
  }
  
  /**
   * Actually performs the recursion to determine the color of each pixel. Currently, it is set so that if the
   * recursion is done more than 21 times, the method stops running, else it would go on forever. Changing this base
   * case will change how the image appears.
   * 
   * @param num - the complex number that is initially squared in the operation n^2 + c
   * @param count - where the method begins its counting from when it starts to recurse
   */
  
  private int mandelbrotRecursion(Complex num, int count) {
    if (num.fromOrigin() > 2) { return count; }
    if (count > 21) { return -1; }
    return mandelbrotRecursion(num.powerOf(2).plus(c), count + 1);
  }
  
  /**
   * Assigns a color to an int for the purpose of each pixel in the fractal graphic. This method is used in conjunction
   * with the recursive method, such that depending on how many times the recursion runs, it will assigns a new 
   * color to the pixel
   * 
   * @param n - the number that is converted to a gray color via RGB values in the Color class
   * @precondition - n must be between 0 and 25 inclusively
   */
  
  private Color getColorFor(int n) {
    if (n == -1) { return Color.BLACK; }
    Color color = new Color(10*n, 10*n, 10*n);
    return color;
  }
 
  /**
   * A main method designed to test the methods of the Mandelbrot class by drawing
   * Mandelbrot graphics with different parameters
   */
 
  public static void main(String[] args) {
    Mandelbrot mandel1 = new Mandelbrot(0, -1);
    mandel1.drawMandelbrot();
    
    Mandelbrot mandel2 = new Mandelbrot(0, -0.9);
    mandel2.drawMandelbrot();
    
    Mandelbrot mandel3 = new Mandelbrot(0, -0.85);
    mandel3.drawMandelbrot();
    
    Mandelbrot mandel4 = new Mandelbrot(0, -0.8);
    mandel4.drawMandelbrot();
    
    Mandelbrot mandel5 = new Mandelbrot(1, 0);
    mandel5.drawMandelbrot();
  }
}
