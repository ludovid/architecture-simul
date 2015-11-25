package univavignon.m1informatique.aa.SEA.elevator.api;
import univavignon.m1informatique.aa.SEA.elevator.impl.ElevatorShaft;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ElevatorFactory {

	/**
	 * 
	 * @param setting 
	 * @return 
	 * @throws ParserConfigurationException 
	 */
	public static boolean BuildElevator(File setting) throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(setting);
			NodeList list = document.getElementsByTagName("elevator");
			double speed = Double.parseDouble(list.item(0).getTextContent());
			int floorNumber = Integer.parseInt(list.item(1).getTextContent());
			long doorTime = Long.parseLong(list.item(2).getTextContent());
			double elevatorHeight = Double.parseDouble(list.item(3).getTextContent());
			double distanceBetweenFloors = Double.parseDouble(list.item(4).getTextContent());
			// charger fichier xml et mettre les données pour construire les objets de l'elevator
			ElevatorShaft ES = new ElevatorShaft(elevatorHeight, floorNumber, distanceBetweenFloors, doorTime, speed);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
