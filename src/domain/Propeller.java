package domain;

public class Propeller {
	
	private int maxPower = 0;
	private int currentPower = 0;
	private static int powerStep = 10;
	
	public Propeller() {

	}

	public Propeller(int pow) throws Exception{
		setMaximumPower(pow);
	}

	public void setMaximumPower(int propPow) throws Exception {
		if (propPow > 0) {
			this.maxPower = propPow;
		} else {
			throw new Exception("Error: Propeller maximum power must be positive.");
		}
	}

	public int getMaximumPower() {
		return this.maxPower;
	}
	
	public int getCurrentPower() {
		return this.currentPower;
	}

	public void changeCurrentPower(boolean powerIncrease) throws Exception {
		if (powerIncrease) {
			if (currentPower + powerStep <= this.maxPower) {
				currentPower += powerStep;
			}
			else {
				this.currentPower = this.maxPower;
				throw new Exception("Error: Propeller maximum power exceeded. Power set to its maximum.");
			}
		}
		else {
			if (currentPower - powerStep >= 0) {
				currentPower -= powerStep;
			}
			else {
				this.currentPower = 0;
				throw new Exception("Error: Propeller power can't be set under 0. Power set to 0.");
			}
		}

	}
		
}
