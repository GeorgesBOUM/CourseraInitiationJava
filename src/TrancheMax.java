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
   
    /**
    * method emptyMatrix : boolean
    * tests whether the matrix
    * is empty or not
    */
   public static boolean emptyMatrix(String matrix) {
   	matrix = matrix.trim();
   	String lines[] = matrix.split(" {1,}");
   	
   	if (lines[0].isEmpty()) {
			//System.out.print("matrice vide");
			return true;
		} else {
			return false;
		}
   }
   
   /**
    * method checkLine : boolean
    * tests whether the elements of
    * an array of String 
    * have the same length or not
	 */
	public static boolean checkLine(String [] tab, int i) {
		boolean sameLength;
		if (tab.length>1) {
			do {
				if (tab[i].length() == tab[i+1].length()) {
					sameLength = true;
				} else {
					sameLength = false;
				}
				i++;
			} while ((sameLength) && (i < (tab.length - 1)));
		} else {
			sameLength = true;
		}
		return sameLength;
	}
   
	
   /**
    * method checkLineLength : boolean
    * tests whether the lines of matrix of char
    * have the same length or not
    */
	public static boolean checkLineLength(String matrix) {
		boolean goodLength;
		boolean empty = emptyMatrix(matrix);
		matrix = matrix.trim();
		String [] lines = matrix.split(" {1,}");
		int i = 0;
		
		if (empty) {
			System.out.println("Matrice vide !");
			goodLength = false;
			return goodLength;
		} else {
			goodLength = checkLine(lines, i);
		}
		return goodLength;
	}
   
	/**
	 *  method format : boolean
	 *  tests whether an array of String
	 *  contains only 2 types of characters: 
	 *  '0' or '1'
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
		return formatCorrect;
	}
	
   /**
    * method checkFormat : boolean
    * tests whether all the lines of a matrix
    * have the same length and 
    * contains only '0' or '1
    */
	public static boolean checkFormat(String matrix) {
		boolean goodLength = checkLineLength(matrix);
		boolean emptiness = emptyMatrix(matrix);
		boolean goodFormat;
		matrix = matrix.trim();
	String [] lines = matrix.split(" {1,}");
	int i = 0, j = 0; 
	
	if (emptiness) {
		goodFormat = false;
		return goodFormat;
	} else {
		if (goodLength) {
			goodFormat = format(lines, i, j);
			return goodFormat;
		} else {
			System.out.println("Matrice invalide, lignes de longueurs differentes !");
			goodFormat = false;
			return goodFormat;
		}
	}
}
   
   
   /**
    * method consecutiveList : array of integer
    * find the maximum number of 
    * consecutive '1' in each line of a matrix
    * eachLine[][] has 2 columns and in each line
    * the index of the matrix line and the number of '1' 
    */
	
	public static int [][] consecutiveList(String matrix) {
		matrix = matrix.trim();
		String [] lines = matrix.split(" {1,}");
		int eachLine [][] = new int [lines.length][2];
		int compteur;
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
		return eachLine;
	}
	
	/**
    * method findConsecutiveList : ArrayList
    * listing the index of lines with the max consecutive '1'
    */
 
	public static ArrayList<Integer> findConsecutiveList(String matrix) {
   	ArrayList<Integer> maxList = new ArrayList<Integer>();
   	//listing the max number of consecutive '1' by line
   	int [][] eachLine = consecutiveList(matrix);
   	//listing the index of lines with the max consecutive '1'
   	for (int i = 0; i < eachLine.length; i++) {
			if ((maxList.isEmpty()) && (eachLine[i][1] > 0)) {
			maxList.add(i);
			if (eachLine.length>1) {
				i++;
			}
		}
			
			if (eachLine.length>1) {
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
