package model;

public class StrategiePogo implements StrategieDeplacement {
	private StrategieDeplacement strategie;
	
	public StrategiePogo(StrategieDeplacement strategie) {
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
			int ind=perso.getLigne();
			perso.setLigne(((int)(Math.random()*5)+1));
			perso.getEnvironnement().getLignePersos(ind).remove(perso);
			perso.getEnvironnement().getLignePersos(perso.getLigne()).add(perso);
		}
		
		return obstacle;
	}
}