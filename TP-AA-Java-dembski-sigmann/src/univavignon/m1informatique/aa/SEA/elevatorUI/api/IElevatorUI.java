package univavignon.m1informatique.aa.SEA.elevatorUI.api;

import univavignon.m1informatique.aa.SEA.commontype.Direction;
import univavignon.m1informatique.aa.SEA.flow.api.IUser;

public interface IElevatorUI 
{

	void setIUser(IUser iUser);
	void stopRequest(int level, Direction direction, IElevatorUIRequest uiRequest);

}
