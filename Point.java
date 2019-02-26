/**
 * Enhancement of the original java.awt.Point class, with a 3D representation
 * and using doubles instead of ints. Also more extensive helper methods
 * @author (your name)
 * @version (a version number or a date)
 */
public class Point {
  double x, y, z;
  boolean rep3D;

    public Point () {
      x = 0.0;
      y = 0.0;
      z = 0.0;
      rep3D = true;
    }

    public Point (double x, double y) {
      this.x = x;
      this.y = y;
      this.rep3D = false;
      this.z = 0.0;
    }

    public Point (double x, double y, double z) {
      this.x = x;
      this.y = y;
      this.rep3D = true;
      this.z = z;
    }

    public Point (double randRng, boolean rep3D) {
      if (rep3D) {
          x = Maths.randomDouble (0.0, randRng);
          y = Maths.randomDouble (0.0, randRng);
          z = Maths.randomDouble (0.0, randRng);
      }
      else {
        x = Maths.randomDouble (0.0, randRng);
        y = Maths.randomDouble (0.0, randRng);
      }
      this.rep3D = rep3D;
      
      if (Maths.randomInt (0, (int) randRng) % 2 != 0) x *= -1.0;
      if (Maths.randomInt (0, (int) randRng) % 2 != 0) this.y *= -1.0;
      if (Maths.randomInt (0, (int) randRng) % 2 != 0) this.z *= -1.0;
    }

   @Override
    public String toString() {
      if (rep3D) return "(" + x + ", " + y + ", " + z + ")"; 
      return "(" + x + ", " + y + ")";
    }

    public boolean equals(Point p2) {
      return this.x == p2.x && this.y == p2.y && this.z == p2.z;
    }

    public void translate(double dx, double dy) {
      x += dx;
      y += dy;
    }

    public void translate (double dx, double dy, double dz) {
      x += dx;
      y += dy;
      z += dz;
    }

    public double distance (Point p2) {
      return Math.sqrt( (x-p2.x)*(x-p2.x) + (y-p2.y)*(y-p2.y) + (z-p2.z)*(z-p2.z) );
    }

    public Point midPoint (Point p2) {
      return this.section (p2, 1.0, 1.0, true);
    }

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

    public double[] polarForm (boolean inRadians) {
      if (rep3D) return null;
      double r = distance(new Point(0.0, 0.0));
      double angle;
      if (equals (new Point (0, 0, 0))) angle = 0;
      else angle = inRadians ? Math.atan(y/x) : Math.atan(y/x) * 180.0/Math.PI;
      return new double[]{r, angle};
    }

    public double[] polarForm (boolean inRadians, char perspective) {
      double r = this.distance(new Point(0.0, 0.0));
      double angle;
      switch (perspective) {
          case 'z': angle = inRadians ? Math.atan(y/x) : Math.atan(y/x) * 180.0/Math.PI;
                    break;
          case 'y': angle = inRadians ? Math.atan(x/z) : Math.atan(x/z) * 180.0/Math.PI;
                    break;
          case 'x': angle = inRadians ? Math.atan(z/y) : Math.atan(z/y) * 180.0/Math.PI;
                    break;
          default: return null;
      }
      return new double[]{r, angle};
    }
    
    public double angle (Point p2, boolean inRadians) {
      return (p2.polarForm (inRadians))[1] - (polarForm (inRadians))[1];
    }
}