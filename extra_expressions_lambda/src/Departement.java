import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Departement {

	private ArrayList<Enseignant> enseignants;
	private Set<Cours> cours;

	public Departement() {
		enseignants = new ArrayList<Enseignant>();
		cours = new HashSet<Cours>();
	}

	public int nbHeureCompAPayer() {
		int total = 0;
		for (Enseignant e : enseignants) {
			total = total + e.heureComp();
		}
		return total;
	}

	public int prixHcAPayer() {
		return nbHeureCompAPayer() * Enseignant.prixHc;
	}

	public void ajouter(Enseignant e) {
		enseignants.add(e);
	}

	public void ajouter(Cours c) {
		cours.add(c);
	}

	public Set<Cours> lesCoursDeMaster() {
		Set<Cours> coursDeMaster = new HashSet<Cours>();
		for (Cours c : cours) {
			if (c.getNiveau().equals(Niveau.M1) || c.getNiveau().equals(Niveau.M2)) {
				coursDeMaster.add(c);
			}
		}
		return coursDeMaster;
	}

	public Set<Cours> lesCoursDeEnseignant(String nom) {
		Set<Cours> coursDeEnseignant = new HashSet<Cours>();
		for (Cours c : cours) {
			if (c.getResponsable().getNom().equals(nom)) {
				coursDeEnseignant.add(c);
			}
		}
		return coursDeEnseignant;
	}

	public Set<String> lesNomsCoursDeEnseignant(String nom) {
		Set<String> nomsCoursDeEnseignant = new HashSet<String>();
		for (Cours c : lesCoursDeEnseignant(nom)) {
			nomsCoursDeEnseignant.add(c.getIntitule());
		}
		return nomsCoursDeEnseignant;
	}

	public int nbreCoursL2() {
		int i = 0;
		for (Cours c : cours) {
			if (c.getNiveau().equals(Niveau.L2)) {
				i++;
			}
		}
		return i;
	}

	public String lesIntitulesCoursL2() {
		String intitulesCoursL2 = "";
		for (Cours c : cours) {
			if (c.getNiveau().equals(Niveau.L2)) {
				intitulesCoursL2 += c.getIntitule() + " ,";
			}
		}
		return intitulesCoursL2;
	}

	public Set<String> lesIntitulesDeCours() {
		Set<String> intitulesCours = new HashSet<String>();
		for (Cours c : cours) {
			intitulesCours.add(c.getIntitule());
		}
		return intitulesCours;
	}

	public SortedSet<String> lesIntitulesDeCoursTrie() {
		SortedSet<String> intitulesCoursTrie = new TreeSet<String>((x1, x2) -> Cours.compareAlphabet(x1, x2));
		for (Cours c : cours) {
			intitulesCoursTrie.add(c.getIntitule());
		}
		return intitulesCoursTrie;
	}

	public SortedSet<Cours> lesCoursParNiveauPuisNom() {
		SortedSet<Cours> coursParNiveauPuisNom = new TreeSet<Cours>((x1, x2) -> Cours.comparerParNiveauPuisNom(x1, x2));
		for (Cours c : cours) {
			coursParNiveauPuisNom.add(c);
		}
		return coursParNiveauPuisNom;
	}

	public SortedSet<Enseignant> lesResponsablesL2NomPuisIdentifiant() {
		SortedSet<Enseignant> resp = new TreeSet<>((x1, x2) -> Enseignant.comparerParNomPuisIdentifiant(x1, x2));
		for (Cours c : cours) {
			if (c.getNiveau().equals(Niveau.L2)) {
				resp.add(c.getResponsable());
			}
		}
		return resp;
	}

	public int nbreResponsable() {
		Set<Enseignant> resp = new HashSet<Enseignant>();
		for (Cours c : cours) {
			resp.add(c.getResponsable());
		}
		return resp.size();
	}

	public Set<Enseignant> enseignantsSansHeuresCompTrieHeuresFaitesPuisNom() {
		Set<Enseignant> resp = new TreeSet<Enseignant>(
				(x1, x2) -> Enseignant.comparerSansHeuresCompTrieHeuresFaitesPuisNom(x1, x2));
		for (Enseignant e : enseignants) {
			if (e.heureComp() == 0) {
				resp.add(e);
			}
		}
		return resp;
	}

	public void mettreAJourHeuresEffectuees() {
		for (Enseignant e : this.enseignants) {
			mettreAJour(e);
		}
	}

	public void mettreAJour(Enseignant e) {
		Scanner sc = new Scanner(System.in);
		System.out.println("entrer les heures effectuées depuis la dernière saisie pour  " + e.getNom());
		try {
			e.ajoutHeure(sc.nextInt());
			;

		} catch (InputMismatchException | NombreIncorrect ee) {
			System.out.println("veuillez entrer un nombre positif");
			mettreAJour(e);
		}
	}

	@Override
	public String toString() {
		return (enseignants.toString());
	}

	public Enseignant getEnseignant(int i) {
		return enseignants.get(i);
	}

	public ArrayList<String> NomsEnseignants() {
		ArrayList<String> lesNoms = new ArrayList<String>();
		for (Enseignant e : enseignants) {
			lesNoms.add(e.getNom());
		}
		return lesNoms;
	}

	public ArrayList<Enseignant> enseignantsSansHeuresComp() {
		ArrayList<Enseignant> lesEns = new ArrayList<Enseignant>();
		for (Enseignant e : enseignants) {
			if (e.heureComp() == 0)
				lesEns.add(e);
		}
		return lesEns;
	}

	public boolean existeEnseignantHeuresCompSuperieurA(int n) {
		for (Enseignant e : enseignants) {
			if (e.heureComp() > n)
				return true;
		}
		return false;
	}

	public String EnseignantMaxHeureComp() throws Exception {
		if (enseignants.size() == 0)
			throw new Exception("la liste est vide");
		Enseignant ensMax = enseignants.get(0);
		for (Enseignant e : enseignants) {
			if (e.getHeuresEffectuees() > ensMax.getHeuresEffectuees()) {
				ensMax = e;
			}
		}
		return ensMax.getNom();
	}

	public ArrayList<Cours> cherche(Cours cond) {
		ArrayList<Cours> cour = new ArrayList<Cours>();
		for (Cours c : cours) {
			if (((Condition) cond).estValide(c)) {
				cour.add(c);
			}
		}
		return cour;
	}

	public ArrayList<Cours> selectionnerCours(Predicate<Cours> a) {
		ArrayList<Cours> cour = new ArrayList<Cours>();
		for (Cours c : cours) {
			if (((Condition) a).estValide(c)) {
				cour.add(c);
			}
		}
		return cour;
	}

	public ArrayList<Cours> lesCoursDe(Enseignant e) {
		return selectionnerCours(x -> x.getResponsable().equals(e));
	}

}
