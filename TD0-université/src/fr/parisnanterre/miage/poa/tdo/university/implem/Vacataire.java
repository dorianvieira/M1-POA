package fr.parisnanterre.miage.poa.tdo.university.implem;

import java.util.Date;

public class Vacataire extends EnseignantTemporaire {

    public Vacataire (Date dateRecrutement, double salaire, String nom, String prenom, String numSecu) {
        super(dateRecrutement,salaire,nom, prenom, numSecu);
    }

    public String toString() {
        return super.toString();
    }
}
