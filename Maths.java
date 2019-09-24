/**
 * Modifications of the original java.lang.Math class with added benefits
 * @author Laha Luhem
 * @version 1.0.0
 */
                        import java.math.BigInteger;
                        import java.math.BigDecimal;
                     
public class Maths {
  /**
   * Method randomInt
   * generates a random int between a given range.
   * @param low the lower bound
   * @param high the upper bound
   * @return The random number
   */
  public static int randomInt (int low, int high) {
    double rand = low-1;
    while (rand < (double) low) rand = (double) high*Math.random();
    return (int) rand;
  }
  
  /**
   * Method randomDouble
   * generates a random double between a given range.
   * @param low the lower bound
   * @param high the upper bound
   * @return The random number
   */
  public static double randomDouble (double low, double high) {
    double rand = low-1;
    while (rand < (double) low) rand = (double) high*Math.random();
    return rand;
  }
  
  /**
   * Method factorial
   * Calculates the factorial of a given num
   * @param num The number
   * @return The factorial
   */
  public static int factorial (int num) {
    int fac = 1;
    for ( ; num > 1; num--) fac *= num;
    return fac;
  }
}
