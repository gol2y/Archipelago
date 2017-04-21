package th.co.scb.quest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class Archipelago {

	private static final String SEPERATOR = " ";
	private Island[] islands;
	private int day;
	
	public void initialWorld(String command) {
		int[] amount = seperateCommand(command);
		createIslands(amount[0]);
		setDay(amount[1]);
	}
	
	public void createIslands(int numberOfIsland) {
		Stream<Island> islandsStream = Stream.generate(Island::new).limit(numberOfIsland);
		islands = islandsStream.toArray(Island[]::new);
	}
	

	public void buildBridge(int day, String command) {
		int[] islands = seperateCommand(command);
		
		Bridge bridge = new Bridge(day, islands[0], islands[1]);
		
		getIsland(islands[0]).addBridge(bridge);
		getIsland(islands[1]).addBridge(bridge);
	}
	
	public String check(String command){
		int[] islands = seperateCommand(command);
		boolean hasRoute = false;
		String message = "";
		Bridge oldestBridge = new Bridge();
		
		Iterator<Bridge> iterator = getIsland(islands[0]).getBridges().descendingIterator();
		while(iterator.hasNext()){
			Bridge bridge = iterator.next();
			if(bridge.getToIsland() == islands[1] || bridge.getFromIsland() == islands[1]){
				hasRoute = true;
				oldestBridge = bridge;
			}
		}
		
		if(hasRoute){
			message = "YES " + oldestBridge.getCreateDate();
		} else {
			message = "NO";
		}
		
		return message;
	}

	public Island[] getIslands() {
		return islands;
	}
	
	public Island getIsland(int islandNumber) {
		return islands[islandNumber-1];
	}

	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}

	private int[] seperateCommand(String command){
		String[] suits = command.split(SEPERATOR);
		return Arrays.stream(suits).mapToInt(Integer::valueOf).toArray();
	}
}
