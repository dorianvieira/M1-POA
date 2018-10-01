package fr.parisnanterre.miage.poa.td0.shapes.implem;

import fr.parisnanterre.miage.poa.td0.shapes.api.Mesurable2D;
import fr.parisnanterre.miage.poa.td0.shapes.api.Translatable2D;

public abstract class Shape2D implements Mesurable2D, Translatable2D {

    private Point2D refPoint;

    public Shape2D(Point2D refPoint) {/*c'est un constructeur d'un classeabstraite on ne l'implemente pas mais avec un super pour une classe fille*/
        this.refPoint = refPoint;
    }

    @Override
    public Point2D getRefPoint() {
        return refPoint;
    }

    @Override
    public void translate(double dx, double dy) {
        refPoint.setX(refPoint.getX() + dx);/*qui a un point de reference et qui peut etre déplacé*/
        refPoint.setY(refPoint.getY() + dy);/*qui a un point de reference et qui peut etre déplacé*/

    }

}
