package univavignon.m1informatique.aa.SEA.elevator.elevator_imp;

public class ElevatorShaft {
	/**
	 * 
	 */
	final double constSpeed = 1.0; // vitesse du moteur constante en m/s
	/**
	 * 
	 */
	final double constSpeedTransient = 0.2; // vitesse de transition du moteur constante en m/s
	/**
	 * 
	 */
	/**
	 * 	
	 */
	public Sensor sensor;
	/**
	 * 
	 */
	public Elevator elevator;
	/**
	 * 
	 */
	public Engine engine;
	/**
	 * 
	 */
	public double shaftHeight;
	/**
	 * 
	 */
	public double elevatorHeight;
	/**
	 * Getter of sensor
	 */
	public Sensor getSensor() {
	 	 return sensor; 
	}
	/**
	 * Setter of sensor
	 */
	public void setSensor(Sensor sensor) { 
		 this.sensor = sensor; 
	}
	/**
	 * Getter of elevator
	 */
	public Elevator getElevator() {
	 	 return elevator; 
	}
	/**
	 * Setter of elevator
	 */
	public void setElevator(Elevator elevator) { 
		 this.elevator = elevator; 
	}
	/**
	 * Getter of engine
	 */
	public Engine getEngine() {
	 	 return engine; 
	}
	/**
	 * Setter of engine
	 */
	public void setEngine(Engine engine) { 
		 this.engine = engine; 
	}
	/**
	 * Getter of shaftHeight
	 */
	public double getShaftHeight() {
	 	 return shaftHeight; 
	}
	/**
	 * Setter of shaftHeight
	 */
	public void setShaftHeight(double shaftHeight) { 
		 this.shaftHeight = shaftHeight; 
	}
	/**
	 * Getter of elevatorHeight
	 */
	public double getElevatorHeight() {
	 	 return elevatorHeight; 
	}
	/**
	 * Setter of elevatorHeight
	 */
	public void setElevatorHeight(double elevatorHeight) { 
		 this.elevatorHeight = elevatorHeight; 
	} 
	/**
	 * 
	 */
	public void compute() { 
		 
	} 
}
