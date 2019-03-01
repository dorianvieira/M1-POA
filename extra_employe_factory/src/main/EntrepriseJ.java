package main;

import java.util.logging.Logger;
import java.io.IOException;

import model.implementation.Employe;
import model.declaration.EntrepriseItf;
import model.factory.EmployeFactory;

import model.exceptions.SalaireHoraireInsuffisant;
import model.exceptions.HeuresHebdoDepassees;


public class EntrepriseJ {

	private static final Logger LOG = Logger.getLogger(EntrepriseJ.class.getCanonicalName());

	public static void main(String[] args){

		try{
			EmployeFactory ef = new EmployeFactory();
			Employe e1 = ef.createEmploye("John",7.5,35);
			Employe e2 = ef.createEmploye("Cécile",8.2,47);
			Employe e3 = ef.createEmploye("Pierre",14.5,46);
			Employe e4 = ef.createEmploye("Vijay",60.50,60);
			Employe e5 = ef.createEmploye("Laurent",10.00,73);

			e2.salaireHebdo();
			e3.salaireHebdo();
			e4.salaireHebdo();
			e5.salaireHebdo();

			System.out.println(e1.toString());
			System.out.println(e2);
			System.out.println(e3+", Le salaire est de : "+e3.salaireHebdo()+" euros !");
			System.out.println(e4+", Le salaire est de : "+e4.salaireHebdo()+" euros !");
			System.out.println(e5);

		}catch(HeuresHebdoDepassees ex){
			LOG.severe(ex.getMessage());
		}
	}
}	
