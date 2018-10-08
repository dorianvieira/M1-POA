package fr.parisnanterre.miage.poa.tdo.university.implem;

import java.util.Date;

public class Professeur extends Enseignant {

    public Professeur(Date dateRecrutement, double salaire, String nom, String prenom, String numSecu) {
        super(dateRecrutement, salaire, nom, prenom, numSecu);
    }
}
