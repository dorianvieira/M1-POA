package model;

public abstract class Perso {

	protected Environnement environnement;

	private int ligne;

	protected int x;

	private int largeur;

	private int degatsCauses;

	private GestionnaireVie gVie;

	protected Accessoire accessoire;

	public Perso(int ligne, int largeur,int x, int degatsCauses, GestionnaireVie gVie, Environnement e) {
		if(ligne<0 ||x<0 ||largeur<0 || degatsCauses<0 || gVie==null)throw new Error("paramètres du perso incorrect");

		this.ligne=ligne;
		this.largeur=largeur;
		this.degatsCauses=degatsCauses;
		this.gVie=gVie;
		this.setEnvironnement(e);
		this.accessoire = null;
		boolean isTaken = false;
		if(e.getLignePersos(ligne).size() > 0){
			do{
				isTaken = this.isTaken(x, e, ligne);
				if(!isTaken){
					this.x=x;
				}
				else{
					isTaken = true;
					x = x + largeur + 1;
				}
			}while(isTaken);
		}
		else{
			this.x = x;
		}
	}

	public int getLargeur(){
		return this.largeur;
	}

	public int getLigne(){
		return this.ligne;
	}

	public int getX(){
		return this.x;
	}

	public int  getDegatCauses(){
		return this.degatsCauses;
	}


	public GestionnaireVie getgVie(){
		return this.gVie;
	}

	public Environnement getEnvironnement(){
		return environnement;
	}

	public void setEnvironnement(Environnement e){
		this.environnement=e;
	}

	public void setLigne(int l) {
		this.ligne=l;
	}


	public boolean possedeAccessoire(){
		return this.accessoire == null;
	}

	public Accessoire getAccessoire(){
		return this.accessoire;
	}



	public boolean isTaken(int x, Environnement e, int ligne){
		boolean isTaken = false;
		for(int j = 0 ; j < e.getLignePersos(ligne).size() && !isTaken ; j++){
			Perso p = e.getLignePersos(ligne).get(j);
			if(!(this instanceof Soleil) && !(p instanceof Projectile) && !(this instanceof Projectile) && (x == p.getX() || (x > p.getX() && x < p.getX() + p.getLargeur() || (x < p.getX() && (x + p.getLargeur()) > p.getX() )) )){
				isTaken = true;
			}
		}
		
		
		return isTaken;
	}

	public abstract void evolue();

	public abstract boolean estObstaclePour(Perso p);

	public abstract Perso getObstacle();//--> methode abstraite pour trouver un obstacle : Zombie != Plante
}