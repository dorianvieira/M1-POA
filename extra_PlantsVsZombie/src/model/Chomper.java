package model;

import sound.Audio;

public class Chomper extends Plante{
	private boolean estCharge;

	public Chomper(int ligne, int x, Environnement environnement) {
		super(ligne, 80, x, 1000,new GVieBasic(70), environnement);
		this.estCharge=true;
	}

	@Override
	public void evolue(){
		Perso obstacle = getObstacle();
		if(estCharge && obstacle instanceof Zombie && obstacle.getX() == this.getX()+this.getLargeur()){
			obstacle.getgVie().reçoitDegat(obstacle, getDegatCauses());
			Audio son = new Audio("src/sound/Bigchomp.wav");
			son.start();
			estCharge=false;
		}
		else{
			recharge();
		}
	}
	
	/*
	 * recharge l'attaque si elle est déchargée tout les 120 tours
	 */
	public void recharge(){
		if(!estCharge && environnement.getNbtour()%120==0){
			this.estCharge=true;
		}
	}

}
