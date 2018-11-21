package domain;

public class Propeller {
	private int maxPower = 0;

	public Propeller() {

	}

	public Propeller(int pow) {
		setMaximumPower(pow);
	}

	public void setMaximumPower(int propPow) {
		if (propPow > 0) {
			this.maxPower = propPow;
		} else {
			throw new RuntimeException("Error: Propeller maximum power must be positive.");
		}
	}

	public int getMaximumPower() {
		return this.maxPower;
	}

}
