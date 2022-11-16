import java.util.ArrayDeque;
import java.util.ArrayList;


public class ConsigneFIFO{

	ArrayList<Casier> tousLesCasiers;
	ArrayDeque<Casier> casiersLibres;
	
	/**
	 * construit une consigne de gare avec tous les casiers libres au depart
	 * @param nombreCasiers le nombre de casier de la consigne
	 * @throws IllegalArgumentException si le nombre de casiers est negatif ou nul
	 */
	public ConsigneFIFO(int nombreCasiers) {
		if (nombreCasiers <= 0)
			throw new IllegalArgumentException();
		tousLesCasiers = new ArrayList<Casier>(nombreCasiers);
		casiersLibres = new ArrayDeque<Casier>(nombreCasiers);
		intialiserArrayList(nombreCasiers);
	}

	/**
	 * verifie la presence d'un casier libre
	 * @return true s'il reste au moins un casier de libre, false sinon
	 */
	public boolean resteUnCasierLibre() {
		return !casiersLibres.isEmpty();
	}

	/**
	 * attribue un casier libre
	 * @param motDePasse le mot de passe qui permettra de liberer le casier
	 * @return le numero du casier attribue ou -1 s'il n'y en a plus de libre
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public int attribuerCasierLibre(String motDePasse) {
		checkMotDePasse(motDePasse);
		if (!resteUnCasierLibre())
			return -1;
		Casier casierAAttribuer = casiersLibres.removeFirst();
		casierAAttribuer.setMotDePasse(motDePasse);
		return casierAAttribuer.getNumero();
	}
	
	/**
	 * libere un casier
	 * @param numeroCasier le numero de casier qui doit etre libere
	 * @param motDePasse le mot de passe a comparer avec le mot de passe du casier
	 * @return true si le numero de casier existe et le mot de passe est le bon, false sinon
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public boolean libererCasier(int numeroCasier, String motDePasse) {
		checkMotDePasse(motDePasse);
		if (numeroCasier >= 0 && numeroCasier < tousLesCasiers.size()) {
			Casier casierATraiter = tousLesCasiers.get(numeroCasier);
			if (casierATraiter.getMotDePasse().equals(motDePasse)) {
				casierATraiter.setMotDePasse("");
				casiersLibres.addLast(casierATraiter);
				return true;
			}
		}
		return false;
	}

	private void intialiserArrayList(int nombreCasiers) {
		for (int i = 0; i < nombreCasiers; i++) {
			Casier casier = new Casier(i);
			tousLesCasiers.add(casier);
			casiersLibres.addLast(casier);
		}
	}
	
	private void checkMotDePasse(String motDePasse) {
		if (motDePasse == null)
			throw new IllegalArgumentException("Mot de passe null.");
		if (motDePasse.equals(""))
			throw new IllegalArgumentException("Mot de passe vide.");
	}
}