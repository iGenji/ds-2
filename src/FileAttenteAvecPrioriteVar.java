public class FileAttenteAvecPrioriteVar{
	
	private static final int NB_FILES_ATTENTE = 10;
	private static final int TOURS_MAX = 3;
	FileAttenteImpression[] tableAttente;
	int[] nbToursCedes;

	/**
	 * construit une table avec 10 fileAttenteImpression
	 */
	public FileAttenteAvecPrioriteVar() {
		tableAttente = new FileAttenteImpression[NB_FILES_ATTENTE];
		nbToursCedes = new int[NB_FILES_ATTENTE];
		for (int i = 0; i < NB_FILES_ATTENTE; i++) {
			tableAttente[i] = new FileAttenteImpression();
		}
	}

	/**
	 * verifie si toutes les files sont vides
	 * @return true si toutes les files sont vides, false sinon
	 */
	public boolean estVide() {
		for (FileAttenteImpression f : tableAttente) {
			if (!f.estVide())
				return false;
		}
		return true;
	}

	/**
	 * ajoute la demande d impression en fin de la file de priorite correspondante
	 * @param demande la demande a ajouter
	 * @throws IllegalArgumentException si la demande est null
	 */
	public void ajouter(DemandeImpressionAvecPriorite demande){
		if (demande == null)
			throw new IllegalArgumentException();
		tableAttente[demande.getPriorite()].ajouter(demande);
	}

	/**
	 * retire l'impression en tete de file de priorite la plus haute qui est non vide
	 * @return l'impression qui a ete retiree
	 * @throws FileVideException si aucune demande d impression dans la file
	 */
	public DemandeImpressionAvecPriorite retirer() throws FileVideException {
		DemandeImpressionAvecPriorite demandeARenvoyer = null;
		int i = NB_FILES_ATTENTE - 1;
		while (i >= 0 && tableAttente[i].estVide()){
			i--;
		}
		if (i < 0) throw new FileVideException();
		demandeARenvoyer = (DemandeImpressionAvecPriorite) tableAttente[i].retirer();
		incrementerPriorites(i - 1);
		return demandeARenvoyer;
	}

	private void incrementerPriorites(int prioriteMaxCedee) {
		for (int i = prioriteMaxCedee; i >= 0; i--) {
			if (!tableAttente[i].estVide()) {
				if (nbToursCedes[i] == TOURS_MAX) {
					nbToursCedes[i] = 0;
					DemandeImpressionAvecPriorite demandeATransferer = (DemandeImpressionAvecPriorite) tableAttente[i].retirer();
					demandeATransferer.setPriorite(i + 1);
					tableAttente[i + 1].ajouter(demandeATransferer);
				} else 
					nbToursCedes[i]++;
			}
		}
	}
}