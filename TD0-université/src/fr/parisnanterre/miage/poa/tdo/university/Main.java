package fr.parisnanterre.miage.poa.tdo.university;

import fr.parisnanterre.miage.poa.tdo.university.implem.*;

public class Main {
    public static void main (String[]args){
        Personnel doctorant1 = new Doctorant("Salut ","Beaugoss "," 123456 ",150.0);
        System.out.println(doctorant1.toString());

        Biatoss secretaire1 = new Secretaire("delafontaine","jean", "12545", 1500.00);
        System.out.println(secretaire1.toString());

        //Enseignant ens1 = new EnseignantPermanant(28-02-01,1400.00,"petit","legros");
        //System.out.print(ens1.toString());

    }
}
