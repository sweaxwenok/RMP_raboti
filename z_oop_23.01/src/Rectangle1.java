public class Rectangle1 {
    Point topLeft;
    Point bottomRight;

    public Rectangle1(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public double getArea() {
        double width = Math.abs(bottomRight.x - topLeft.x);
        double height = Math.abs(bottomRight.y - topLeft.y);
        return width * height;
    }
}