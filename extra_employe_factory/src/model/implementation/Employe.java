package model.implementation;

import java.util.logging.Logger;
import java.lang.String;

import model.declaration.EntrepriseItf;
import model.exceptions.SalaireHoraireInsuffisant;
import model.exceptions.HeuresHebdoDepassees;


public class Employe implements EntrepriseItf{ //entreprise est l'interface qui contient les methodes
	private static final Logger LOG = Logger.getLogger(Employe.class.getCanonicalName());
	
	private String nom;
	private double salaireHoraire;
	private int heuresTravaillees;
	
	public Employe(String nom, double salaire, int nbH){
			this.nom=nom;
			
			try{//L'heure de base ne doit pas ^etre en dessous de 13 euros. Sinon, lapplication affiche une erreur
			if (salaireHoraire<13.0d) {
				throw new SalaireHoraireInsuffisant("Le salaire horaire de base est insuffisant, il est actuellement de "+salaireHoraire+" euros");
			}else{
				this.salaireHoraire=salaireHoraire;
			}
		}catch(SalaireHoraireInsuffisant ex){
			LOG.severe("L'heure de base ne doit pas etre inferieur à 13 euros.");
		}

		try{//Si le nombre d'heures travaillees hebdomadaires déepasse 60, l'application affche une erreur.
			if (heuresTravaillees>60) {
				throw new HeuresHebdoDepassees("Heures de travail dépassées de "+(60-heuresTravaillees)+" heures");
			}else{
				this.heuresTravaillees=heuresTravaillees;
			}
		}catch(HeuresHebdoDepassees ex){
			LOG.severe("Il n'est pas possible de travailler plus de 60 heures");
		}
	}
	
	@Override
	public double salaireHebdo() throws HeuresHebdoDepassees{
		try{
			if (heuresTravaillees>60) {
				throw new HeuresHebdoDepassees("Heures de travailles dépasses de "+(60-heuresTravaillees)+" heures");
			}else if(heuresTravaillees>40){
				return ((1.5*salaireHoraire)*(double)heuresTravaillees);//convertie en double les h travaillees
			}
			else{
				return ((double)heuresTravaillees*salaireHoraire);
			}
		}catch(HeuresHebdoDepassees ex){
			LOG.severe("Il n'est pas possible de travailler plus de 60 heures");
		}
		return 0.0d;
	}
	
	public String getNom(){
    	return this.nom;
    }

    public double getSalaireBase(){
    	return salaireHoraire;
    }

    public int getHeuresTravaillees(){
    	return heuresTravaillees;
    }

	
	public String toString(){
		 StringBuilder sb = new StringBuilder();
		sb.append(this.nom).append(",").append("salaire horaire : ")
		.append(salaireHoraire).append("euros; heures travaillées :")
		.append(getHeuresTravaillees()).append("\n");
   
		 return sb.toString();
	}
	

}
