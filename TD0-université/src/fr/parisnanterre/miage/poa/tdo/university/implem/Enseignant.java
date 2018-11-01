package fr.parisnanterre.miage.poa.tdo.university.implem;

import java.util.Date;

public abstract class Enseignant extends Personnel {

    /*mettre en protected si on veut que des classes filles utilisent les attributs*/
    protected Date dateRecrutement;
    protected double salaire;

    public Enseignant (Date dateRecrutement, double salaire, String nom, String prenom, String numSecu) {
        super(nom, prenom, numSecu);
        this.salaire=salaire;
        this.dateRecrutement=dateRecrutement;

        dateRecrutement = new Date();
    }

    public double getSalaire() {
        return salaire;
    }


    public String toString() {

        return ("Je suis le professeur " + getNom() + getPrenom() + " mon numéro de sécurité sociale est le: "+ getNumSecu()
        + "j'ai été recruté le + " + dateRecrutement + "je touche un salaire de "+ getSalaire());
    }
}
