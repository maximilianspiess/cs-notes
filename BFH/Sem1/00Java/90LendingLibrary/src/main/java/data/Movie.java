package data;

import java.util.ArrayList;
import java.util.List;

public class Movie extends LendingItem {
	private List<Actor> actors;

	public Movie(int id, String title) {
		super(id, title);
		this.actors = new ArrayList<>();
	}

	public Movie(int id, String title, List<Actor> actors) {
		this(id, title);
		this.actors = actors;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void addActor(Actor actor) {
		this.actors.add(actor);
	}

	public String toString() {
		String actorString = "";
		for (int i = 0; i < actors.size(); i++) {
			actorString = actorString + actors.get(i).toString() + "\n";
		}
		return super.toString() + ", Actors: " + actorString;
	}
}
