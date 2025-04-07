package kivi;

import kivi.model.Figure;
import kivi.model.Functor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

/**
 * Задачи на обработку множества объектов:
 * 1.	В классе Repository реализовать метод, принимающий на вход заполненное
 * с клавиатуры множество различных фигур, экземпляр перечисления и вычисляющий фигуру
 * с максимальным значением переданного перечисления
 * <p>
 * 2.	Реализовать метод, вычисляющий две наиболее удаленные друг от друга фигуры
 * по переданному признаку-перечислению
 * <p>
 * Задачи на запись коллекции в текстовый файл:
 * 1.	В классе Repository реализовать метод, принимающий на вход имя текстового файла
 * и множество различных фигур и выполняющий сохранение данного множества в файл figures.csv в следующем формате:
 * название_фигуры;параметры_фигуры_через «;»;площадь;периметр
 * <p>
 * 2.	Реализовать метод, который принимает на вход имя файла, где сохранено множество различных фигур,
 * объект фигуры, который необходимо заменить в файле и объект фигуры на которую требуется произвести замену.
 * Выполняет замену одной фигуры в файле на другую, используя рациональные алгоритмы решения
 */

public class Repository {
    private Set<Figure> figures;

    public Repository(Set<Figure> figures) {
        this.figures = figures;
    }

    public Figure findFigureWithMaxProperty(Set<Figure> figures, Functor functor) {
        Figure maxFigure = null;
        double maxValue = Double.NEGATIVE_INFINITY;
        for (Figure figure : figures) {
            double figureValue;
            switch (functor) {
                case SQUARE:
                    figureValue = figure.square();
                    break;
                case PERIMETER:
                    figureValue = figure.perimeter();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown functor: " + functor);
            }
            if (figureValue > maxValue) {
                maxFigure = figure;
                maxValue = figureValue;
            }
        }
        return maxFigure;
    }

    public Figure[] getMostDistantFigures(Set<Figure> figures, Functor functor) {
        Figure maxFigure = null;
        Figure minFigure = null;
        double maxValue = Double.NEGATIVE_INFINITY;
        double minValue = Double.POSITIVE_INFINITY;
        for (Figure figure : figures) {
            double figureValue;
            switch (functor) {
                case SQUARE:
                    figureValue = figure.square();
                    break;
                case PERIMETER:
                    figureValue = figure.perimeter();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown functor: " + functor);
            }
            if (figureValue < minValue) {
                minFigure = figure;
                minValue = figureValue;
            }
            if (figureValue > maxValue) {
                maxFigure = figure;
                maxValue = figureValue;
            }
        }
        return new Figure[]{maxFigure, minFigure};
    }

    public void saveFiguresToFile(Set<Figure> figures) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("figures.csv"))) {
            bufferedWriter.write("figureName;square;perimeter");
            bufferedWriter.newLine();
            for (Figure figure : figures) {
                String line = String.format("%s;%.2f;%.2f", figure.getName(), figure.square(), figure.perimeter());
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }

    public void changeFigureInCSV(Figure newFigure, Figure oldFigure) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("figures.csv"));

        String oldFigureLine = String.valueOf(oldFigure);
        String newFigureLine = String.valueOf(newFigure);

        boolean ischanged = false;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).equals(oldFigureLine)) {
                ischanged = true;
                lines.set(i, newFigureLine);
                System.out.println("Changed figure: " + newFigureLine);
                break;
            }
            if (ischanged == false) {
                System.out.println("not found");
            }

        }
        Files.write(Paths.get("figures.csv"), lines);
    }

    @Override
    public String toString() {
        return "Repository{" +
                "figures=" + figures +
                '}';
    }
}
