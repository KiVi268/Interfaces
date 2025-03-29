package kivi.util;

import kivi.model.Figure;
import kivi.model.Functor;

/**
 * 3.	Создать класс Calculator, в качестве поля класса указать объект типа Figure,
 * с которым будет работать калькулятор. В конструкторе класса произвести инициализацию данного поля
 * 5.	В классе Calculator написать метод calculate, принимающий на вход экземпляр перечисления и возвращающий
 * double – результат вычислений калькулятора для заданной фигуры в зависимости от переданного экземпляра перечисления
 */

public class Calculator{
    private Figure figure;

    public Calculator(Figure figure) {
        this.figure = figure;
    }

    public double calculate(Functor functor) {
        return switch (functor){
            case SQUARE -> figure.square();
            case PERIMETER -> figure.perimeter();
        };
    }
}
