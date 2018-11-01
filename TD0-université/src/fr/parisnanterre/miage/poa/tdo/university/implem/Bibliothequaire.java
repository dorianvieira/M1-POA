package fr.parisnanterre.miage.poa.tdo.university.implem;

public class Bibliothequaire extends Biatoss {
    public Bibliothequaire(String nom, String prenom, String numSecu, double salaire) {
        super(nom, prenom, numSecu, salaire);
    }

    public String toString() {
        return super.toString() + "j'ai un salaire de :" + getSalaire();
    }
}
