package domain;

import java.util.*;
import domain.Propeller;


public class Rocket {

	private int propNumber = 0;
	private String rocketId = "";
	private List<Propeller> propellerList = new ArrayList<>();
	private Scanner scprop = new Scanner(System.in);
	private int currentVelocity = currentVelocity();
	private static int amountToAccelerate = 10;
	private static int amountToDecelerate = -10;
	private static String accWord = "Acceleration";
	private static String decWord = "Deceleration";
	
	public Rocket() {

	}

	public Rocket(String identifier, int numberOfProps) throws Exception { // constructor
		setRocketId(identifier);
		setNumberOfProps(numberOfProps);
		createProps(numberOfProps);

	}
	
	private int currentVelocity() {
		int velocity = 0;
		for (Propeller p: this.propellerList) {
			velocity += p.getCurrentPower();
		}
		return velocity;
	}
	
	
	private Propeller findAPropeller(List<Propeller> propellerList, String action) {
		//Disculpa per la funció llarga: No volia repetir codi separant-la en dues petites que
		//compartien la gran part de línies, i m'he estimat més permetre'm aquest luxe.
		Propeller theRightPropeller = new Propeller();
		boolean foundPropeller = false;
		int i = 0;
		while (!foundPropeller && i < propellerList.size()) {
			if (action.equals(accWord)) {
				if (propellerList.get(i).getCurrentPower() + amountToAccelerate <= propellerList.get(i).getMaximumPower()) {
					theRightPropeller = propellerList.get(i);
					foundPropeller = true;
				}
			}
			else {
				if (propellerList.get(i).getCurrentPower() + amountToDecelerate >= 0) {
					theRightPropeller = propellerList.get(i);
					foundPropeller = true;
				}
			}
			i++;
		}
		return theRightPropeller;
	}
	
	public void setDeceleration(List<Propeller> propellerList) throws Exception {
		//Quin propulsor puc frenar?
		Propeller prop = findAPropeller(propellerList, decWord);
		try {
			prop.changeCurrentPower(false);
		}
		catch (Exception e) {
				System.out.println(e.getMessage());
		}
	}
		
	public void setAcceleration(List<Propeller> propellerList) throws Exception {
		//Quin propulsor puc accelerar?
		Propeller prop = findAPropeller(propellerList, accWord);
		try {
			prop.changeCurrentPower(true);
		}
		catch (Exception e) {
				System.out.println(e.getMessage());
		}
	}
		
	private boolean isValidPower(int propPower, Propeller myProp) {
		try {
			myProp.setMaximumPower(propPower);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private void testPower(int propPower, Propeller myProp) {
		while (!isValidPower(propPower, myProp)) {
			System.out.println("Please, try again.");
			propPower = scprop.nextInt();
			scprop.nextLine();
		}
	}

	private void fillProps(List<Propeller> propellerList) {
		int propPower;
		for (int j = 0; j < propellerList.size(); j++) {
			System.out.println("Please, enter maximum power for propeller number " + (j + 1));
			propPower = scprop.nextInt();
			scprop.nextLine();
			testPower(propPower, propellerList.get(j));
		}
	}

	private void createProps(int propSetNumber) throws Exception {
		if (propSetNumber > 0) {
			for (int j = 0; j < propSetNumber; j++) {
				propellerList.add(new Propeller());
			}
		} else {
			throw new Exception("Error: Number of propellers must be greater than 0.");
		}
	}

	public String getRocketId() {
		return rocketId;
	}

	public int getNumberOfProps() {
		return propNumber;
	}
	
	public int getCurrentVelocity() {
		return currentVelocity;
	}

	public List<Propeller> getPropellerList() {
		return propellerList;
	}
	
	public void setRocketId(String code) throws Exception {
		if (code != null && !code.equals("") && code.length() == 8) {
			this.rocketId = code;
		} else {
			throw new Exception("Error: Rocket ID must have exactly 8 characters.");
		}
	}

	public void setNumberOfProps(int props) throws Exception {
		if (props > 0) {
			this.propNumber = props;
			createProps(this.propNumber);
			fillProps(propellerList);
		} else {
			throw new Exception("Error: Number of propellers must be greater than 0.");
		}

	}

}
