package fr.parisnanterre.miage.poa.tdo.university.implem;

import fr.parisnanterre.miage.poa.tdo.university.Personnel;

public class Etudiant extends Personnel {

    private double echelonBourse;

    protected Etudiant (String nom, String prenom, String numSecu, double echelonBourse) {
        super(nom,prenom,numSecu);
        this.echelonBourse=echelonBourse;
    }


  /*  public double montantBourse() {
       switch (echelonBourse) {
           case 1: ZERO= 100.0;
           case 2: DEUX= 200.0;
           case 3: TROIS= 300.0;
           case 4: DOCTORANT= 1500.0;
           default: return 0;
       }
    }*/


    public String toString() {
        return ("je suis un Etudiant du nom: " + getNom()  + " prenom: " + getPrenom() + " numSecu: " + getNumSecu() + " je touche une bourse de: " + echelonBourse );
    }


    public double getEchelonBourse() {
        return echelonBourse;
    }
}
