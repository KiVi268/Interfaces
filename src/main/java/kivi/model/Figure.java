package kivi.model;

/**
 * 1.	Создать интерфейс Figure и объявить в нем методы square,
 * perimeter, которые не принимают на вход аргументов и возвращают double,
 * а так же метод getName, не принимающий аргументов и возвращающий название фигуры
 */

public interface Figure {

    double square();
    double perimeter();
    String getName();

}
