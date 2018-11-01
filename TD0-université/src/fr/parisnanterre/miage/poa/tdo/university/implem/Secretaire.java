package fr.parisnanterre.miage.poa.tdo.university.implem;

public class Secretaire extends Biatoss {
    public Secretaire(String nom, String prenom, String numSecu, double salaire) {
        super(nom, prenom, numSecu, salaire);
    }

    public String toString() {
        return super.toString() + "j'ai un salaire de :" + getSalaire();
    }
}
