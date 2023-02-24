package sorpresaAA;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("Dades de l'edifici 1");

		// creem l'edifici amb les dimensions per teclat
		int[][] edifici1 = crearEdifici(sc); // OK

		// l'omplim amb integers (m2)
		omplirEdifici(sc, edifici1); // OK

		// fem servir la funcio que suma els m2 de les portes parell
		int totalM2PortesParellE1 = sumaMetresQuadrats(edifici1);

		// mostrem les dades per pantalla
		System.out.println("M² de les portes parells de l'edifici 1: " + totalM2PortesParellE1 + "m²\n");

		// el mateix amb edifici2

		System.out.println("Dades de l'edifici 2");

		int[][] edifici2 = crearEdifici(sc);

		omplirEdifici(sc, edifici2);

		int totalM2PortesParellE2 = sumaMetresQuadrats(edifici2);

		System.out.println("M² de les portes parells de l'edifici 1: " + totalM2PortesParellE2 + "m²\n");

		// funció que coapra els edificis
		edificiMesM2(edifici1, edifici2);

		sc.close();

	}

	// una funció que crea un array amb dimensions per teclat
	public static int[][] crearEdifici(Scanner sc) {

		System.out.print("Intodueix el nombre de plantes: ");

		int numPlantes = sc.nextInt();

		System.out.print("Introdueix el nombre de portes per planta: ");

		int numPortes = sc.nextInt();

		int[][] edifici = new int[numPlantes][numPortes];

		return edifici;
	}

	// una funcio que omple el array per teclat
	public static void omplirEdifici(Scanner sc, int[][] edifici) {
		for (int fil = 0; fil < edifici.length; fil++) {
			for (int col = 0; col < edifici[fil].length; col++) {
				System.out.print("M² de la porta [" + fil + " - " + col + "]: ");
				edifici[fil][col] = sc.nextInt();
			}
		}
	}

	/*
	 * Dissenya una funció que donat un edifici retorni la suma dels metres quadrats
	 * de totes les portes parell, només les parell, no les senar.
	 */

	public static int sumaMetresQuadrats(int[][] edifici) {

		int sumaM2PortesParell = 0;

		for (int fil = 0; fil < edifici.length; fil++) {
			for (int col = 0; col < edifici[fil].length; col++) {
				do {
					sumaM2PortesParell += edifici[fil][col];
					col++;
				} while (col % 2 == 0);
			}
		}

		return sumaM2PortesParell;
	}

	// funció que diu quin edifici té més M2 de les portes parells

	public static void edificiMesM2(int[][] edifici1, int[][] edifici2) {

		int totalM2Edifici1 = sumaMetresQuadrats(edifici1);

		int totalM2Edifici2 = sumaMetresQuadrats(edifici2);

		if (totalM2Edifici1 > totalM2Edifici2) {
			System.out.println("L'edifici 1 és el més gran amb un total de " + totalM2Edifici1
					+ "m² a les portes parells.\nL'edifici 2 només té: " + totalM2Edifici2 + "m².");
		} else if (totalM2Edifici1 < totalM2Edifici2) {
			System.out.println("L'edifici 2 és el més gran amb un total de " + totalM2Edifici2
					+ "m² a les portes parells.\nL'edifici 1 només té: " + totalM2Edifici1 + "m².");
		} else {
			System.out.println("Els dos edificis tenen els mateixos m²:\nEdifici 1 = " + totalM2Edifici1
					+ " i Edifici 2 = " + totalM2Edifici2);
		}

	}

}
