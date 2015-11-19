package univavignon.m1informatique.aa.SEA.elevator.elevator_imp;

public class ElevatorShaft {
	/**
	 * 
	 */
	final double constSpeed = 1.0; // vitesse du moteur constante en m/s
	/**
	 * 
	 */
	public Sensor [][] sensor; // id tableau = id etage / sensor 1 / sensor 2 de l'etage
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
	 * Constructeur
	 */
	public ElevatorShaft(double sh, double eh, int nbs, long odw) {
	 	  this.elevator = new Elevator(odw);
	 	  this.engine = new Engine();
	 	  this.sensor = new Sensor[nbs][2];
	 	  int k = 0;
	 	  for(int i = 0; i < nbs; i++) {
			this.sensor[i][0] = new Sensor(k);
			k++;
			this.sensor[i][1] = new Sensor(k);
			k++;
	 	  }
	 	  this.shaftHeight = sh;
	 	  this.elevatorHeight = eh;
	}
	/**
	 * Getter of sensor
	 */
	public Sensor[][] getSensor() {
	 	 return sensor; 
	}
	/**
	 * Setter of sensor
	 */
	public void setSensor(Sensor [][] sensor) { 
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
