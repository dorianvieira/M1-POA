package model;

import java.util.ArrayList;

public class Environnement {

	private ArrayList<Soleil> lesSoleils;

	private int largeurJardin;

	private ArrayList<ArrayList<Perso>> lesPersos;

	private int lignesJardin;

	private int nbtour=0;

	public Environnement(int largeurJardin, int lignesJardin) {
		this.lignesJardin=lignesJardin;
		this.largeurJardin=largeurJardin;
		this.lesSoleils=new ArrayList<Soleil>();
		this.lesPersos=new ArrayList<ArrayList<Perso>>();
		for(int i =0; i<lignesJardin;i++){
			lesPersos.add(new ArrayList<Perso>());
		}
	}
	//Renvoie la largeur du jardin en pixel
	public int getLargeurJardin(){
		return largeurJardin;
	}

	public int nbreLigne(){
		return lignesJardin;
	}
	// Renvoi une l'ArrayList des personnages sur un ligne donnée en paramètre 
	public ArrayList<Perso> getLignePersos(int i){
		ArrayList<Perso> a = this.lesPersos.get(i);
		return a;
	}

	public ArrayList<Soleil> getSoleils(){
		return this.lesSoleils;
	}

	public void evolue(){
		for(int i=0;i<lesPersos.size();i++){
			for(int j=0;j<lesPersos.get(i).size();j++){
				if(lesPersos.get(i).get(j).getgVie().estMort()){
					lesPersos.get(i).remove(j);
				}
				else{
					lesPersos.get(i).get(j).evolue();
				}

			}
		}

	}

	public int getNbtour() {
		return nbtour;
	}

	public void setNbtour(int nbtour) {
		this.nbtour = nbtour;
	}

/*
	public int nbProjectile (){
		int cpt =0;
		for(ArrayList<Perso> ligne : this.lesPersos){
			for(Perso p: ligne){
				if(p instanceof Projectile)
					cpt++;
			}
		}

		return cpt ;

	}

*/
}

