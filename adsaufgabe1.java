package adsaufgabe1;

public class Shellsort_tsosedow implements IShellsort {

    /* Der Konstruktor hat kein Argument
     */
    public Shellsort_tsosedow() {
    	
    }

    /* Rueckgabewert: Anzahl der Schluesselvergleiche
     */
    public int shellsort(IPermutation[] feld) {
    	int vgl = 1;
    	int schrittweite = 1;
    	for(int i = 0; i < feld.length; i++) {
    		System.out.print(i + ": ");
    		feld[i].print();
    	}
    	while (3*schrittweite+1 < feld.length) {
			schrittweite = (schrittweite*3)+1;
			vgl++;
		}
    	System.out.println("Schrittweite berechnet");
		vgl++;
    	while (schrittweite > 0) {
			System.out.println("Führe Insertionsort mit Schreitweite " + schrittweite + " aus");
			vgl += insertionsortMitSchrittweite(feld, schrittweite);
			schrittweite /= 3;
		}
    	return vgl;
    }

    /* Rueckgabewert: Anzahl der Schluesselvergleiche
     */
    public int insertionsortMitSchrittweite(IPermutation[] feld, int schrittweite) {
    	int vgl = 1;
    	int nichtTauschen = 0;
		for (int i = schrittweite; i < feld.length; i++) {
			int perm1Betrag = Math.abs(feld[i].wert(1)-feld[i].wert(feld[i].laenge()));
			IPermutation perm1 = feld[i];
			System.out.println("\nHauptpermutation ist " + i + ": " + perm1);
			System.out.println("");
			int k = i;
			System.out.println("Vergleich der Beträge von Hauptpermutation "+ i + ": " + perm1 + " mit " + (k-schrittweite) + ": " + feld[k-schrittweite]);
			while (k > schrittweite-1 && Math.abs(feld[k-schrittweite].wert(1)-feld[k-schrittweite].wert(feld[0].laenge())) >= perm1Betrag && nichtTauschen == 0) {
				if(Math.abs(feld[k-schrittweite].wert(1)-feld[k-schrittweite].wert(feld[k-schrittweite].laenge())) > perm1Betrag) {
					feld[k] = feld[k-schrittweite];
					System.out.println("Feldstelle " + k + " überschrieben mit Vorgängerstelle "+ (k-schrittweite) + " da es größer war");
					System.out.print("xAltes k: " + k);
					k = k - schrittweite;
					System.out.println(", wird zu " + k);
					
				}
				else {
					int stelle = -1;
					for(int j = 1; j <= feld[0].laenge(); j++) {
						if ((perm1.wert(j) != feld[k-schrittweite].wert(j)) && stelle == -1) {
							stelle = j;
							System.out.println("Ungleiche Stelle " + j + " in Permutationen gefunden");
							
						}
					}	
					if(stelle != -1 && (perm1.wert(stelle) < feld[k-schrittweite].wert(stelle))) {
							feld[k] = feld[k-schrittweite];
							System.out.println("Feld " + k + " überschrieben mit Vorgänger "+ (k-schrittweite) + " da Stelle größer war");
							
					}
					else {
						System.out.println("Vorgänger ist kleiner, kein Tausch erforderlich");
						nichtTauschen = 1;
						
					}
					System.out.print("yAltes k: " + k);
					k = k - schrittweite;
					System.out.println(", wird zu " + k);
					
				}
				if(k > schrittweite-1) {
					System.out.println("Vergleich der Beträge von Hauptpermutation "+ i + ": " + perm1 + " mit " + (k-schrittweite) + ": " + feld[k-schrittweite]);
				}
				vgl++;
			}
			if (nichtTauschen == 0) {
				feld[k] = perm1;
				System.out.println("Feldstelle " + k + ": " + feld[k] + " ersetzt mit Hauptpermutation "+ perm1);
			}
			else { //das später entfernen
				feld[k+ schrittweite] = perm1; 
				System.out.println("Feldstelle " + (k+schrittweite) + ": " + feld[k+schrittweite] + " ersetzt mit Hauptpermutation "+ perm1);
				nichtTauschen = 0;
			}
			
			for(int x = 0; x < feld.length; x++) {
	    		System.out.print(x + ": " + feld[x] + "\n");
	    	}
		}
		
    	return vgl;
    }
}


/*
 * 
 * 
 * Was macht der Konstruktor? Was muss da rein?
 * 
 * HTWKLOGIN == Nutzername zum einloggen?
 * 
 * 
 * 
 */
