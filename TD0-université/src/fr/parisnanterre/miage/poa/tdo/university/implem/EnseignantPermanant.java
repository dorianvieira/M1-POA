package fr.parisnanterre.miage.poa.tdo.university.implem;

import java.util.Date;

public class EnseignantPermanant extends Enseignant{

    public EnseignantPermanant(Date dateRecrutement, double salaire, String nom, String prenom, String numSecu) {
        super(dateRecrutement, salaire, nom, prenom, numSecu);
    }
}
