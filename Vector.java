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
  
      
    public Vector () {
      pos = new Point();
      leng = 0.0;
    }
  
    public Vector (double x, double y, double z) {
      pos = new Point (x, y, z);
      leng = pos.distance ();
    }
    
    public Vector (double x, double y) {
      pos = new Point (x, y, 0);
      leng = pos.distance ();
    }
  
    public Vector (Point point) {
      pos = point;
      leng = pos.distance ();
    }
    
   @Override
    public String toString () {
      return "[" + pos.x + "î + " + pos.y + "? + " + pos.z + "k?]";
    }
    
    public boolean equals (Vector vecB) {
      return pos.equals (vecB.pos);
    }
    
    public double getMagnitude () {
      return leng;
    }
    
    public double angle (boolean inRadians) {
      return pos.angle(inRadians);
    }
    
    public double angle (Vector vecB, boolean inRadians) {
      return pos.angle (vecB.pos, inRadians);
    }
    
    public Vector add (Vector vecB) {
      pos.translate(vecB.pos);
      return new Vector (pos);
    }
    
    public double dot (Vector vecB, double theta, boolean inRadians) {
      return inRadians ? leng*vecB.leng*Math.cos (theta) : leng*vecB.leng*Math.cos ( Math.toRadians(theta) );
    }
    
    public Vector dot (Vector vecB, double theta, boolean inRadians, boolean returnVec) {
      return new Vector (pos.x*vecB.pos.x, pos.y*vecB.pos.y, pos.z*vecB.pos.z);
    }
    
    public double cross (Vector vecB, double theta, boolean inRadians) {
      return inRadians ? leng*vecB.leng*Math.sin (theta) : leng*vecB.leng*Math.sin ( Math.toRadians(theta) );
    }
}
