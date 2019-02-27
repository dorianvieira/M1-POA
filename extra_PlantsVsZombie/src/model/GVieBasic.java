package model;

public class GVieBasic implements GestionnaireVie{
	private int pv;
	
	public GVieBasic(int pv){
		this.pv = pv;
	}
	
	@Override
	public boolean estMort() {
		return !(this.pv > 0);
	}

	@Override
	public void meurt() {
		this.pv = 0;
	}

	@Override
	public void reçoitDegat(Perso p, int degat) {
		this.pv -= degat;		
	}
	
	public int getVie() {
		return this.pv;
	}

}