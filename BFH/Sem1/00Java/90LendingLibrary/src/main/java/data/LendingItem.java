package data;

public abstract class LendingItem {
    private final long id;
    private final String title;
    private State state; 
    
    public LendingItem(long id, String title) {
    	this.id = id;
        this.title = title;
        this.state = State.AVAILABLE;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    public boolean isAvailable() {
    	if (state == State.AVAILABLE){
    		return true;
    	}
		return false;
    }
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	public String toString() {
		return "ID: " + id + " Title: " + title;
	}
}

