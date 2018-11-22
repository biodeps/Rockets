package main;

import java.util.*;
import domain.Rocket;
import domain.Propeller;

public class Main {
	private static int currentRocket = 1;
	private static boolean firstRocket = true;
	private static Scanner sc; // Variable global Scanner, la utilitzarem i
							   // sobreescriurem on volguem.

	private static boolean isValidNumber(Rocket rock, int rocketnum) {
		try {
			rock.setNumberOfProps(rocketnum);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static boolean isValidId(Rocket rock, String identifyer) {
		try {
			rock.setRocketId(identifyer);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static void testDataId(Rocket rock, String id) {
		boolean isValid = isValidId(rock, id);
		sc = new Scanner(System.in);
		while (!isValid) {
			System.out.println("Please, try again.");
			id = sc.nextLine();
			isValid = isValidId(rock, id);
		}
	}

	private static void testDataNumber(Rocket rock, int num) {
		boolean isValid = isValidNumber(rock, num);
		sc = new Scanner(System.in);
		while (!isValid) {
			System.out.println("Please, try again.");
			num = sc.nextInt();
			sc.nextLine();
			isValid = isValidNumber(rock, num);
		}
	}

	private static void readTheRocket(Rocket writtableRocket) {

		if (firstRocket) {
			System.out.println("Welcome to Rocket Race!");
		}
		System.out.println("Please, enter ID for rocket " + currentRocket + ": ");
		String idEntry = sc.nextLine();
		testDataId(writtableRocket, idEntry);

		System.out.println("Now, please enter number of propellers for rocket " + currentRocket + ": ");
		int propsEntry = sc.nextInt();
		sc.nextLine();
		/*
		 * important fer sc.nextLine() després de cada sc.nextInt(), ja que el mètode
		 * nextInt NOMÉS llegeix l'enter, i no el final de línia de quan cliquem enter.
		 * Per "obviar" aquest final de línea que forma part de l'entrada de dades, fem
		 * un sc.nextLine i tornem a "estar a 0" per a ebre nous nombres i noves dades.
		 */
		testDataNumber(writtableRocket, propsEntry);

		currentRocket += 1;
		firstRocket = false;
	}
	
	private static void printTheRocket (Rocket printableRocket) {
		//Aquest mètode té més de 7 línies perquè només serveix per printar
		boolean firstElement = true;
		int i = 0;
		System.out.print(printableRocket.getRocketId() + " has " + printableRocket.getNumberOfProps() + " propellers, and their maximum powers are:");
		String joiner = "";
		while (i < printableRocket.getNumberOfProps()) {
			if (firstElement) {
				joiner = " ";
				firstElement = false;
			}
			else {
				joiner = ", ";
			}
			System.out.print(joiner + printableRocket.getPropellerList().get(i).getMaximumPower());
			i++;
		}
		System.out.println("\n");
	}

	private static void printRocketSettings(Rocket printableRocket) {
		System.out.print(printableRocket.getRocketId() + " current velocity: " + printableRocket.getCurrentVelocity() + "\n" + "{");
		for (Propeller p: printableRocket.getPropellerList()) {
			System.out.print(p.getCurrentPower() + " ");
		}
		System.out.println("}");
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in); // la inicialitzem un sol cop

		Rocket rocket1 = new Rocket();
		readTheRocket(rocket1);
		Rocket rocket2 = new Rocket();
		readTheRocket(rocket2);
		sc.close(); // tanquem al final, no a cada funció!
		
		// Exercici 3
		printTheRocket(rocket1);
		printRocketSettings(rocket1);
		printTheRocket(rocket2);
		printRocketSettings(rocket2);
		System.out.println("\n");
		
		// Exercici 4
		try {
			for (int i = 0; i < 3; i++) {
				rocket1.setAcceleration(rocket1.getPropellerList());
				rocket2.setAcceleration(rocket2.getPropellerList());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n");
		
		//Exercici 5
		printRocketSettings(rocket1);
		printRocketSettings(rocket2);
		System.out.println("\n");
		
		//Exercici6
		try {
			for (int i = 0; i < 5; i++) {
				rocket1.setDeceleration(rocket1.getPropellerList());
			}
			for (int i = 0; i < 7; i++) {
				rocket2.setAcceleration(rocket2.getPropellerList());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n");
		
		//Exercici 7
		printRocketSettings(rocket1);
		printRocketSettings(rocket2);
		System.out.println("\n");
		
		//Exercici 8
				try {
					for (int i = 0; i < 15; i++) {
						rocket1.setAcceleration(rocket1.getPropellerList());
						rocket2.setAcceleration(rocket2.getPropellerList());
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		System.out.println("\n");
				
		//Exercici 9
		printRocketSettings(rocket1);
		printRocketSettings(rocket2);
		System.out.println("\n");
		
	} // MAIN END

}
