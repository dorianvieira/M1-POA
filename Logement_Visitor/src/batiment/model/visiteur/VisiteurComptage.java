package batiment.model.visiteur;

import batiment.model.base.*;

/*pas besoin de modoifer les classes metiers car on code dans le visiteur*/
public class VisiteurComptage implements Visiteur{

    int cpt;

    public VisiteurComptage () {
        cpt=0;
    }
    @Override
    public Object value() {
        return cpt;
    }

    @Override
    public void visit(Truc t) {

    }

    @Override
    public void visit(CollectionDeLivres c) {

    }

    @Override
    public void visit(GardeRobe g) {

    }

    @Override
    public void visit(Bureau b) {
        cpt++;
        for(Truc t: b.trucs)
        {
            t.accept(this);
        }
    }

    @Override
    public void visit(Lamp l) {
        cpt++;
    }

    @Override
    public void visit(Lit lit) {
        cpt++;
    }

    @Override
    public void visit(Piece p) {
        for(Truc t: p.trucs) {
            t.accept(this);
        }
    }

    @Override
    public void visit(Univers u) {
        for(Piece p: u.pieces) {
            p.accept(this);
        }
    }

    @Override
    public void visit(Vetement v) {

    }

    @Override
    public void accept(Visiteur v) {

    }


}
