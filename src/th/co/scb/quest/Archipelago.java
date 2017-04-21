package th.co.scb.quest;

public class Archipelago {

	private Object[] islands;
	private int day;
	
	public void createIslands(int numberOfIsland) {
		islands = new Object[numberOfIsland];
	}

	public Object[] getIslands() {
		return islands;
	}

	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
}
