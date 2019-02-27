package model;

import sound.Audio;

public class ZombieExplosif extends Zombie{



	public ZombieExplosif(int ligne, Environnement e) {
		super(ligne, 50,new GVieBasic(90), 10, new StrategieLineaire(), e);
	}





	public void evolue() {//si le zombie rencontre un obstacle il explose avec (image explosion) et tue en 1 fois l'obstacle, puis meurt sur le coup
		Perso obstacle = this.getDeplacement().faitDeplacer(this);
		if(!(this.equals(obstacle)) && (obstacle.getX() + obstacle.getLargeur() + this.getLargeur()>= this.getX() - this.getVitesse())){
			obstacle.getgVie().meurt();
			//Image explosion = new Image("view/explosion.png");
		//	if(obstacle instanceof Plante){
			Audio son = new Audio("src/sound/Bomb.wav");
			son.start();
			this.getgVie().meurt();	
				
		//	}
		}	
		

	}


}
