package th.co.scb.quest;

import java.util.LinkedList;

public class Island {

	private LinkedList<Bridge> bridges = new LinkedList<Bridge>();
	
	public LinkedList<Bridge> getBridges() {
		return bridges;
	}
	
	public void addBridge(Bridge bridge){
		bridges.add(bridge);
	}
	
	public void removeBridge(Bridge bridge){
		bridges.remove(bridge);
	}

}
