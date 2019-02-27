package model;

public class StrategiePerche implements StrategieDeplacement {
	private StrategieDeplacement strategie;
	
	public StrategiePerche(StrategieDeplacement strategie) {
		this.strategie = strategie;
		
	}
	
	public void perdAccessoire(Perso p){
		p.getAccessoire().perdAccessoire();
	}
	
	public boolean possedeAccessoire(Perso p){
		return p.getAccessoire().possedeAccessoire();
	}

	@Override
	public Perso faitDeplacer(PersoMobile perso) {
		Perso obstacle = this.strategie.faitDeplacer(perso);
		if(obstacle.getX() ==  perso.getX() - obstacle.getLargeur() && perso.getAccessoire().possedeAccessoire()){
			perso.getAccessoire().perdAccessoire();
			perso.ralentir(10);
			perso.setPosition(obstacle.getX() - obstacle.getLargeur());
		}
		
		return obstacle;
	}
}