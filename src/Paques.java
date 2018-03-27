import java.util.Scanner;

public class Paques {
	private final static Scanner CLAVIER = new Scanner(System.in);
	
	/*
	 *Programme principal 
	 */
	public static void main(String[] args) {
		int anneeChoisie, jourDePaques;
		anneeChoisie = demanderAnnee();
		jourDePaques = datePaques(anneeChoisie);
		afficheDate(anneeChoisie, jourDePaques);
		CLAVIER.close();
	}
	
	/*
	 *une méthode statique demanderAnnee qui ne prend pas d’argument et retourne un entier ;
	 */
	
	public static int demanderAnnee() {
		int annee;
		do {
			System.out.println("Entrez une annee (1583-4000) :");
			annee = CLAVIER.nextInt();
		} while ((annee < 1583) || (annee > 4000)) ;
		return annee;
	}
	
	/*
	 * une  méthode  statique afficheDate qui  prend  deux  entiers  en  paramètres : 
	 * une année et un nombre de jours compris entre 22 et 56
	 */
	
	public static void afficheDate(int annee, int nombreJours) {
		System.out.print("Date de Paques en " + annee + " : ");
		if (nombreJours <= 31) {
			System.out.println(nombreJours + " mars");
		}
		if (nombreJours >= 32) {
			nombreJours = nombreJours - 31;
			System.out.println(nombreJours + " avril");
		}
	}
	
	/*
	 * une méthode statique datePaques qui reçoit une année en paramètre
	 * (nombre entier) et retourne un entier entre 22 et 56 indiquant le jour suivant
	 * la convention appliquée dans la méthode afficheDate ; 
	 */
	
	public static int datePaques(int annee) {
		int nombreDeJours;
		int siecle, p, q, m, n, d, e;
		siecle = (annee / 100);
		p = (8*siecle + 13)/25;
		q = siecle/4;
		m = (15 - p + siecle - q) % 30;
		n = (4 + siecle - q) % 7;
		d = (m + 19 * (annee % 19)) % 30;
		e = (2 * (annee % 4) + 4 * (annee % 7) + 6 * d + n) % 7;
		nombreDeJours = e + d + 22;
		if (e==6) {
			if ((d==29) || (d==28)) {
				if (((11*(m+1))%30)<19) {
					nombreDeJours = nombreDeJours - 7;
				}
			}
		}
		return nombreDeJours;
	}
}
