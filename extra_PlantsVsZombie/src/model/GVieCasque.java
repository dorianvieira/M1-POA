package model;

public class GVieCasque extends GVieProtection{

	public GVieCasque(GestionnaireVie g) {
		super(2, g);
	}

	@Override
	public int getVie() {
		 return this.getGVie().getVie();
	}

	@Override
	public boolean efficaceContre(Perso p) {
		return true;
	}
	
	

}