package th.co.scb.quest;

import java.util.stream.Stream;

public class Archipelago {

	private Island[] islands;
	private int day;
	
	public void initialWorld(String command) {
		String[] amount = command.split(" ");
		createIslands(Integer.valueOf(amount[0]));
		setDay(Integer.valueOf(amount[1]));
	}
	
	public void createIslands(int numberOfIsland) {
		Stream<Island> islandsStream = Stream.generate(Island::new).limit(numberOfIsland);
		islands = islandsStream.toArray(Island[]::new);
	}

	public Island[] getIslands() {
		return islands;
	}

	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}


}
