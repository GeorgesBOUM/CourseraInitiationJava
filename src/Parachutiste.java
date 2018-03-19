import java.util.Scanner;

class Parachutiste {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        double masse = 80.0;
        do {
            System.out.print("masse du parachutiste (>= 40) ? ");
            masse = clavier.nextDouble();
        } while (masse < 40.0);

        double h0 = 39000.0;
        do {
            System.out.print("hauteur de depart du parachutiste (>= 250) ? ");
            h0 = clavier.nextDouble();
        } while (h0 < 250.0);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        
        final double g = 9.81;
        double v0 = 0.0;
        double t0 = 0.0;
        double vitesse = v0;
        double hauteur = h0;
        double accel = g;
        double t = t0;
        double surface = 2.0;
        double s;
        double q=0;
        boolean son = false;
        boolean vmax = false;
        boolean parachuteOuvert = false;
      
        s=surface/masse;
        
        while (hauteur>0) {
        	if (hauteur>=2500) {
        		q = Math.exp(-s*(t-t0));
        		vitesse = (g/s)*(1-q) + v0*q;
        		hauteur = h0-(g/s)*(t-t0)-((v0-(g/s))/s)*(1-q);
            	accel = g - s*vitesse;
            	if ((parachuteOuvert==false) && (hauteur<2500)) {
        			System.out.println("## Felix ouvre son parachute");
        			h0 = hauteur;
        			v0 = vitesse;
        			t0 = t;
        			surface = 25.0;
        			s=surface/masse;
        			parachuteOuvert=true;
        		}
            } else {
            	if ((hauteur==h0) && (q==0)) {
            		q = Math.exp(-s*(t-t0));
            		vitesse = (g/s)*(1-q) + v0*q;
            		hauteur = h0-(g/s)*(t-t0)-((v0-(g/s))/s)*(1-q);
                	accel = g - s*vitesse;
            	} else {
            		q = Math.exp(-s*(t-t0));
            		vitesse = (g/s)*(1-q) + v0*q;
            		hauteur = h0-(g/s)*(t-t0)-((v0-(g/s))/s)*(1-q);
                	accel = g - s*vitesse;
            		if ((parachuteOuvert==false) && (hauteur<2500)) {
            			System.out.println("## Felix ouvre son parachute");
            			h0 = hauteur;
            			v0 = vitesse;
            			t0 = t;
            			surface = 25.0;
            			s=surface/masse;
            			parachuteOuvert=true;
            		}
            		
            	}
            }
        	if ((accel<0.5) && (vmax==false)){
        		System.out.println("## Felix a atteint sa vitesse maximale");
        		vmax=true;
        	}
        	if ((vitesse>343) && (son==false)){
        		System.out.println("## Felix depasse la vitesse du son");
        		son=true;
        	}
        	
        	if (hauteur>0) {
            	System.out.printf("%.0f, %.4f, %.4f, %.5f\n",
                		t, hauteur, vitesse, accel);
        	} 
        	++t;
        }
       
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        clavier.close();
    }
}
