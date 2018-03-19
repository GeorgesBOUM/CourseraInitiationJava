import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;
							  
public class Decharge {
	private static DecimalFormat df = new DecimalFormat("#.000");
	
       /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
	// 1.2 calcul des distances entre deux points
	public static double calculerDistance(int x1, int y1, int x2, int y2)
	{
		double distance = 0.0, a = 0.0, b = 0.0;
		a = x1 - x2;
		b = y1 - y2;
		distance = (Math.sqrt(Math.pow(a, 2.0) + Math.pow(b, 2.0)));
		return distance;
	}
	
	// 1.3 habitation la plus proche
	public static int plusProche(int x, int y, int[] coordonneesHabitations)
	{
		int indiceProche = 0;
		double distanceProche = 0.0;
		double distance = 0.0;
		
		for (int i = 0; i < coordonneesHabitations.length - 1; i=i+2) {
			distance = calculerDistance(x, y, coordonneesHabitations[i], coordonneesHabitations[i+1]);
			if (distanceProche == 0.0) {
				distanceProche = distance;
				indiceProche = i/2;
			}
			if (distance < distanceProche) {
				distanceProche = distance;
				indiceProche = i/2;
			}
		}
		return indiceProche;
	}
	
	// 1.4 trois habitations les plus proches
	public static int[] troisPlusProches(int x, int y, int[] coordonneesHabitations)
	{
		int indiceProximité;
		int tableauTemporaire [] = new int[coordonneesHabitations.length];
		int tableDesPlusProches [] = new int [6];
		System.arraycopy(coordonneesHabitations, 0, tableauTemporaire, 0, coordonneesHabitations.length);
		 for (int i = 0; i < 3; i++) {
			indiceProximité = plusProche(x, y, tableauTemporaire);
			tableDesPlusProches[2*i] = tableauTemporaire[2*indiceProximité];
			tableDesPlusProches[2*i+1] = tableauTemporaire[2*indiceProximité+1];
			tableauTemporaire[2*indiceProximité] = 1000000; 
			tableauTemporaire[2*indiceProximité+1] = 1000000;
		}
		 return tableDesPlusProches;
	}
	
	//1.5 place optimale
	public static int[] meilleurePlace(int x, int y, int[] coordonneesHabitations) 
	{
		int centreDeGravite [] = {0,0};
		int troisProches [] = new int [6];
		troisProches = troisPlusProches(x, y, coordonneesHabitations);
		int i = 0, j = 1;
		while (i<=4) {
			centreDeGravite[0] = centreDeGravite[0] + troisProches[i];
			i=i+2;
		}
		while (j<=5) {
			centreDeGravite[1] = centreDeGravite[1] + troisProches[j];
			j=j+2;
		}
		centreDeGravite[0] = centreDeGravite[0] / 3;
		centreDeGravite[1] = centreDeGravite[1] / 3;
		return centreDeGravite;
	}

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

	public static void afficheTroisPlusProches(int x, int y, int[] coordonneesHabitations) {
		int[] tpp = troisPlusProches(x, y, coordonneesHabitations);
		
		System.out.println("(" + x + "," + y + ") est a :");
		for (int i = 0 ; i < 3 ; i++) {
			System.out.println("    " + df.format(calculerDistance(x, y, tpp[2*i], tpp[2*i+1])) + " de (" + tpp[2*i] + "," + tpp[2*i+1] + ")"); 
		}
	}
	
	

	//PROGRAMME PRINCIPAL
	public static void main(String args[]) {
		
		int[] coordonneesHabitations = {
				9, 30, 18, 8, 3, 18, 25, 36
		};
		
		// Lecture des donnees
		Scanner clavier = new Scanner(System.in);
		System.out.print("Entrez la coordonnee x de la decharge: ");
		int x = clavier.nextInt();
		System.out.print("Entrez le coordonnee y de la decharge: ");
		int y = clavier.nextInt();
		
		// trouve les coordonnees de l'habitation la plus proche
		// (identifiees par l'indice correspondant dans le tableau
		// de coordonnees)
		int plusProche = plusProche(x, y, coordonneesHabitations);
		System.out.println("--- Question 1 ---");
		System.out.println("Coordonnees de l'habitation la plus proche de la decharge :");
		System.out.println("(" + coordonneesHabitations[plusProche * 2] + "," + coordonneesHabitations[plusProche * 2 + 1] + ") ; distance = " +
						   df.format(calculerDistance(x, y, coordonneesHabitations[plusProche * 2], coordonneesHabitations[plusProche * 2 + 1]))  + " metres");	
			
		// trouve les coordonnees des 3 habitations les plus proches et affiche les coordonnees
		
		System.out.println("--- Question 2 ---");
		System.out.println("Coordonnees des 3 habitations les plus proches de la decharge :");
		afficheTroisPlusProches(x, y, coordonneesHabitations);
		
		// affiche le centre de gravite des 3 plus proches (la meilleure place)
		int[] grav = meilleurePlace(x, y, coordonneesHabitations);
		System.out.println("--- Question 3 ---");
		System.out.println("Coordonnees de la meilleure place pour la decharge :");
		System.out.println("(" + grav[0] + "," + grav[1] + ")");
		clavier.close();
	}

}
	
