package model;

public class Perchiste extends Zombie{
	public Perchiste(int ligne, Environnement e) {
		super(ligne, 5, new GVieBasic(80),15, new StrategiePerche(new StrategieLineaire()), e);
		this.accessoire = new Perche();
	}
	
	@Override
	public void evolue() {
		Perso obstacle = this.getDeplacement().faitDeplacer(this);
		if(!this.getAccessoire().possedeAccessoire()){
			if(!(this.equals(obstacle)) && (obstacle.getX() + obstacle.getLargeur() >= (this.getX() - this.getVitesse()))){
				obstacle.getgVie().reçoitDegat(this, this.getDegatCauses());
			}
		}
	}
}