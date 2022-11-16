public class TestFileAttenteAvecPrioriteVar {
	public static void main(String[] args) {
		FileAttenteAvecPrioriteVar file = new FileAttenteAvecPrioriteVar();
		DemandeImpressionAvecPriorite demande;
		try{
		System.out.println("ajout dans une file vide des documents suivants (dans cet ordre!)");
		System.out.println("doc1 - 8");
		file.ajouter(new DemandeImpressionAvecPriorite("doc1",8));
		System.out.println("doc2 - 9");
		file.ajouter(new DemandeImpressionAvecPriorite("doc2",9));
		System.out.println("doc3 - 9");
		file.ajouter(new DemandeImpressionAvecPriorite("doc3",9));
		System.out.println("doc4 - 9");
		file.ajouter(new DemandeImpressionAvecPriorite("doc4",9));
		
		System.out.println("retrait d'1 document!");
		demande = file.retirer();
		if(!demande.getNomDocument().equals("doc2")){
			System.out.println("Attention le document retire est " + demande);
			System.out.println("C'est le document doc2 qui aurait du etre retire!");
			return;
		}
		System.out.println("retrait d'1 document!");
		demande = file.retirer();
		if(!demande.getNomDocument().equals("doc3")){
			System.out.println("Attention le document retire est " + demande);
			System.out.println("C'est le document doc3 qui aurait du etre retire!");
			return;
		}	
		System.out.println("retrait d'1 document!");
		demande = file.retirer();
		if(!demande.getNomDocument().equals("doc4")){
			System.out.println("Attention le document retire est " + demande);
			System.out.println("C'est le document doc4 qui aurait du etre retire!");
			return;
		}
		System.out.println("ajout dans une file vide des documents suivants (dans cet ordre!)");
		System.out.println("doc5 - 8");
		file.ajouter(new DemandeImpressionAvecPriorite("doc5",8));
		System.out.println("doc6- 9");
		file.ajouter(new DemandeImpressionAvecPriorite("doc6",9));
	
		System.out.println("retrait d'1 document!");
	
		demande = file.retirer();
		if(!demande.getNomDocument().equals("doc6")){
			System.out.println("Attention le document retire est " + demande);
			System.out.println("C'est le document doc6 qui aurait du etre retire!");
			return;
		}
		
		System.out.println("doc6bis- 9");
		file.ajouter(new DemandeImpressionAvecPriorite("doc6bis",9));
		
		System.out.println("retrait d'1 document!");		
		demande = file.retirer();
		if(!demande.getNomDocument().equals("doc1")){
			System.out.println("Attention le document retire est " + demande);
			System.out.println("C'est le document doc1 qui aurait du etre retire!");
			return;
		}
		
		System.out.println("retrait d'1 document!");		
		demande = file.retirer();
		if(!demande.getNomDocument().equals("doc6bis")){
			System.out.println("Attention le document retire est " + demande);
			System.out.println("C'est le document doc6bis qui aurait du etre retire!");
			return;
		}
		
		
		System.out.println("ajout dans une file vide du document suivant");
		System.out.println("doc7 - 9");
		file.ajouter(new DemandeImpressionAvecPriorite("doc7",9));
		
		System.out.println("retrait d'1 document!");
		demande = file.retirer();
		if(!demande.getNomDocument().equals("doc7")){
			System.out.println("Attention le document retire est " + demande);
			System.out.println("C'est le document doc7 qui aurait du etre retire!");
			return;
		}
		}catch (FileVideException e){
			System.out.println("Attention FileVideException"+e.getMessage());
		}
		
		System.out.println("Tous les tests sont OK!");

	}	
}


