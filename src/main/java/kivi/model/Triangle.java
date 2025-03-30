package kivi.model;

import java.util.Objects;

/**
 * 2.	Создать классы Triangle, Rectangle с реализацией интерфейса Figure
 */

public class Triangle implements Figure{
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public double square() {
        double perimeter = (side1+side2+side3)/2; //perimeter/2 (полу периметр)
        return Math.sqrt(perimeter * (perimeter-side1) * (perimeter-side2) * (perimeter-side3));
    }

    @Override
    public double perimeter() {
        return side1+side2+side3;
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(side1, triangle.side1) == 0 && Double.compare(side2, triangle.side2) == 0 && Double.compare(side3, triangle.side3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side1, side2, side3);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }
}
