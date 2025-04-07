package kivi;

import kivi.model.Figure;
import kivi.model.Functor;

import java.util.Set;

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
}
