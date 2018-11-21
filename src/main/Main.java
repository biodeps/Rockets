package main;

import java.util.*;
import domain.Rocket;

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
		System.out.print(printableRocket.getRocketId() + ":");
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
		System.out.println();
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in); // la inicialitzem un sol cop

		Rocket rocket1 = new Rocket();
		readTheRocket(rocket1);
		Rocket rocket2 = new Rocket();
		readTheRocket(rocket2);
		sc.close(); // tanquem al final, no a cada funció!
		printTheRocket(rocket1);
		printTheRocket(rocket2);
				
	}

}
