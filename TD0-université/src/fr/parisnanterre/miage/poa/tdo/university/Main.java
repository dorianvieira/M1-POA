package fr.parisnanterre.miage.poa.tdo.university;

import fr.parisnanterre.miage.poa.tdo.university.implem.Doctorant;

public class Main {
    public static void main (String[]args){
        Personnel bob = new Doctorant("Salut ","Beaugoss "," 123456 ",150.0);
        System.out.print(bob.toString());
    }
}
