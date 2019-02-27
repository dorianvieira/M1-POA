package model;

public interface GestionnaireVie {
	
	public boolean estMort();
	
	public void meurt();
	
	public void reçoitDegat(Perso p, int degat);
	
	public int getVie();
}