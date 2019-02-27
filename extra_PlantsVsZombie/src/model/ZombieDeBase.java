package model;

public class ZombieDeBase extends Zombie {
	
	
	public ZombieDeBase (int ligne, Environnement e ) {
		super(ligne, 5, new GVieBasic(80),5, new StrategieLineaire(), e);
	}

	public void evolue() {
		Perso obstacle = this.getDeplacement().faitDeplacer(this);
		if(!(this.equals(obstacle)) && (obstacle.getX() + obstacle.getLargeur() >= (this.getX() - this.getVitesse())))
			obstacle.getgVie().reçoitDegat(this, this.getDegatCauses());
			
	}
}