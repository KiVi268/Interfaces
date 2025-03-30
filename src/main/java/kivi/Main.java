package kivi;

import kivi.model.Figure;
import kivi.model.Functor;
import kivi.model.Rectangle;
import kivi.model.Triangle;
import kivi.util.Calculator;

import java.util.Scanner;
/**6.	В методе main класса Program создать два экземпляра калькулятора с передачей разных фигур,
 *  произвести вычисление площади и периметра данных фигур
 7.	Реализацию интерфейса Figure выполнить в виде анонимного внутреннего класса и передать ее в объект калькулятора.
 У анонимного внутреннего класса должно быть поле R – радиус окружности, а так же сеттер,
 производящий его инициализацию. При вызове сеттера данные передаются с клавиатуры.
 Вычислить и вывести на экран периметр и площадь окружности с заданным радиусом
**/

 public class Main {
    public static void main(String[] args) {
        Calculator triangleCalculator = new Calculator(new Triangle(3, 4, 3));
        Calculator rectangleCalculator = new Calculator(new Rectangle(5, 7));

        System.out.println("Triangle square: " + triangleCalculator.calculate(Functor.SQUARE));
        System.out.println("Triangle perimeter: " + triangleCalculator.calculate(Functor.PERIMETER));

        System.out.println("Rectangle square: " + rectangleCalculator.calculate(Functor.SQUARE));
        System.out.println("Rectangle perimeter: " + rectangleCalculator.calculate(Functor.PERIMETER));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the radius: ");
        Figure circle = new Figure() {
            private double R;

            {R = scanner.nextDouble();}

            @Override
            public double square() {
                return Math.PI * R * R;
            }

            @Override
            public double perimeter() {
                return 2 * Math.PI * R;
            }

            @Override
            public String getName() {
                return "Circle";
            }
        };

        System.out.println("Area: " + circle.square());
        System.out.println("Perimeter: " + circle.perimeter());



    }
}