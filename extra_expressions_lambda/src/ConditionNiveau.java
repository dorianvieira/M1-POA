public class ConditionNiveau implements Condition {
	private Niveau niveau;

	public ConditionNiveau(Niveau n) {
		this.niveau = n;
	}

	
	public boolean estValide(Cours c) {
		return (c.getNiveau().equals(niveau));
	}

}