package th.co.scb.quest;

public class Archipelago {

	private Object[] islands;
	
	public void createIslands(int numberOfIsland) {
		islands = new Object[numberOfIsland];
	}

	public Object[] getIslands() {
		return islands;
	}

}
