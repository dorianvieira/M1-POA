package batiment.model.visiteur;

import batiment.model.base.*;

public interface Visiteur {
    void visit(Truc t);
    void visit(CollectionDeLivres c);
    void visit (GardeRobe g);
    void visit (Bureau b);
    void visit (Lamp l);
    void visit (Lit lit);
    void visit (Piece p);
    void visit (Univers u);
    void visit (Vetement v);
    void accept(Visiteur v);

    /*compter dans visiteur comptage*/
    Object value();


}
