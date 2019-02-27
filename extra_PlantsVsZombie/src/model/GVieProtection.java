package model;

public abstract class GVieProtection implements GestionnaireVie {

	private int pArmure;
	private GestionnaireVie g;
	
	public GVieProtection(int pArmure, GestionnaireVie g){
		this.pArmure = pArmure;
		this.g = g;
	}
	
	/**
	 * vérifie si ses points de vies sont inferieurs à zero
	 */
	@Override
	public boolean estMort() {
		return this.g.estMort();
	}
	
	/**
	 * quand le personnage meurt, son armure et sa vie passent à zero
	 */
	@Override
	public void meurt() { 
		if(estMort()){
			this.pArmure = 0; 
			this.g.meurt();
		}
	}
	
	
	/**
	 * si efficace
	 * réduit les dégats du montant de l'armure
	 */
	@Override
	public void reçoitDegat(Perso p, int degat) {
		if(efficaceContre(p)){
			this.g.reçoitDegat(p, degat - this.pArmure);
		}
		else{
			this.g.reçoitDegat(p, degat);
		}
	}
	
	public GestionnaireVie getGVie(){
		return this.g;
	}
	
	public int getVie(){
		return g.getVie();
	}
	
	

	abstract public boolean efficaceContre(Perso p);

}