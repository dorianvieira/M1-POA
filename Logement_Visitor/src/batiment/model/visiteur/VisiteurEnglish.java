package batiment.model.visiteur;

import batiment.model.base.*;

public class VisiteurEnglish implements Visiteur {
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
        System.out.println("i am an garderobe");
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
        System.out.println("i am a light");
    }

    @Override
    public void visit(Lit lit) {
        System.out.println("I am a bed");
    }

    @Override
    public void visit(Piece p) {
        System.out.println("I am a room");
        for(Truc t: p.trucs) {
            t.accept(this);//accepter en tant que visiteur aux enfants
        }
    }

    @Override
    public void visit(Univers u) {
        System.out.println("I am an univers");
        for(Piece p: u.pieces) {
            p.accept(this);//accepter en tant que visiteur aux enfants
        }
    }

    @Override
    public void visit(Vetement v) {
        System.out.println("I am a clothe");

    }

    @Override
    public void accept(Visiteur v) {

    }

    @Override
    public Object value() {
        return null;
    }
}
