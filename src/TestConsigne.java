public class TestConsigne {

	public static void main(String[] args) {

		ConsigneLIFO consigne = new ConsigneLIFO(3);

		System.out.println("test 1 : 3 casiers de libre");
		System.out.println("casiers libres? "+consigne.resteUnCasierLibre()); 

		System.out.println("test 2 : 4 attributions");
		System.out.println("consigne.attribuerCasier(mdp1) "+consigne.attribuerCasierLibre("mdp1"));
		System.out.println("consigne.attribuerCasier(mdp2) "+consigne.attribuerCasierLibre("mdp2"));
		System.out.println("consigne.attribuerCasier(mdp3) "+consigne.attribuerCasierLibre("mdp3"));
		System.out.println("casiers libres? "+consigne.resteUnCasierLibre()); 
		System.out.println("consigne.attribuerCasier(mdp4)"+consigne.attribuerCasierLibre("mdp4"));

		System.out.println("test 3 : ouverture mauvais numeros de casier");
		System.out.println("consigne.ouvrirCasier(-1, blabla) "+consigne.libererCasier(-1, "blabla"));
		System.out.println("consigne.ouvrirCasier(3, blabla) "+consigne.libererCasier(3, "blabla"));
		System.out.println("consigne.ouvrirCasier(4, blabla) "+consigne.libererCasier(4, "blabla"));
		
		System.out.println("Le jeu de tests doit etre complete!!!");
		
		//TEST4 : ouvrir un casier : mot de passe OK

		//TEST5 : ouvrir un casier : mot de passe KO

		//TEST6 : ouvrir le casier qui vient d'etre libere avec mot de passe OK - 
		
		
		

		// A COMPLETER A VOTRE GUISE


	}

}
