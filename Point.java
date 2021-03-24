/**
 * Enhancement of the original java.awt.Point class, with a 3D representation
 * and using doubles instead of ints. Also more extensive helper methods
 * @author LahaLuhem
 * @version 1.1
 */
public class Point {
  /**
   * One of the coordinates that define a single Point.
   */
  double x, y, z;
  /**
   * Flag for the kind of Point perspective in use. Unchangable after constructing
   */
  private boolean rep3D;

    /**
     * Constructs a Point object with default values of 0.0s and a 3D perspective
     */
    public Point () {
      x = 0.0;
      y = 0.0;
      z = 0.0;
      rep3D = true;
    }
    
    /**
     * Constructs a Point object with given values, with a 2D perpective
     * @param x The x value of the point
     * @param y The y value of the point
     */
    public Point (double x, double y) {
      this.x = x;
      this.y = y;
      this.rep3D = false;
      this.z = 0.0;
    }
    
    /**
     * Constructs a Point object with given values, with a 2D perpective
     * @param x The x value of the point
     * @param y The y value of the point
     * @param z The z value of the point
     */
    public Point (double x, double y, double z) {
      this.x = x;
      this.y = y;
      this.rep3D = true;
      this.z = z;
    }

    /**
     * Constructs a Point object with random numbers in a given absolute range
     * @param randRngStart The absolute range min number
     * @param randRngEnd The absolute range max number
     * @param randRngStart The absolute range starting number
     * @param rep3D Whether the Point should be 3D or not
     */
    public Point (double randRngStart, double randRngEnd, boolean rep3D) {
      //Randomizing numbers
      x = Maths.randomDouble (randRngStart, randRngEnd);
      y = Maths.randomDouble (randRngStart, randRngEnd);
      if (rep3D) {
        z = Maths.randomDouble (randRngStart, randRngEnd);
      }
      this.rep3D = rep3D;
      
      //Randomizing sign
      if (Maths.randomInt (0, (int) randRngEnd) % 2 != 0) x *= -1.0;
      if (Maths.randomInt (0, (int) randRngEnd) % 2 != 0) this.y *= -1.0;
      if (Maths.randomInt (0, (int) randRngEnd) % 2 != 0) this.z *= -1.0;
    }
    
    /**
     * Converts a Point to its String representation
     * @returns The String representation of the Point
     */
    @Override
    public String toString() {
      if (rep3D) return "(" + x + ", " + y + ", " + z + ")"; 
      return "(" + x + ", " + y + ")";
    }
    
    /**
     * Checks whether the Points are equal or not
     * @returns 'true' if they are equal and 'false' otherwise
     */
    public boolean equals(Point p2) {
      return x == p2.x && y == p2.y && z == p2.z;
    }
    
    
    
    /**
     * Slides a Point by a given amount, specified by the values in the given Point
     * @param p2 Point containing values to be slid by
     */
    public void translate (Point p2) {
      translate(p2.x, p2.y, p2.z);
    }
    
    /**
     * Slides a Point by a given amount, specified by the values (2D)
     * @param dx Distance to move the x-coordinate by
     * @param dy Distance to move the y-coordinate by
     */
    public void translate(double dx, double dy) {
      x += dx;
      y += dy;
    }
    
    /**
     * Slides a Point by a given amount, specified by the values (3D)
     * @param dx Distance to move the x-coordinate by
     * @param dy Distance to move the y-coordinate by
     * @param dz Distance to move the z-coordinate by
     */
    public void translate (double dx, double dy, double dz) {
      x += dx;
      y += dy;
      z += dz;
    }

    /**
     * Returns the distance between the given 2 Points
     * @param p2 The 2nd Point
     * @returns The distance between these two Points 
     */
    public double distance (Point p2) {
      return Math.sqrt( (x-p2.x)*(x-p2.x) + (y-p2.y)*(y-p2.y) + (z-p2.z)*(z-p2.z) );
    }
    
    /**
     * Returns the mid-point of the given 2 Points
     * @param p2 The 2nd Point
     * @ruturns A Point, which is the 2 Point's midpoint
     */
    public Point midPoint (Point p2) {
      return this.section (p2, 1.0, 1.0, true);
    }
    
    /**
     * Returns the point at section the given 2 Points
     * @param p2 The 2nd Point
     * @param m 1st part of the section
     * @param n 2nd part of the section
     * @param isInternal Whether the sectioning takes place in-between two points (internal) or externally
     * @returns A Point, which is the 2 Point's point at section
     */
    public Point section (Point p2, double m, double n, boolean isInternal) {
      double newY, newX, newZ;
      if (isInternal) {
        newX = (m * p2.x + n * x) / (m + n);
        newY = (m * p2.y + n * y) / (m + n);
        newZ = (m * p2.z + n * z) / (m + n);
      }
      else {
        newX = (m * p2.x - n * x) / (m - n);
        newY = (m * p2.y - n * y) / (m - n);
        newZ = (m * p2.z - n * z) / (m - n);
      }
      
      return rep3D ? new Point (newX, newY, newZ) : new Point (newX, newY);
    }

     /**
     * Calculates the angle of a single Point
     * @param inRadians Whether the calculated angle should be in radians or not
     * @returns The angle of 1 Point
     */
    public double angle (boolean inRadians) {
      return inRadians ? Math.atan2(y,x) : Math.toDegrees( Math.atan2(y,x) );
    }
    
    /**
     * Calculates the angle between 2 given points
     * @param p2 The 2nd Point
     * @param inRadians Whether the calculated angle should be in radians or not
     * @returns The angle between the 2 given Points
     */
    public double angle (Point p2, boolean inRadians) {
      return (inRadians) ? Math.atan2(y,x) - Math.atan2(p2.y,p2.x) : Math.toDegrees ( Math.atan2(y,x) - Math.atan2(p2.y,p2.x) );
    }
    
    /**
     * Convert the given Point into its polar coordinates (2D)
     * @param inRadians Whether the calculated angle should be in radians or not
     * @returns A tuple of {r, theta} as an array ( from r(cos ? + i sin ?) )
     */
    public double[] toPolarForm (boolean inRadians) throws java.util.MissingFormatArgumentException {
      if (rep3D) throw new java.util.MissingFormatArgumentException("cannot operate on 3D representation. provide additonal \'perspective\' argument?");
      double r = distance(new Point(0.0, 0.0));
      
      return new double[]{r, angle(inRadians)};
    }

    /**
     * Convert the given Point into its polar coordinates (3D)
     * @param inRadians Whether the calculated angle should be in radians or not
     * @param perspective The axis perspective for reducing dimensional space
     * @returns A tuple of {r, theta} as an array ( from r(cos ? + i sin ?) )
     */
    public double[] toPolarForm (boolean inRadians, char perspective) {
      double r = distance(new Point(0.0, 0.0));
      double theta;
      switch (perspective) {
          case 'z': theta = inRadians ? Math.atan2(y,x) : Math.toDegrees( Math.atan2(y,x) );
                    break;
          case 'y': theta = inRadians ? Math.atan2(x,z) : Math.toDegrees( Math.atan2(x,z) );
                    break;
          case 'x': theta = inRadians ? Math.atan2(z,y) : Math.toDegrees( Math.atan2(z,y) );
                    break;
          default: return null;
      }
      return new double[]{r, theta};
    }
}