package model;

public class ZombiePogo extends Zombie{
	public ZombiePogo(int ligne,  Environnement e) {
		super(ligne, 5, new GVieBasic(80), 5, new StrategiePogo(new StrategieLineaire()), e);
		this.accessoire = new Pogo();
	}

	@Override
	public void evolue() {
		Perso obstacle = this.getDeplacement().faitDeplacer(this);
		System.out.println(obstacle.getClass());
		if(!this.getAccessoire().possedeAccessoire()){
			if(!(this.equals(obstacle)) && (obstacle.getX() + obstacle.getLargeur() >= (this.getX() - this.getVitesse()))){
				obstacle.getgVie().reçoitDegat(this, this.getDegatCauses());
			}
		}
	}
}
