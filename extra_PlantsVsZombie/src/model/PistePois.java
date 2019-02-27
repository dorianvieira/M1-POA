package model;

import java.util.ArrayList;

public class PistePois  extends Plante{

	private int portee ;


	public PistePois (int ligne , int x ,Environnement environnement ){
		super(ligne ,80, x ,10,new GVieBasic(50) , environnement );
		this.portee=1000;

	}


	public boolean existsZombie(){
		ArrayList<Perso>  ligne = this.environnement.getLignePersos(this.getLigne());
		boolean exists = false ;
		int i =0;

		while(!exists && i<ligne.size()){
			if(ligne.get(i) instanceof Zombie)
				exists=true;
			i++;
		}

		return exists;

	}



	public void evolue(){

		if(this.environnement.getNbtour()%5==0){

			Perso p =  this.getObstacle();


			if((p.getX()+p.getLargeur())-(this.getX()+this.getLargeur())<=this.portee  && this.existsZombie()/*&& ((p.getX()+p.getLargeur())-(this.getX()+this.getLargeur())-this.portee)>(this.getLargeur()+p.getLargeur())*/){

				Projectile p1 = new Projectile(this.getLigne(), this.getX()+this.getLargeur()-28,this.environnement);
				this.environnement.getLignePersos(this.getLigne()).add(p1);
			}

		}

		//TODO supprimer les projectilles qui existent après la suppression du zombies 


	}

	@Override
	public boolean estObstaclePour(Perso p) {
		// TODO Auto-generated method stub
		return p instanceof Zombie;
	}



}