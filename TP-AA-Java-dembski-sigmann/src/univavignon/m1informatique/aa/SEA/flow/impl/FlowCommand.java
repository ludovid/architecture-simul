package univavignon.m1informatique.aa.SEA.flow.impl;

import univavignon.m1informatique.aa.SEA.sequencer.api.Sequenceur;

/* Classe visant � contr�ler 
 * 
 */


public class FlowCommand {
	
	// permet de lancer la stimulation
	public void start(Sequenceur seq){
		
		seq.start();
	}
	}


