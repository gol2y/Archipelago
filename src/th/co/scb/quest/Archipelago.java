package th.co.scb.quest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Archipelago {

	private static final String SEPERATOR = " ";
	public static final String INVALID_ISLAND_MSG = "[FAIL] Invalid island";
	public static final String INVALID_COMMAND_LENGTH_MSG = "[FAIL] Invalid command length";
	public static final String INVALID_COMMAND_NUMERIC_MSG = "[FAIL] Command not numeric";
	public static final String INVALID_DAY_MSG = "[FAIL] Invalid day";
	
	private Island[] islands;
	private int day;
	
	public String order(String string) {
		return "";
	}
	
	public void initialWorld(String command) {
		int[] amount = validateAndSeperateCommand(command);
		createIslands(amount[0]);
		setDay(amount[1]);
	}
	
	public void createIslands(int numberOfIsland) {
		Stream<Island> islandsStream = Stream.generate(Island::new).limit(numberOfIsland);
		islands = islandsStream.toArray(Island[]::new);
	}
	

	public void build(int day, String command) {
		int[] islands = validateAndSeperateCommand(command);
		
		if(!isRealIsland(islands[0]) || !isRealIsland(islands[1]))
			throw new RuntimeException(INVALID_ISLAND_MSG);
		
		if(day > this.day)
			throw new RuntimeException(INVALID_DAY_MSG);
			
		Bridge bridge = new Bridge(day, islands[0], islands[1]);
		
		getIsland(islands[0]).addBridge(bridge);
		getIsland(islands[1]).addBridge(bridge);
	}
	
	public String check(String command){
		int[] islands = validateAndSeperateCommand(command);
		int from = islands[0];
		int to = islands[1];
		String message = "";
		
		Bridge oldestBridge = findNewestRouteOldestBridge(from,to, new TreeSet<Integer>(), new Bridge());
		
		if(oldestBridge.getCreateDate() > 0){
			message = "YES " + oldestBridge.getCreateDate();
			removeBridge(oldestBridge);
		} else {
			message = "NO";
		}
		
		return message;
	}

	private Bridge findNewestRouteOldestBridge(int now, int destination, Set<Integer> visitedIsland, Bridge oldestBridgeInRoute){
		
		visitedIsland.add(now);
		
		Iterator<Bridge> iterator = getIsland(now).getBridges().descendingIterator();
		while(iterator.hasNext()){
			Bridge bridge = iterator.next();
			
			oldestBridgeInRoute = chooseOldestBridge(oldestBridgeInRoute, bridge);
			int nextIsland = chooseNextIsland(now, bridge);
			
			if(nextIsland == destination){
				return oldestBridgeInRoute;
			} else if(!visitedIsland.contains(nextIsland)){
				Bridge oldestBridge = findNewestRouteOldestBridge(nextIsland, destination, visitedIsland, oldestBridgeInRoute);
				if(oldestBridge.getCreateDate() > 0) 
					return oldestBridge;
			}
		}
		
		return new Bridge();
	}
	
	private Bridge chooseOldestBridge(Bridge present, Bridge candidate){
		if(candidate.getCreateDate() < present.getCreateDate() || present.getCreateDate() == 0)
			return candidate;
		else
			return present;
	}
	
	private int chooseNextIsland(int activeIsland, Bridge bridge){
		if(bridge.getToIsland() == activeIsland)
			return bridge.getFromIsland();
		else
			return bridge.getToIsland();
	}
	
	private void removeBridge(Bridge bridge){
		getIsland(bridge.getFromIsland()).removeBridge(bridge);
		getIsland(bridge.getToIsland()).removeBridge(bridge);
	}
	
	private boolean isRealIsland(int number){
		return 0 < number && number <= islands.length;
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

	private int[] validateAndSeperateCommand(String command){
		String[] suits = command.split(SEPERATOR);
		int[] commands;
		
		if(suits.length != 2 )
			throw new RuntimeException(INVALID_COMMAND_LENGTH_MSG);
		
		try{
			commands = Arrays.stream(suits).mapToInt(Integer::parseInt).toArray();
		} catch(Exception ex){
			throw new RuntimeException(INVALID_COMMAND_NUMERIC_MSG);
		}
		
		return commands;
	}


}
