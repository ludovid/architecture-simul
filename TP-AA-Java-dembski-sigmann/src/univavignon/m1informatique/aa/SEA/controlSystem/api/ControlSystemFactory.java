package univavignon.m1informatique.aa.SEA.controlSystem.api;

import univavignon.m1informatique.aa.SEA.controlSystem.impl.CSRequestFactory;

/**
 * 
 * @author uapv1102294
 */
public final class ControlSystemFactory {

	/**
	 * 
	 * @return
	 */
	public static IControlSystem createControlSystem(/*final IElevatorCommand command*/ ) {
		return new CSRequestFactory(/*command*/);
	}

}
