package fr.parisnanterre.miage.poa.tdo.university.implem;

public class Doctorant extends Etudiant {


    public Doctorant(String nom, String prenom, String numSecu, double echelonBourse) {
        super(nom, prenom, numSecu, echelonBourse);
    }


    public String toString() {
        return ("salut "+ getNom() + getPrenom() + "num: " + getNumSecu() + "echelon "+ getEchelonBourse());
    }
}
