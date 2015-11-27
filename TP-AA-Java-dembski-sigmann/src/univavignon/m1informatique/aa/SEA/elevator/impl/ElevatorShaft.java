package univavignon.m1informatique.aa.SEA.elevator.impl;


import univavignon.m1informatique.aa.SEA.commontype.Direction;
import univavignon.m1informatique.aa.SEA.elevator.api.IElevatorCommand;
import univavignon.m1informatique.aa.SEA.sequencer.api.Event;


public class ElevatorShaft implements Event, IElevatorCommand{
	
	
	public long getLastCallTrigger() {
		return lastCallTrigger;
	}
	public void setLastCallTrigger(long lastCallTrigger) {
		this.lastCallTrigger = lastCallTrigger;
	}

	public long lastCallTrigger;
	
	double distanceFromBottom;
	
	/**
	 * 
	 */
	public double constSpeed; // vitesse du moteur constante en m/s
	/**
	 * 
	 */
	public Sensor [][] sensor; // id tableau = id etage / sensor 1 / sensor 2 de l'etage
	/**
	 * 
	 */
	public Elevator elevator; // cabine
	/**
	 * 
	 */
	public Engine engine; // moteur
	/**
	 * 
	 */
	public double shaftHeight; // hauteur totale
	/**
	 * 
	 */
	public double elevatorHeight; // hauteur de la cabine
	/**
	 * 
	 */
	public double distanceBetweenFloors; // distance entre 2 étages sans la taille de la cabine
	/**
	 * 
	 */
	public int nbFloors; // nombre d'étage
	/**
	 * Constructeur
	 */
	public ElevatorShaft(double eh, int nbf, double dbf, long odw, double speed) {
		  int nbs = nbf * 2; 
	 	  this.elevator = new Elevator(odw);
	 	  this.engine = new Engine(speed);
	 	  this.sensor = new Sensor[nbs][2];
	 	  int k = 0;
	 	  for(int i = 0; i < nbs; i++) {
			this.sensor[i][0] = new Sensor(k);
			k++;
			this.sensor[i][1] = new Sensor(k);
			k++;
	 	  }
	 	  this.shaftHeight = nbf * (dbf + eh);
	 	  this.elevatorHeight = eh;
	 	  this.distanceBetweenFloors = dbf;
	 	  this.nbFloors = nbf;
	 	  this.distanceFromBottom = 0.0;
	 	  this.constSpeed = speed;
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
	 * Getter of distanceBetweenFloors
	 */
	public double getDistanceBetweenFloors() {
	 	 return distanceBetweenFloors; 
	}
	/**
	 * Setter of distanceBetweenFloors
	 */
	public void setDistanceBetweenFloors(double distanceBetweenFloors) { 
		 this.distanceBetweenFloors = distanceBetweenFloors; 
	} 
	/**
	 * Getter of nbFloors
	 */
	public double getNbFloors() {
	 	 return nbFloors; 
	}
	/**
	 * Setter of nbFloors
	 */
	public void setNbFloors(int nbFloors) { 
		 this.nbFloors = nbFloors; 
	} 
	/**
	 * Getter of constSpeed
	 */
	public double getConstSpeed() {
	 	 return constSpeed; 
	}
	/**
	 * Setter of constSpeed
	 */
	public void setConstSpeed(double constSpeed) { 
		 this.constSpeed = constSpeed; 
	} 
	/**
	 * 
	 */
	@Override
	public void trigger(long t) {
		if(this.lastCallTrigger == 0)
			this.lastCallTrigger = t;
		else
		{
			long tmpT = t - this.lastCallTrigger;
			this.distanceFromBottom += tmpT * this.constSpeed;
			
			this.isAtLevel(distanceFromBottom/distanceBetweenFloors);
		}
	}
	
	public void isAtLevel(double pos) { 
		
		if(this.elevator.direction == Direction.Down)
		{
			this.elevator.position = (int) (pos - this.elevatorHeight);
			//if(this.elevator.position)
				this.sensor[this.elevator.position][1].setDetection(true);
		}
		else if(this.elevator.direction == Direction.Up)
		{
			this.elevator.position = (int) (pos + this.elevatorHeight);
			//if(this.elevator.position < )
				this.sensor[this.elevator.position][0].setDetection(true);
		}
		// croiser capteur à faire
		
		this.elevator.IEN.notifyLevel(elevator.position);
		System.out.println("elevator crossed level "+elevator.position);
	 }
	
	/**
	 * 
	 */
	public void stopAtNextLevel() { 
		this.engine.off();
		
		System.out.println("elevator stop at level final");
	 }
	
	@Override
	public void move(Direction direction) {
		// TODO Auto-generated method stub
		
	}
}
