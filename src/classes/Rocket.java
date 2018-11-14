package classes;

import java.util.*;

public class Rocket {
	private int propNumber;
	private String rocketId;

	public Rocket(int numberOfProps, String identifier) {
		// Estructura preparada per si el codi l'hagués d'introduïr l'usuari.	
		Scanner sc = new Scanner(System.in);
		while (identifier.length() != 8) {
			System.out.println("Rocket ID must have exactly 8 characters. Please, try again.");
			identifier = sc.next();
		}
		sc.close();
		
		setRocketId(identifier);
		setNumberOfProps(numberOfProps);
	}

	public String getRocketId() {
		return rocketId;
	}

	public int getNumberOfProps() {
		return propNumber;
	}

	public void setRocketId(String code) {
		rocketId = code;
	}

	public void setNumberOfProps(int props) {
		propNumber = props;
	}

}
