import java.lang.reflect.Field;
import java.util.Scanner;

public class TestFile{
	private static Scanner scanner = new Scanner(System.in);
	static Class classe = FileImpl.class;
	static Field t ;
	public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {	
		System.out.println("**************************************");
		System.out.println("Programme Test pour la classe FileImpl");
		System.out.println("implementation via une table circulaire");
		System.out.println("**************************************");
		t = classe.getDeclaredField("table");
		t.setAccessible(true);
		Character c;
		Character[] table;
		FileImpl<Character> file = new FileImpl<Character>();

		// test 1
		try {
			c =  file.defile();
			System.out.println("test 1 KO : Il fallait une exception");
			return;
			

			
		} catch (FileVideException e) {
			
		}
		System.out.println("test 1 OK");

		// test 2
		try {
			c = file.premier();
			System.out.println("test 2 KO : Il fallait une exception");
			return;
			
		} catch (FileVideException e) {
			
		}
		System.out.println("test 2 OK");

		// test 3
		file.enfile('a');
		if(file.taille()!=1){
			System.out.println("test 3 KO : taille KO");
			return;
		}
		table=objectsToCharacters((Object[])t.get(file));
		if (table.length != 4){ 
			System.out.println("Vous avez change la taille physique de depart de la table! Remettez-la a 4");
			return;
		} 
		if(table[0]!='a'){
			System.out.println("test 3 KO : contenu KO");
			return;
		}
		System.out.println("test 3 OK");


		// test 4
		file.enfile('b');
		if(file.taille()!=2){
				System.out.println("test 4 KO taille KO");
				return;
		}
		table=objectsToCharacters((Object[])t.get(file));
		
		if(table[0]!='a'){
			System.out.println("test 4 KO : contenu KO");
			return;
		}	
		
		if(table[1]!='b'){
			System.out.println("test 4 KO : contenu KO");
			return;
		}
		System.out.println("test 4 OK");


		// test 5
		try {
			c = file.premier();
			if(c != 'a') {
				System.out.println("test 5 KO : tete KO");
				return;
			}
			if(file.taille()!=2){
				System.out.println("test 5 KO : taille KO");
				return;
			}
			table=objectsToCharacters((Object[])t.get(file));
			if(table[0]!='a'){
				System.out.println("test 5 KO : contenu KO");
				return;
			}
			if(table[1]!='b'){
				System.out.println("test 5 KO : contenu KO");
				return;
			}
			
				
		
			
		} catch (FileVideException e) {
			System.out.println("test 5 KO : Il ne fallait pas d'exception");
			return;
		}
		System.out.println("test 5 OK");


		// test 6

		try {
			c = file.defile();
			if(c != 'a') {
				System.out.println("test 6 KO tete KO");
				return;
			}
			if(file.taille()!=1){
				System.out.println("test 6 KO taille KO");
				return;
			}
			table=objectsToCharacters((Object[])t.get(file));
			if(table[1]!='b'){
				System.out.println("test 5 KO : contenu KO");
				return;
			}
							
		} catch (FileVideException e) {
			System.out.println("test 6 KO : Il ne fallait pas d'exception");
			return;
		}
		System.out.println("test 6 OK");

		// test 7
		try {
			c = file.defile();
			if(c != 'b') {
				System.out.println("test 7 : KO tete KO");
				return;
			}
			if(file.taille()!=0){
				System.out.println("test 7 KO : taille KO");
				return;
			}
						
		} catch (FileVideException e) {
			System.out.println("test 7 KO : Il ne fallait pas d'exception");
			return;
		}
		System.out.println("test 7 OK");

			
		// test 8
		try {
			c = file.defile();
			
			System.out.println("test 8 KO : il fallait une exception");
				return;
			
			
		} catch (FileVideException e) {
			if(file.taille()!=0){
				System.out.println("test 8 KO : taille KO");
				return;
			}
		}
		System.out.println("test 8 OK");

		// test 9
		file.enfile('c');
		file.enfile('d');
		file.enfile('e');
		file.enfile('f');

		if(file.taille()!=4){
			System.out.println("test 9 KO : taille KO");
			return;
		}
		table=objectsToCharacters((Object[])t.get(file));
		if (table[0]!='e'||table[1]!='f'||table[2]!='c'||table[3]!='d'){
			System.out.println("le contenu de la table est KO");
			return;
		}
		
		System.out.println("test 9 OK");

		// test 10
		try {
			c = file.defile();
			if(c != 'c') {
				System.out.println("test 10 : KO tete KO");
				return;
			}
			c = file.defile();
			if(c != 'd') {
				System.out.println("test 10 : KO tete KO");
				return;
			}
			c = file.defile();
			if(c != 'e') {
				System.out.println("test 10 : KO tete KO");
				return;
			}
			if(file.taille()!=1){
				System.out.println("test 10 KO : taille KO");
				return;
			}
			
		} catch (FileVideException e) {
			System.out.println("test 10 KO : Il ne fallait pas d'exception");
			return;
		}
		System.out.println("test 10 OK");
		


		// test 11
		file.enfile('g');
		file.enfile('h');
		file.enfile('i');
		file.enfile('j');

		if(file.taille()!=5){
			System.out.println("test 11 KO : taille KO");
			return;
		}
		table=objectsToCharacters((Object[])t.get(file));
		
		if (table[0]!='f'||table[1]!='g'||table[2]!='h'||table[3]!='i'||table[4]!='j'){
			System.out.println("le contenu de la table est KO");
			System.out.println("Votre table contient : ");
			System.out.println(" "+table[0]+" "+table[1]+" "+table[2]+" "+table[3]+" "+table[4]);
			System.out.println("Elle devrait contenir : f g h i j");
			return;
		
		}
		System.out.println("test 11 OK");
	}
	
	private static Character[] objectsToCharacters(Object[] oTable) {
		Character[] table=new Character[oTable.length];
		for(int i=0; i<oTable.length; i++) {
			if (oTable[i]!=null)
				table[i]=(Character)oTable[i];
		}
		return table;
	}
}








