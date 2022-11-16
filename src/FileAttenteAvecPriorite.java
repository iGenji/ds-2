public class FileAttenteAvecPriorite{
	
	private static final int NB_FILES_ATTENTE = 10;
	FileAttenteImpression[] tableAttente;
	
	/**
	 * construit une table avec 10 fileAttenteImpression
	 */
	public FileAttenteAvecPriorite() {
		tableAttente = new FileAttenteImpression[NB_FILES_ATTENTE];
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
	public void ajouter(DemandeImpressionAvecPriorite demande) {
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
		for (int i = NB_FILES_ATTENTE - 1; i >= 0; i--) {
			FileAttenteImpression fileATraiter = tableAttente[i];
			if (!fileATraiter.estVide()) {
				return (DemandeImpressionAvecPriorite) fileATraiter.retirer();
			}
		}
		throw new FileVideException();
	}	
}


