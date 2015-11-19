package univavignon.m1informatique.aa.SEA.controlSystem.controlSystem_imp;

import java.util.ArrayList;

public class RequestListFactory {

	/**
	 * 
	 */
	public ArrayList<CSRequest> currentList;
	/**
	 * 
	 */
	public ArrayList<CSRequest> nextList;
	/**
	 * Getter of currentList
	 */
	public ArrayList getCurrentList() {
	 	 return currentList; 
	}
	/**
	 * Setter of currentList
	 */
	public void setCurrentList(ArrayList<CSRequest> currentList) { 
		 this.currentList = currentList; 
	}
	/**
	 * Getter of nextList
	 */
	public ArrayList<CSRequest> getNextList() {
	 	 return nextList; 
	}
	/**
	 * Setter of nextList
	 */
	public void setNextList(CSRequest nextList) { 
		 this.nextList = nextList; 
	}
	/**
	 * 
	 */
	public void add(CSRequest csr) { 
		// TODO Auto-generated method
		currentList.add(csr);
	 }
	/**
	 * 
	 */
	public void delete() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void sort() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void swapList() { 
		// TODO Auto-generated method
	 } 

}
