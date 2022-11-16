public class  FileAttenteImpression{

	// Une file avec les demandes d'impression
	private FileImpl<DemandeImpression> fileDemandesImpression;
	
	/**
	 * construit une file vide
	 */
	public FileAttenteImpression() {
		fileDemandesImpression = new FileImpl<DemandeImpression>();
	}
	
	/**
	 * verifie si la file est vide
	 * @return true si la file est vide, false sinon
	 */
	public boolean estVide(){
		return fileDemandesImpression.estVide();
	}
	
	/**
	 * ajoute la demande d impression en fin de file
	 * @param demande la demande a ajouter
	 * @throws IllegalArgumentException si la demande est null
	 */
	public void ajouter(DemandeImpression demande) {
		if (demande == null)
			throw new IllegalArgumentException();
		fileDemandesImpression.enfile(demande);
	}
	
	/**
	 * retire l'impression en tete de file
	 * @return l'impression qui a ete retiree
	 * @throws FileVideException si aucune demande d impression dans la file
	 */
	public DemandeImpression retirer() throws FileVideException {
		if (estVide())
			throw new FileVideException();
		return fileDemandesImpression.defile();
	}
}
