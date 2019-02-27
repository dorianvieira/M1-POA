package model;

public class StrategieExplosive implements StrategieDeplacement {
		private StrategieDeplacement strategie;
	
	public StrategieExplosive(StrategieDeplacement strategie) {
		this.strategie = strategie;
		
	}
	/*
	public void perdAccessoire(Perso p){
		p.getAccessoire().perdAccessoire();;
	}
	
	public boolean possedeAccessoire(Perso p){
		return p.getAccessoire().possedeAccessoire();
	}
*/
	public Perso faitDeplacer(PersoMobile p){
		Perso obstacle = p.getObstacle();
		if(!(p.equals(obstacle)) && (obstacle.getX() + obstacle.getLargeur() + p.getLargeur()>= (p.getX() - p.getVitesse()))){
			p.setPosition(obstacle.getX() + obstacle.getLargeur() + p.getLargeur());
			obstacle.getgVie().reçoitDegat(p, p.getDegatCauses());
		}
		
		else{
			p.setPosition(p.getX() - p.getVitesse());
		}
		return obstacle;
	}
}