public class FileImpl<E> implements File<E>{

	Object[] table; 					// ne modifiez pas cet identifiant, va servir pour la classe test
	int tete;  // indice de tete		// ne modifiez pas cet identifiant, va servir pour la classe test
	int taille;

	public FileImpl(){
		table = new Object[4];
		taille = 0;
	}

   /**
    * verifie si la file est vide
    * @return true si la file est vide, false sinon
    */
   public boolean estVide(){
	   return taille == 0;
   }

   /**
    * renvoie le nombre d'elements qui se trouvent dans la file
    * @return nombre d'elements
    */
   public int taille(){
	   return taille;
   }
       
   /**
	 * ajoute un element en fin de file (queue)
	 * @param element l'element a ajouter
	 */	
	public void enfile(E element) {
		if (element == null)
			throw new IllegalArgumentException();
		if (taille == table.length) {
			doubleTaille();
		}
		table[(taille + tete) % table.length] = element;
		taille++;
	}

   /**
    * renvoie l'element qui se trouve en tete de file et l'enleve de la file
    * @return l'element en tete
    * @throws FileVideException si la file est vide
    */
   public E defile() throws FileVideException{
	   if (estVide())
		   throw new FileVideException();
	   E elem = premier();
	   tete++;
	   if (tete == table.length) {
		   tete = 0;
	   }
	   taille--;
	   return elem;
   }

   /**
    * renvoie l'element qui se trouve en tete de file sans l'enlever de la file
    * @return l'element en tete
    * @throws FileVideException si la file est vide
    */
   public E premier()throws FileVideException{
	   if (estVide())
		   throw new FileVideException();
	   return (E)table[tete];
   } 	
   
	private void doubleTaille() {
		Object[] temp = new Object[table.length * 2];
		int j = 0;
		for (int i = tete; i < table.length; i++, j++) {
			temp[j] = table[i];
		}
		for (int i = 0; i < tete; i++, j++) {
			temp[j] = table[i];
		}
		tete = 0;
		table = temp;
	}
} 
