package fr.parisnanterre.miage.poa.tdo.university.implem;

public class Biatoss extends Personnel {

    private double salaire;



    protected Biatoss(String nom, String prenom, String numSecu, double salaire) {
        super(nom, prenom, numSecu);
        this.salaire=salaire;
    }

    /*pourront etre utilsés par les classes filles*/
    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String toString() {
        return super.toString() + "j'ai un salaire de :" + salaire;
    }
}
