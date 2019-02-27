package model;

import java.util.ArrayList;

public class Jeu {

	private Environnement environnement;

	private ArrayList<Zombie> reservoirZombie = new ArrayList<Zombie>();
	private int cagnotte=100;

	public Jeu(int pixelsLigne, int largeur) {
		if(pixelsLigne<0 || largeur<0)throw new Error("pixelsLignes ou ,nbLignes incorrect incorrect");
		this.environnement= new Environnement(pixelsLigne, largeur);
		this.reservoirZombie= new ArrayList<Zombie>();
	}

	public Environnement getEnvironnement(){
		return environnement;
	}

	public void unTour(){
		this.popZombie();
		this.environnement.evolue();
		this.environnement.setNbtour(this.environnement.getNbtour()+1);

	}

	public void Initialisation2(){
		//Initialise un terrain protegé pour faire des démos
//		Plante n1 = new Noix(1, 500, this.environnement);
//		Plante n2 = new Noix(2, 500, this.environnement);
//		Plante n3 = new Noix(3, 500, this.environnement);
//		Plante n4 = new Noix(4, 500, this.environnement);
//		Plante n5 = new Noix(5, 500, this.environnement);
//		Plante t1 = new Tournesol(1, 20, this.environnement);
//		Plante t2 = new Tournesol(2, 20, this.environnement);
//		Plante t3 = new Tournesol(3, 20, this.environnement);
//		Plante t4 = new Tournesol(4, 20, this.environnement);
//		Plante t5 = new Tournesol(5, 20, this.environnement);
//
//		addUnePlante(n1);
//		addUnePlante(n2);
//		addUnePlante(n3);
//		addUnePlante(n4);
//		addUnePlante(n5);
//		addUnePlante(t1);
//		addUnePlante(t2);
//		addUnePlante(t3);
//		addUnePlante(t4);
//		addUnePlante(t5);

		//test perchiste
		/*Zombie p = new Perchiste(1, this.environnement);
		//deux noix collées
		Plante n1 = new Noix(1, 250,  this.environnement);
		addUnePlante(n1);
		Plante n2 = new Noix(1, 250, this.environnement);


		addUnePlante(n2);
		addUnZombie(p);*/

	}
	/**
	 * ajoute 1 plante sur le terrain
	 * @param p
	 */
	public void addUnePlante(Plante p){
		ArrayList<Perso> l = environnement.getLignePersos(p.getLigne());
		l.add(p);
	}

	/**
	 * ajoute 1 zombie sur le terrain
	 * @param z
	 */
	public void addUnZombie(Zombie z){
		ArrayList<Perso> l = environnement.getLignePersos(z.getLigne());
		l.add(z);
		this.reservoirZombie.add(z);
	}

	/**
	 * fais apparaitre aléatoirement des Zombies au bord du terrain
	 */
	private void popZombie(){
		int alea = (int)(Math.random()*10);
		if(environnement.getNbtour() % 10 == 0 && alea % 2 == 0 && environnement.getNbtour() >= 150){
			Zombie z;
			if(alea % 5 == 0){
				if(alea != 0)
					z = new ZombieCasque((int)((Math.random()*5)+1),environnement);
				else
					z = new ZombieExplosif((int)((Math.random()*5)+1), environnement); 
			}
			else if(alea%4 == 0){
				if(alea != 4)
					z = new Perchiste((int)((Math.random()*5)+1), environnement); 
				else
					z = new ZombiePogo((int)((Math.random()*5)+1), environnement); 
			}
			else{
				z = new ZombieDeBase((int)((Math.random()*5)+1), environnement); 
			}

			addUnZombie(z);
		}

	}
	/*Définit le moment où le jeu se finit*/
	public boolean estFini(){
		boolean fini=false;
		for(int i=0; i<environnement.nbreLigne(); i++){
			ArrayList<Perso> l =environnement.getLignePersos(i);
			for(int j =0; j<l.size();j++ ){
				if(l.get(j).getX()<=0 && l.get(j) instanceof Zombie) {
					fini=true;
				}
			}
		}
		if(environnement.getNbtour() == 2000){
			fini= true;
		}
		return fini;
	}

	public void setCagnotte(int gain) {
		this.cagnotte+=gain;
	}

	public int getCagnotte() {
		return this.cagnotte;
	}

	public void resetCagnotte(int toremove) {
		this.cagnotte-=toremove;
	}


}

