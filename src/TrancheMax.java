import java.util.ArrayList;
import java.util.Scanner;

class TrancheMax {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        // Entree de la matrice
        System.out.println("Saisie de la matrice :");
        String matrice = clavier.nextLine();
        System.out.format("Matrice saisie :\n%s\n", matrice);
        clavier.close();

        // Validation de la matrice
        if (!checkFormat(matrice)) {
            return;
        }

        // Trouver la liste des lignes avec le plus grand nombre de 1 consecutif
        // Ces numéros de lignes sont stockés dans un tableau dynamique
        ArrayList<Integer> maxConsecutifList = findConsecutiveList(matrice);

        if (maxConsecutifList.isEmpty()) {
            System.out.println("Pas de lignes avec des 1 !");
        } else {
            System.out.println("Ligne(s) avec le plus de 1 consecutifs :");
            for (Integer index : maxConsecutifList) {
                System.out.println(index);
            }
        }
    }

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    
    /*
     * méthode emptyMatrix de verification de matrice vide 
     */
    public static boolean emptyMatrix(String matrix) {	
    	String lines[] = matrix.split(" {1,}");
    	int linesSize = lines.length;
    	boolean empty;
    	if (lines.length > 1) {
    		int i = 1;
    		do {
    			if (lines[i].isEmpty()) {
    				empty = true;
    			} else {
    				empty = false;
    			}
    			i++;
    		} while ((!empty) && (i < lines.length));
    	} else {
			if (linesSize == 1) {
				if (lines[0].isEmpty()) {
					empty = true;
				} else {
					empty = false;
				}
			} else {
				empty = true;
			}
		}
	return empty;
    }
    
    /* La fonction checkLine
	 * parcourt un tableau de string en vérifiant 
	 * si les lignes ont la même longueur : TRUE  sinon FALSE
	 */
	public static boolean checkLine(String [] tab, int i) {
		boolean sameLength;
		do {
			if (tab[i].length() == tab[i+1].length()) {
				sameLength = true;
			} else {
				sameLength = false;
			}
			i++;
		} while ((sameLength) && (i < (tab.length - 1)));
		return sameLength;
	}
    
	
    /*
     * méthode checkLineLength de vérification de la taille des lignes de la matrice
     */
	public static boolean checkLineLength(String matrix) {
		boolean goodLength;
		boolean empty = emptyMatrix(matrix);
		int i = 0;
		String [] lines = matrix.split(" {1,}");
		
		if (empty) {
			System.out.println("Matrice vide !");
			goodLength = false;
		} else {
			if (lines.length > 1) {
				if (!lines[0].isEmpty()) {
					goodLength = checkLine(lines, i);
				} else {
					i = 1;
					if (lines.length == 2) {
						goodLength = true;
					} else {
						goodLength = checkLine(lines, i);
					}	
				}
			} else {
				if (lines.length == 1) {
					goodLength = true;
				} else {
					goodLength = false;
				}
			}
		}
		return goodLength;
	}
    
	/* la fonction format : booléen
	 * parcourt un tableau de string en vérifiant
	 * qu'il ne contient que des '0' ou des '1' : TRUE
	 * sinon : FALSE
	 */
	public static boolean format (String [] tab, int i, int j) {
		boolean formatCorrect = false;
		for (int k = i; k < tab.length; k++) {
			for (int h = j; h < tab[i].length(); h++) {
				if ((tab[k].charAt(h) == '0') || (tab[k].charAt(h) == '1')) {
					formatCorrect = true;
				} else {
					formatCorrect = false;
					System.out.println("Matrice invalide : seuls '1', '0' et ' ' sont admis !");
					return formatCorrect;
				}
			}
		}
		/* avec le do ... while
		do {
			do {
				if ((tab[i].charAt(j) == '0') || (tab[i].charAt(j) == '1')) {
					formatCorrect = true;
				} else {
					formatCorrect = false;
					System.out.println("Matrice invalide : seuls '1', '0' et ' ' sont admis !");
				}
				j++;
			} while ((formatCorrect) && (j < (tab[i].length() )));
			i++;
		} while ((formatCorrect) && (i < (tab.length )));
		*/
		return formatCorrect;
	}
	
    /*
     * méthode checkFormat de vérification de la conformité de la matrice
     */
	public static boolean checkFormat(String matrix) {
		boolean goodLength = checkLineLength(matrix);
		boolean emptiness = emptyMatrix(matrix);
		boolean goodFormat;
	String [] lines = matrix.split(" {1,}");
	int i, j, k; 
	
	if (emptiness) {
		goodFormat = false;
		return goodFormat;
	} else {
		if (lines[0].isEmpty()) {
			for (k = 1; k < lines.length; k++) {
				for (int l = 0; l < lines[k].length(); l++) {
					if (lines[k].charAt(l) != '0' && lines[k].charAt(l) != '1') {
						goodFormat = false;
						System.out.println("Matrice invalide : seuls '1', '0' et ' ' sont admis !");
						return goodFormat;
					}
				}
			}
		} else {
			for (k = 0; k < lines.length; k++) {
				for (int l = 0; l < lines[k].length(); l++) {
					if (lines[k].charAt(l) != '0' && lines[k].charAt(l) != '1') {
						goodFormat = false;
						System.out.println("Matrice invalide : seuls '1', '0' et ' ' sont admis !");
						return goodFormat;
					}
				}
			}
		}
		if (goodLength) {
			if (lines.length > 1) {
				if (!lines[0].isEmpty()) {
					i = 0; j = 0;
					goodFormat = format(lines, i, j);
				} else {
					i = 1; j = 0;
					if (lines.length == 2) {
						goodFormat = format(lines, i, j);
					} else {
						goodFormat = format(lines, i, j);
					}
				}
			} else {
				i = 0; j = 0;
				goodFormat = format(lines, i, j);
			}
		} else {
			System.out.println("Matrice invalide, lignes de longueurs differentes !");
			goodFormat = false;
			return goodFormat;
		}
	}
	return goodFormat;
}
    
    
    /*
     * la méthode findConsecutiveList qui renvoie dans un ArrayList
     * les indices des lignes ayant le plus de '1'
     */
    
	public static ArrayList<Integer> findConsecutiveList(String matrix) {
    	ArrayList<Integer> maxList = new ArrayList<Integer>();
    	int [][] eachLine;
    	/** 
    	 * le tableau eachLine sera une matrice de taille
    	 * eachLineLength lignes et 2 colonnes
    	 * chaque ligne contient 
    	 * les indices 'réels' des lignes (du tableau lines)
    	 * suivi dans la 2ème colonne du nombre de '1' par lignes (du tableau lines)
    	 * les deux dimensions sont de même longueur eachLineLength 
    	 */
    	int eachLineLength;
    	String lines [] = matrix.split(" {1,}");
    	int compteur;
    	if (lines[0].isEmpty()) {
		eachLineLength = lines.length - 1;
		eachLine = new int [eachLineLength][2];
		for (int i = 1; i < lines.length; i++) {
    		compteur = 0;
			for (int j = 0; j < lines[i].length(); j++) {
				if (lines[i].charAt(j) == '1') {
					compteur++;
				} else {
					if (compteur > eachLine[i-1][1]) {
						eachLine[i-1][1] = compteur;
					}
					compteur = 0;
				}
			}
			eachLine[i-1][0] = i - 1;
			if ((eachLine[i-1][1] < compteur) ) {
				eachLine[i-1][1] = compteur;
			}
		}
	} else {
		eachLineLength = lines.length;
		eachLine = new int [eachLineLength][2];
		for (int i = 0; i < lines.length; i++) {
    		compteur = 0;
			for (int j = 0; j < lines[i].length(); j++) {
				if (lines[i].charAt(j) == '1') {
					compteur++;
				} else {
					if (compteur > eachLine[i][1]) {
						eachLine[i][1] = compteur;
					}
					compteur = 0;
				}
			}
			eachLine[i][0] = i;
			if ((compteur > eachLine[i][1]) ) {
				eachLine[i][1] = compteur;
			}
		}
	}
    	
    	if (eachLine != null) {
    		for (int i = 0; i < eachLine.length; i++) {
    			if ((maxList.isEmpty()) && (eachLine[i][1] > 0)) {
				maxList.add(i);
				i++;
			}
    			
    			if (!maxList.isEmpty() && (eachLine[maxList.get(maxList.size()-1)][1] > 0)) {
					if (eachLine[i][1] == eachLine[maxList.get(maxList.size()-1)][1]) {
					maxList.add(i);
				} else {
					if (eachLine[i][1] > eachLine[maxList.get(maxList.size()-1)][1]) {
						maxList.clear();
						maxList.add(i);
					}
				}
			}
    		}
    	}
    	return maxList;
    }

    //System.out.println("Matrice invalide, lignes de longueurs differentes !");
    //System.out.println("Matrice vide !");
    //System.out.println("Matrice invalide : seuls '1', '0' et ' ' sont admis !");

    /*******************************************
     * Ne rien modifier apres cette ligne
     *******************************************/
}
