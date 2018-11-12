package batiment.model;

import batiment.model.base.*;
import batiment.model.visiteur.Visiteur;
import batiment.model.visiteur.VisiteurComptage;
import batiment.model.visiteur.VisiteurEnglish;
import batiment.model.visiteur.VisiteurFrancais;

public class Main {
    public static void main(String[]args) {
        Truc l = new Lit();
        Piece p = new Piece("chambre");
        p.ajouter(l);
        Univers u = new Univers();
        u.ajouter(p);

        Bureau b = new Bureau();
        p.ajouter(b);
        Truc x = new Lamp();
        b.ajouter(x);

       /* Visiteur v = new VisiteurFrancais();
        u.accept(v);*/

      /*  Visiteur v2 = new VisiteurEnglish();
        u.accept(v2);*/

        Visiteur v3 = new VisiteurComptage();
        u.accept(v3);
        System.out.println(v3.value());

    }
}
