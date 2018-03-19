import java.util.Scanner;

public class Crypto {

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static final int DECALAGE = 4;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Veuillez entrer une chaine de caracteres : ");
        String s = scanner.nextLine();

        // la chaine a coder
        String aCoder = "";
        // la chaine codee
        String chaineCodee = "";

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        
        int tailleS = s.length();
        int tailleaCoder = 0;
        char temp;
        int indice;
        for (int i=0; i<tailleS; ++i) {
        	int j=0;
        	boolean lettreTrouvee = false;
        	while ((j<26) && (lettreTrouvee==false) ) {
        		if ((s.charAt(i)==ALPHABET.charAt(j)) || (s.charAt(i)==' ')) {
        			aCoder=aCoder+s.charAt(i);
        			lettreTrouvee = true;
        		}
        		++j;
        	}
        }
        tailleaCoder = aCoder.length();
        for (int i=0; i<tailleaCoder; ++i) {
        	temp = aCoder.charAt(i);
        	indice = ALPHABET.indexOf(temp);
        	
        	if (temp ==' ') {
        		chaineCodee=chaineCodee+' ';
        	} else {
        		if (indice>21) {
            		indice = indice - 22 ;
            		chaineCodee=chaineCodee+ALPHABET.charAt(indice);
            	} else {
            		chaineCodee=chaineCodee+ALPHABET.charAt(indice+4);
            	}
        	}
        }

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        System.out.format("La chaine initiale etait : '%s'\n", s);

        if (aCoder.isEmpty()) {
            System.out.println("La chaine a coder est vide.\n");
        } else {
            System.out.format("La chaine a coder est : '%s'\n", aCoder);
            System.out.format("La chaine codee est : '%s'\n", chaineCodee);
        }
    }
}
