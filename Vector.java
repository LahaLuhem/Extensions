/**
 * Implementation of a mathematical vector with possible functions
 * @author LahaLuhem
 * @version 1.0
 */
public class Vector {
  /**
   * Starting point of the vector
   */
  Point pos;
  /**
   * Length of the vector
   */
  private double leng;
  
    
    /**
     * Constructs a Vector with default values
     */
    public Vector () {
      pos = new Point();
      leng = 0.0;
    }
  
    /**
     * Constructs a Vector object with given values, with a 3D perpective
     * @param x The x value of the vector end-point
     * @param y The y value of the vector end-point
     * @param z The z value of the vector end-point
     */
    public Vector (double x, double y, double z) {
      pos = new Point (x, y, z);
      leng = pos.distance ();
    }
    
    /**
     * Constructs a Vector object with given values, with a 2D perpective
     * @param x The x value of the vector end-point
     * @param y The y value of the vector end-point
     */
    public Vector (double x, double y) {
      pos = new Point (x, y, 0);
      leng = pos.distance ();
    }
  
    /**
     * Constructs a Vector from just an end-point
     * @param point The vector end-point
     */
    public Vector (Point point) {
      pos = point;
      leng = pos.distance ();
    }
    
    /**
     * Converts a Vector to its String representation
     * @returns The String representation of the Vector
     */
    @Override
    public String toString () {
      return "[" + pos.x + "î + " + pos.y + "? + " + pos.z + "k?]";
    }
    
    /**
     * Checks whether the Vectors are equal or not
     * @returns 'true' if they are equal and 'false' otherwise
     */
    public boolean equals (Vector vecB) {
      return pos.equals (vecB.pos) && leng == vecB.leng;
    }
    
    /**
     * Getter for the Vector magnitude
     */
    public double getMagnitude () {
      return leng;
    }
    
    
    
    /**
     * Calculates the angle of a single Vector from the origin
     * @param inRadians Whether the calculated angle should be in radians or not
     * @returns The angle of 1 Point
     */
    public double angle (boolean inRadians) {
      return pos.angle(inRadians);
    }
    
    /**
     * Calculates the angle between 2 given vectors
     * @param vecB The 2nd Vector
     * @param inRadians Whether the calculated angle should be in radians or not
     * @returns The angle between the 2 given Vectors
     */
    public double angle (Vector vecB, boolean inRadians) {
      return pos.angle (vecB.pos, inRadians);
    }
    
    /**
     * Adds 2 Vectors together
     * @return The new resultant Vector
     */
    public Vector add (Vector vecB) {
      pos.translate(vecB.pos);
      return new Vector (pos);
    }
    
    /**
     * Calculates the value of the dot product between the 2 Vectors
     * @param vecB The 2nd Vector
     * @returns The scalar dot product this • vecB
     */
    public double dot (Vector vecB) {
      return leng * vecB.leng * Math.cos ( Math.abs(angle(vecB, true)) );
    }
    
    /**
     * Calculates the value of the cross product between the 2 Vectors
     * @param vecB The 2nd Vector
     * @returns The scalar cross product this ? vecB
     */
    public double cross (Vector vecB) {
      return leng * vecB.leng * Math.sin ( Math.abs(angle(vecB, true)) );
    }
}
