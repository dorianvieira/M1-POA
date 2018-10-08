package fr.parisnanterre.miage.poa.tdo.university.implem;

import java.util.Date;

public class MaitreConferences extends EnseignantPermanant {
    public MaitreConferences(Date dateRecrutement, double salaire, String nom, String prenom, String numSecu) {
        super(dateRecrutement, salaire, nom, prenom, numSecu);
    }
}
