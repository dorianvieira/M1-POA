package model.factory;

import model.declaration.EntrepriseItf;
import model.implementation.Employe;

public class EmployeFactory
{
	//creation constructeur de l'employé
	public Employe createEmploye(String nom, double salaireHoraire, int heuresTravailles){
			return new Employe(nom,salaireHoraire,heuresTravailles);
	}
}
