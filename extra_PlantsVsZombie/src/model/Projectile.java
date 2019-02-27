package model;

import java.util.ArrayList;

public class Projectile extends PersoMobile{



	public Projectile(int ligne, int x,Environnement environnement) {
		super(ligne, 28, x, 10, new GVieBasic(200), -25, new StrategieLineaire(),environnement);

	}

	public void evolue() {
		Perso obstacle = this.getDeplacement().faitDeplacer(this);
		if(this.getX() + this.getLargeur() - this.getVitesse() >= obstacle.getX()){
			obstacle.getgVie().reçoitDegat(obstacle, this.getDegatCauses());
			this.getgVie().meurt();		
		}
		
	}

	public boolean estObstaclePour(Perso p){
		/*if(p instanceof Projectile)
			return false ;
		else
			 return true;*/
		return false;
	}



	public Perso getObstacle(){

		ArrayList<Perso> ligne = this.getEnvironnement().getLignePersos(this.getLigne());

		int i = this.environnement.getLargeurJardin();

		for(Perso p2 : ligne){
			if(p2.getX() > this.getX() && p2.getX() < i && p2.estObstaclePour(this)){
				i = p2.getX();
			}
		}

		Perso obstacle = null;

		for(Perso p2 : ligne){
			if(p2.getX() == i && p2.estObstaclePour(this))
				obstacle = p2;
		}

		if (obstacle == null ){
			return this;
		}
		return obstacle;
	}

}