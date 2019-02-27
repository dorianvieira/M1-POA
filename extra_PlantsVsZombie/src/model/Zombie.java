package model;

import java.util.ArrayList;

public abstract class Zombie extends PersoMobile{
	
	public Zombie (int ligne, int degatsCauses, GestionnaireVie gvie, int vitesse, StrategieDeplacement deplacement,Environnement environnement ) {
		super(ligne,80,environnement.getLargeurJardin()-1,degatsCauses,gvie,vitesse,deplacement,environnement);
	}
	
	public void evolue() {
		this.getDeplacement().faitDeplacer(this);
	}
	
	/**
	 * récupere l'obstacle à sa gauche
	 */
	public Perso getObstacle(){
		ArrayList<Perso> ligne = this.getEnvironnement().getLignePersos(this.getLigne());
		int i = 0;

		for(Perso p2 : ligne){
			if(p2.getX() < this.getX() && p2.getX() > i && this.estObstaclePour(p2)){
				i = p2.getX();
			}
		}
		
		Perso obstacle = null;
		for(Perso p2 : ligne){
			if(p2.getX() == i && !(p2 instanceof Projectile))
				obstacle = p2;
		}
		
		if (obstacle == null) {
			return this;
		}
		return obstacle;
	}
	
	public boolean estObstaclePour(Perso p){
		return p instanceof Plante || p instanceof Projectile;
		
	}
}