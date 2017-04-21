package th.co.scb.quest;

public class Archipelago {

	private Object[] islands;
	
	public void createIslands(int i) {
		islands = new Object[i];
	}

	public Object[] getIslands() {
		return islands;
	}

}
