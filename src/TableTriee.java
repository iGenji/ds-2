
public class TableTriee {


	private int[] table;  
	private int compteurGetEntier = 0;

	public TableTriee(int[] tableARecopier){
		if(tableARecopier==null)
			throw new IllegalArgumentException("table null");
		table= new int[tableARecopier.length];
		if (tableARecopier.length!=0){
			table[0]=tableARecopier[0];
		}
		for(int i = 1; i<table.length; i++){
			table[i] = tableARecopier[i];
			if(table[i]<table[i-1])
				throw new IllegalArgumentException("table non triee");
		}     	
	}
	
	private int getCompteurGetEntier() {
		return compteurGetEntier;
	}

	private void setCompteurGetEntier(int compteurGetEntier) {
		this.compteurGetEntier = compteurGetEntier;
	}

	private int getEntier(int i){		
		this.compteurGetEntier++;
		return this.table[i];
	}

	private int trouverIndiceLineaire(int entierRecherche){
		for(int i = 0; i < this.table.length; i++){
			int entierCompare = this.getEntier(i);
			if(entierCompare == entierRecherche)
				return i;
			if(entierCompare>entierRecherche)
				return -1;
		}
		return -1;
	}

	private int trouverIndiceDichotomique(int entierRecherche){
		if(this.table.length==0)return -1;
		int a = 0;
		int b = this.table.length-1;
		int milieu;
		while(a<b){
			milieu = (a+b)/2;
			int entierCompare = this.getEntier(milieu);
			if(entierCompare == entierRecherche)
				return milieu;
			if(entierRecherche>entierCompare)
				a=milieu+1;
			else b = milieu;
		}
		return -1;
	}
	
	public boolean estPresent(int entierRecherche){
		return trouverIndiceDichotomique(entierRecherche)!=-1;
	}
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("*******************************************");
		System.out.println("Recherche lineaire - Recherche dicho - Cout");
		System.out.println("*******************************************");
		System.out.print("Entrez le nombre d'entiers dans la table : ");
		int n = scanner.nextInt();
		int[] tableARecopier = new int[n];
		for (int i = 0; i < tableARecopier.length; i++) {
			tableARecopier[i]=i;
		}
		TableTriee tableTestee = new TableTriee(tableARecopier);
		System.out.println("Recherche d'un entier non present dans la table");
		int entierRecherche = n;
		
		System.out.print("Coût recherche lineaire : ");
		tableTestee.setCompteurGetEntier(0);
		tableTestee.trouverIndiceLineaire(entierRecherche);
		System.out.println(tableTestee.getCompteurGetEntier());
		
		System.out.print("Coût recherche dicho : ");
		tableTestee.setCompteurGetEntier(0);
		tableTestee.trouverIndiceDichotomique(entierRecherche);
		System.out.println(tableTestee.getCompteurGetEntier());
	}
}

