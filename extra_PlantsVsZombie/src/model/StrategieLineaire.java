package model;


public class StrategieLineaire implements StrategieDeplacement{

	public Perso faitDeplacer(PersoMobile p){

		if(p.getVitesse() < 0){
			Perso obstacle= p.getObstacle();
			if(!(obstacle.equals(p)) ){
				if(!(p.getX() + p.getLargeur() - p.getVitesse() >= obstacle.getX())){
					p.setPosition(p.getX() - p.getVitesse());		
				}
			}
			else{
				p.setPosition(p.getX() + p.getLargeur() - p.getVitesse());
				if(p.getX() > p.environnement.getLargeurJardin())
					p.getgVie().meurt();
			}
			return obstacle;
		}
		else{
			Perso obstacle = p.getObstacle();
			if(!(p.equals(obstacle)) && (obstacle.getX() + obstacle.getLargeur() >= (p.getX() - p.getVitesse()))){
				p.setPosition(obstacle.getX() + obstacle.getLargeur());
			}
			else{
				p.setPosition(p.getX() - p.getVitesse());
			}
			return obstacle;
		}
	}
}
