import java.util.Scanner;

public class Velo {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.print("Donnez l'heure de début de la location (un entier) : ");
        int debut = clavier.nextInt();
        System.out.print("Donnez l'heure de fin de la location (un entier) : ");
        int fin = clavier.nextInt();

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        
        if ((debut<0) || (debut>24) || (fin<0) || (fin>24)) {
        	 System.out.println("Les heures doivent être comprises entre 0 et 24 !");
        } else {
        	if (debut==fin) {
        		 System.out.println("Bizarre, vous n'avez pas loué votre vélo bien longtemps !");
        	} else {
        		if (debut>fin) {
        			System.out.println("Bizarre, le début de la location est après la fin ...");
        		} else {
        			int temps1=0;
        			int temps2=0;
        			double prix=0.0;
        			System.out.println("Vous avez loué votre vélo pendant");
        			if ((fin<=7) || (debut>=17)) {
        				temps1=fin-debut;
        				System.out.println(temps1 + " heure(s) au tarif horaire de 1.0 franc(s)");
        				prix=temps1;
        				System.out.print("Le montant total à payer est de " +prix);
        		        System.out.println(" franc(s).");
        			} else {
        				if (debut>=7 && fin<=17) {
        					temps2=fin-debut;
        					System.out.println(temps2 + " heure(s) au tarif horaire de 2.0 franc(s)");
        					prix=temps2*2;
        					System.out.print("Le montant total à payer est de " +prix);
            		        System.out.println(" franc(s).");
        				} else {
        					if (debut<7 && fin>17) {
        						temps1 = fin-debut-10;
        						temps2=10;
        						prix=temps1+temps2*2;
        						System.out.println(temps1 + " heure(s) au tarif horaire de 1.0 franc(s)");
        						System.out.println(temps2 + " heure(s) au tarif horaire de 2.0 franc(s)");
        						System.out.print("Le montant total à payer est de " +prix);
                		        System.out.println(" franc(s).");
        					} else {
        						if (debut<7 && fin<=17) {
        							temps1=7-debut;
        							temps2=fin-7;
        							prix=temps1+temps2*2;
            						System.out.println(temps1 + " heure(s) au tarif horaire de 1.0 franc(s)");
            						System.out.println(temps2 + " heure(s) au tarif horaire de 2.0 franc(s)");
            						System.out.print("Le montant total à payer est de " +prix);
                    		        System.out.println(" franc(s).");
        						} else {
        							if (debut>=7 && fin>17) {
        								temps1=fin-17;
        								temps2=17-debut;
        								prix=temps1+temps2*2;
                						System.out.println(temps1 + " heure(s) au tarif horaire de 1.0 franc(s)");
                						System.out.println(temps2 + " heure(s) au tarif horaire de 2.0 franc(s)");
                						System.out.print("Le montant total à payer est de " +prix);
                        		        System.out.println(" franc(s).");
        							}
        						}
        					}
        				}
        			}
        		}
        	}
        }


        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

        clavier.close();
    }
}
