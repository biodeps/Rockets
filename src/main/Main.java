package main;

import classes.Rocket;

public class Main {

	public static void main(String[] args) {
		Rocket rocket1 = new Rocket(3, "32WESSDS");
		Rocket rocket2 = new Rocket(6, "LDSFJA32");

		System.out.println("El primer coet, de codi " + rocket1.getRocketId() + ", té " + rocket1.getNumberOfProps()
				+ " propulsors.");
		System.out.println("El segon coet, de codi " + rocket2.getRocketId() + ", té " + rocket2.getNumberOfProps()
				+ " propulsors.");
	}

}
