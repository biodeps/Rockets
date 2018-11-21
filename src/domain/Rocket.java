package domain;

import java.util.*;

import domain.Propeller;

public class Rocket {
	private int propNumber = 0;
	private String rocketId = "";
	private ArrayList<Propeller> propellerList = new ArrayList<>();
	private Scanner scprop = new Scanner(System.in);

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

	private void fillProps(ArrayList<Propeller> propellerList) {
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

	public ArrayList<Propeller> getPropellerList() {
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

	public Rocket() {

	}

	public Rocket(String identifier, int numberOfProps) throws Exception { // constructor

		setRocketId(identifier);
		setNumberOfProps(numberOfProps);
		createProps(numberOfProps);

	}

}
