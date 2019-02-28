public class Cours {

	private String intitule;
	private Niveau niveau;
	private Enseignant responsable;

	public Cours(String intitule, Enseignant responsable, Niveau niveau) {
		this.intitule = intitule;
		this.niveau = niveau;
		this.responsable = responsable;
	}

	public String getIntitule() {
		return intitule;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public Enseignant getResponsable() {
		return responsable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intitule == null) ? 0 : intitule.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cours other = (Cours) obj;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		if (niveau != other.niveau)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cours [intitule=" + intitule + ", niveau=" + niveau + ", responsable=" + responsable + "]";
	}

	public static int comparerParNiveauPuisNom(Cours c1, Cours c2) {
		if (c1.getNiveau().equals(c2.getNiveau())) {
			return c1.getIntitule().compareTo(c2.getIntitule());
		} else {
			return c1.getNiveau().compareTo(c2.getNiveau());
		}
	}
	
	public static int compareAlphabet(String o1, String o2) {
		return o1.compareTo(o2);
	    }
}
