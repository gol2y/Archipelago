package th.co.scb.quest;

public class Bridge {

	private int createDate;
	private int fromIsland;
	private int toIsland;

	public Bridge(){}
	
	public Bridge(int day,int from, int to) {
		createDate = day;
		fromIsland = from;
		toIsland = to;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
        if (!(obj instanceof Bridge)) {
            return false;
        }
        Bridge bridge = (Bridge) obj;
        return createDate == bridge.getCreateDate() 
        		&& fromIsland == bridge.getFromIsland()
        		&& toIsland == bridge.getToIsland();
	}

	public int getCreateDate() {
		return createDate;
	}

	public void setCreateDate(int createDate) {
		this.createDate = createDate;
	}

	public int getFromIsland() {
		return fromIsland;
	}

	public void setFromIsland(int fromIsland) {
		this.fromIsland = fromIsland;
	}

	public int getToIsland() {
		return toIsland;
	}

	public void setToIsland(int toIsland) {
		this.toIsland = toIsland;
	}

}
