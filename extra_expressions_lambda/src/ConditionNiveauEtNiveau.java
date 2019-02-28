import java.util.ArrayList;

public class ConditionNiveauEtNiveau implements Condition {
	private ArrayList<Niveau> niveau = new ArrayList<>();

	public ConditionNiveauEtNiveau(ArrayList<Niveau> n) {
		niveau = n;
	}

	
	public boolean estValide(Cours c) {
		if (niveau.isEmpty()) {
			return false;
		}
		for (Niveau n : niveau) {
			if (!c.getNiveau().equals(niveau)) {
				return false;
			}

		}
		return true;
	}

}