package fr.parisnanterre.miage.poa.td0.shapes.api;

import fr.parisnanterre.miage.poa.td0.shapes.implem.Point2D;

public interface Translatable2D {
    Point2D getRefPoint();
    void translate (double dx, double dy);
}
