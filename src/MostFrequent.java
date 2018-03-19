class MostFrequent {

    public static void main(String[] args) {
        //int[] tab1 = {2, 7, 5, 6, 7, 1, 6, 2, 1, 7, 6};
    		int[] tab1 = {2, 3, 5, 2};
        int taille = tab1.length;

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        //int tab2[] = new int[taille];
        int temp=0;
        int occurence=0;
        int i=0;
        int compteur=0;
        
        //int indice = 0;
        
        //int tab3[] = new int[taille];
        
        for (i=0; i<taille; ++i) {
        	for (int j=0; j<taille; ++j) {
        		if (tab1[i]==tab1[j]) {
        			++occurence;
        		}
        	}
        	if (occurence>compteur) {
        		compteur=occurence;
        		temp = tab1[i];
        	}
        	occurence = 0;
        	
        }
        
        System.out.println("Le nombre le plus frequent dans le tableau est le :");
        System.out.println(temp + " ("+ compteur + " x)");
        


        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

    }
}
