package model;

public class Soleil extends Perso{

	private boolean estRecupere=false;

	private int gain=50;



	public Soleil(int ligne, int largeur,int x, GestionnaireVie gVie , Environnement e ) {
		super(ligne, largeur,x,0, gVie,e);
	}
	public int getGain() {
		return this.gain;
	}


	public boolean getEstRecupere(){
		return estRecupere;
	}
	public void setEstRecupere(boolean recup){
		estRecupere= recup;
	}


	@Override
	public void evolue() {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean estObstaclePour(Perso p) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Perso getObstacle() {
		// TODO Auto-generated method stub
		return null;
	}

	/*


public int getGain() {
return gain;
}


public void setGain(int gain) {
this.gain = gain;
}

	 */



}
