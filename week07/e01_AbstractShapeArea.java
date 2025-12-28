package week07;

abstract class e01_AbstractShapeArea {
    abstract double calculateRectangleArea(double width, double height);

    abstract double calculateCircleArea(double radius);

    abstract double calculateTraingleArea(double a, double b, double c);

    abstract double calculateTraingleArea(double base, double height);

    abstract double calculateSemicirleArea(double radius);

    abstract double calculateSectorArea(double radius, double angle);
}