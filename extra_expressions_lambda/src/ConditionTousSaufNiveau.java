public class ConditionTousSaufNiveau implements Condition {
	private Niveau niveau;

	public ConditionTousSaufNiveau(Niveau n) {
		this.niveau = n;
	}

	@Override
	public boolean estValide(Cours c) {
		return !(c.getNiveau().equals(niveau));
	}

}