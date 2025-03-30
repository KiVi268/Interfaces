package kivi.model;

import java.util.Objects;

/**
 * 2.	Создать классы Triangle, Rectangle с реализацией интерфейса Figure
 */

public class Rectangle implements Figure{
    private double side1;
    private double side2;

    public Rectangle() {
    }

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
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

    @Override
    public double square() {
        return side1*side2;
    }

    @Override
    public double perimeter() {
        return side1+side2;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(side1, rectangle.side1) == 0 && Double.compare(side2, rectangle.side2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side1, side2);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                '}';
    }
}
