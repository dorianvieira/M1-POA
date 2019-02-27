package model;

public class Tournesol extends Plante{



	public Tournesol (int ligne ,int x,Environnement environnement ){
		super(ligne, 80, x, 0, new GVieBasic(50), environnement);


	}

	public void evolue(){
		// Soleil si pas de soleil auparavant,
		int nbtour = this.getEnvironnement().getNbtour();
		if (nbtour%50 == 0 && isAble()) {
//			if (s.getLigne()==this.getLigne() && s.getX() == this.getX()+15) {
//				
//				if (s.getEstRecupere()==false){
//					able = false;
//				}
			Soleil s= new Soleil(this.getLigne(),70,this.getX()+15 , new GVieBasic(50),this.getEnvironnement());
			this.environnement.getSoleils().add(s);
		}


	}

	public boolean isAble() {
		boolean able= true;
		
		for (Soleil s : this.getEnvironnement().getSoleils()) {
			//System.out.println(s.getX()+""+this.getX());
			if (s.getLigne()==this.getLigne() && s.getX() == this.getX()+15) {
		
				if (s.getEstRecupere()==false){
					able = false;
				}
			}
		}
		return able;
	}

	@Override
	public boolean estObstaclePour(Perso p) {
		// TODO Auto-generated method stub
		return false;
	}


}