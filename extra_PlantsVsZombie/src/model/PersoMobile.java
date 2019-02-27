package model;

import java.util.ArrayList;

public abstract class PersoMobile extends Perso{


	private int vitesse;
	private StrategieDeplacement deplacement;


	public PersoMobile(int ligne, int largeur, int x, int degatsCauses, GestionnaireVie gvie, int vitesse, StrategieDeplacement deplacement, Environnement e) {
		super(ligne, largeur, x, degatsCauses, gvie,e);

		this.vitesse=vitesse;

		this.deplacement=deplacement;
		
		

	}

	public int getVitesse() {
		return this.vitesse;
	}

	public StrategieDeplacement getDeplacement() {
		return this.deplacement;
	}

	public void setPosition(int pos){
		this.x=pos;
	}

	public void ralentir (int value) {
		this.vitesse-=Math.abs(value);
	}

	public void changeDirection() {
		this.vitesse=-(this.vitesse);
	}

	/**
	 * regarde dans l'environnement si
	 * un personnage est devant lui
	 * @return true si bloqué
	 */
	public boolean estBloque() {
		Environnement e = this.getEnvironnement();
		ArrayList<Perso> ligne = e.getLignePersos(this.getLigne());
		
		int indexObstacle = ligne.indexOf(this)-1;
		boolean estBloque = false;

		if(ligne.size()<=1)
			return false ;

		else if(ligne.get(indexObstacle).estObstaclePour(this) && ligne.get(indexObstacle).getX() == this.getX()+100)
			return estBloque = true;

		return estBloque;
	}

}