package fr.p10.miage.rps.model;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    private String nom;
    private int score;
    ArrayList<RPSEnum> mouvements ;


    public Player(String nom, ArrayList<RPSEnum> mouvements) {
        this.nom=nom;
        this.mouvements=mouvements;
    }

    public Player(String nom) {
        this.nom=nom;
        this.mouvements = new ArrayList<RPSEnum>();
        Random rand = new Random();
        int x=rand.nextInt(3-0);


    }


}
