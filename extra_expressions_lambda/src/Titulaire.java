/**
 * @author mariannesimonot
 */
public abstract class Titulaire extends Enseignant {

    public Titulaire(String nom) {
	super(nom);
    }

    @Override
    public int heureComp() {
	int nh = this.getHeuresEffectuees() - getServiceStatutaire();
	if (nh > 0) {
	    return nh;
	} else {
	    return 0;
	}
    }

    // plutot que cette methode abstraite, on peut avoir un attribut
    // serviceStatutaire.
    // En ce cas, le constructeur des sous classes fixerait la valeur de cet
    // attribut.
    abstract public int getServiceStatutaire();

}
