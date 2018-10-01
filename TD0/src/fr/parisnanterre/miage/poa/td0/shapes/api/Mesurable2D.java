package fr.parisnanterre.miage.poa.td0.shapes.api;

public interface Mesurable2D {

    double perimeter();
    double surface();
}

/*Si on fait
Point2D pr= new Point2D(1,3);
Mesurable2D r1 = new Rectangl(pr,2,3);
sysout(r1.perimeter()); /*ok car type statique de r1 c mesurable et dedans ya la méthode ermiter
r1.translate(2,3)
syout (r1.translate(2,3)) marche pas car le type statique c l'interface mesurable et ya pas la methode translate
donc comment utilier la methode translate sur r1 ???

 */
