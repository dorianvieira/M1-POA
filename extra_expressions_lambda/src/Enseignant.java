/**
 * @author mariannesimonot
 */
public abstract class Enseignant {
	public static int compteur = 0;
	public int identifiant;
	public final static int prixHc = 40;
	private int heuresEffectuees;
	private String nom;

	public Enseignant(String nom) {
		this.nom = nom;
		this.heuresEffectuees = 0;
		this.identifiant = compteur;
		compteur++;
	}

	public String getNom() {
		return nom;
	}

	public void ajoutHeure(int n) throws NombreIncorrect {
		if (n < 0) {
			throw new NombreIncorrect();
		} else
			heuresEffectuees = heuresEffectuees + n;
	}

	abstract public int heureComp();

	public int retributionHc() {
		return this.heureComp() * Enseignant.prixHc;
	}

	public int getHeuresEffectuees() {
		return heuresEffectuees;
	}

	@Override
	public String toString() {
		return ("nom: " + nom + "heuresFaites : " + heuresEffectuees + "heureComp :" + this.heureComp());
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public static int comparerParNomPuisIdentifiant(Enseignant e1, Enseignant e2) {
		if (e1.getNom().equals(e2.getNom())) {
			return e1.getIdentifiant() - e2.getIdentifiant();
		} else {
			return e1.getNom().compareTo(e2.getNom());
		}
	}

	public static int comparerSansHeuresCompTrieHeuresFaitesPuisNom(Enseignant e1, Enseignant e2) {
		if (e1.getHeuresEffectuees() == e2.getHeuresEffectuees()) {
			if (e1.getNom().compareTo(e2.getNom()) == 0) {
				return 1;
			} else
				return e1.getNom().compareTo(e2.getNom());
		} else
			return e1.getHeuresEffectuees() - e2.getHeuresEffectuees();
	}
	


}
