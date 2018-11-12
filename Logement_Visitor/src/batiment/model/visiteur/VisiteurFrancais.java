package batiment.model.visiteur;

import batiment.model.base.*;

public class VisiteurFrancais implements Visiteur{

    @Override
    public void visit(Truc t) {
       /* if(t instanceof Lamp) {
            System.out.print("je suis une lampe");
        }
        else if(t instanceof Lit) {
            System.out.print("je suis un lit");

        }*/
    }

    @Override
    public void visit(CollectionDeLivres c) {
        System.out.println("je suis une collection" + c.nbLivres + "livres");
    }

    @Override
    public void visit(GardeRobe g) {
        System.out.println("je suis une garde robe livres");
        for(Vetement v: g.vetements) {
            v.accept(this);//accepter en tant que visiteur aux enfants
        }
    }

    @Override
    public void visit(Bureau b) {
        System.out.println("je suis une garde robe livres");
        for(Truc t: b.trucs) {
            t.accept(this);//accepter en tant que visiteur aux enfants
        }
    }

    @Override
    public void visit(Lamp l) {
        System.out.println("je suis une lampe");
    }

    @Override
    public void visit(Lit lit) {
        System.out.println("je suis unlit");
    }

    @Override
    public void visit(Piece p) {
        System.out.println("je suis une piece");
        for(Truc t: p.trucs) {
            t.accept(this);//accepter en tant que visiteur aux enfants
        }
    }

    @Override
    public void visit(Univers u) {
        System.out.println("je suis une garde robe livres");
        for(Piece p: u.pieces) {
            p.accept(this);//accepter en tant que visiteur aux enfants
        }
    }

    @Override
    public void visit(Vetement v) {
        System.out.println("je suis un vetement");

    }

    @Override
    public void accept(Visiteur v) {

    }

    @Override
    public Object value() {
        return null;
    }

}
