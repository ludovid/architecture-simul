package univavignon.m1informatique.aa.SEA.elevator.impl;

public class Sensor {

	/**
	 * 
	 */
	public boolean detection;
	/**
	 * 
	 */
	public int id;
	/**
	 * 
	 */
	public double distanceFromBottom;
	
	public double getDistanceFromBottom() {
		return distanceFromBottom;
	}
	
	public void setDistanceFromBottom(double distanceFromBottom) {
		this.distanceFromBottom = distanceFromBottom;
	}
	/**
	 * Constructeur
	 */
	public Sensor(int id, double dfb) {
	 	  this.detection = false;
	 	  this.id = id;
	 	  this.distanceFromBottom = dfb;
	}
	/**
	 * Getter of detection
	 */
	public boolean getDetection() {
	 	 return detection; 
	}
	/**
	 * Setter of detection
	 */
	public void setDetection(boolean detection) { 
		 this.detection = detection; 
	}
	/**
	 * Getter of id
	 */
	public int getId() {
	 	 return id; 
	}
	/**
	 * Setter of id
	 */
	public void setId(int id) { 
		 this.id = id; 
	} 

}
