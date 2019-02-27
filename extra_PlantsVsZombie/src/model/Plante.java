package model;

import java.util.ArrayList;

public abstract class Plante  extends Perso{
	
	//private    GestionnaireVie  gVie ;
	
	public Plante (int ligne , int largeur,int x,int degautCauses,GestionnaireVie gVie,Environnement environnement){
		//this.gVie= new GVieBasic(50);
		super(ligne,largeur,x,degautCauses, gVie,environnement);
		
		
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
			if(p2.getX() == i)
				obstacle = p2;
		}
		if (obstacle == null) {
			return this;
		}
		return obstacle;
	}

	
	
	@Override
	public  boolean estObstaclePour(Perso p) {
		
		return p instanceof Zombie;
		
	}
	

}