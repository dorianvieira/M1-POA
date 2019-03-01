package model.declaration;

import model.exceptions.HeuresHebdoDepassees;

public interface EntrepriseItf {

	double salaireHebdo() throws HeuresHebdoDepassees;
    String getNom();
    double getSalaireBase();
    int getHeuresTravaillees();
}
