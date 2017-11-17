package fr.unilim.iut.PressionPneus;

public class SafetyRange {
	
	private final double lowPressureThreshold;
	private final double highPressureThreshold;
	
	public SafetyRange(double lowPreasureThreshold, double highPreasureThreshold){
		this.lowPressureThreshold=lowPreasureThreshold;
		this.highPressureThreshold=highPreasureThreshold;
	}

	public boolean isPreasureToHigh(double pressureValue) {
		return this.highPressureThreshold < pressureValue;
	}

	public boolean isPreasureToLow(double pressureValue) {
		return pressureValue < this.lowPressureThreshold;
	}
}
