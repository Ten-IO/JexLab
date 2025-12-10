package week04;
class Point2D {
     private float x = 0.0f, y = 0.0f;

    Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    Point2D() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        return new float[] { this.x, this.y };
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + ',' + this.y + ')';
    }
}

class Point3D extends Point2D {
    private float z = 0.0f;

    Point3D(float gx, float y, float z) {
        super.setX(gx);
        super.setY(y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[] { this.getX(), super.getY(), this.getZ() };
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    // public String toString() {
    //     return "(" + this.getX() + ',' + this.getY() + ',' + this.z + ')';
    // }
}

public class i0x_point {

    public static void main(String args[]) {
        // Point 2D
        Point2D two = new Point2D();
        two.setX(0.1f);
        two.setY(0.2f);
        System.out.println(two.toString());

        // Point 3D
        Point3D three = new Point3D(2, 3, 4);
        System.out.println(three.toString());
    }
}
