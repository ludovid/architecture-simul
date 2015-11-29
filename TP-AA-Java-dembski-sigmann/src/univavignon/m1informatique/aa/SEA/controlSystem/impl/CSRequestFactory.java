package univavignon.m1informatique.aa.SEA.controlSystem.impl;

import univavignon.m1informatique.aa.SEA.commontype.Direction;
import univavignon.m1informatique.aa.SEA.controlSystem.api.IControlSystem;
import univavignon.m1informatique.aa.SEA.elevatorUI.api.IElevatorUIRequest;

public class CSRequestFactory implements IControlSystem {

	public CSRequest request;
	
	@Override
	public void stopRequest(int level, Direction direction, IElevatorUIRequest uiRequest) {
		request = new CSRequest(level, direction, uiRequest);
		RequestList.addRequest(request);
	}
	
}
