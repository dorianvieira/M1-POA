package fr.parisnanterre.miage.poa.tdo.university.implem;

import fr.parisnanterre.miage.poa.tdo.university.Personnel;

import java.util.Date;

public abstract class Enseignant extends Personnel {

    /*mettre en protected si on veut que des classes filles utilisent les attributs*/
    protected Date dateRecrutement;
    protected double salaire;

    public Enseignant (Date dateRecrutement, double salaire, String nom, String prenom, String numSecu) {
        super(nom, prenom, numSecu);
    }


    public String toString() {
        return ("");
    }
}
