package fr.parisnanterre.miage.poa.tdo.university;

/*si on met pas abstract ca veut dire on peut avoir un personnel de type personnel or c'est pas ce qu'on veut*/
public abstract class Personnel {
    private String nom; /*protected pour donner les attributs aux classes filles*/
    private String prenom;
    private String numSecu;
    /*private NumeroPersonnel num*//*si on a une classe NuleroPerso*/


    protected Personnel(String nom, String prenom, String numSecu) {/*on rajoute (int numeroOrdre)*/
        this.nom = nom;
        this.prenom = prenom;
        this.numSecu = numSecu;
        //this.numero = new NumeroPersonnel(dateEntree, numeroOrdre);
    }



    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumSecu() {
        return numSecu;
    }
/*
    public String nom() {
        return nom;
    }

    public String prenom() {
        return prenom;
    }

    public String numSecu() {
        return numSecu;
    }
    */

    /*Ce toString sera utilisé par les classes filles*/
    public String toString() {
        return ("Je suis " + getNom() + getPrenom() +"/n" + "Mon numéro de sécurité sociale: " + getNumSecu());
    }
}
