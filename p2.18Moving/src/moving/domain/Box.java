package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing {
	private int maximumCapacity;
	private List<Thing> thingsList;

	public Box(int maximumCapacity) {
		this.maximumCapacity = maximumCapacity;
		this.thingsList = new ArrayList<Thing>();
	}

	public boolean addThing(Thing thing) {
		if (this.getVolume() + thing.getVolume() <= maximumCapacity) {
			this.thingsList.add(thing);
			return true;
		}
		return false;
	}

	@Override
	public int getVolume() {
		int currentVolume = 0;
		for (Thing thing : thingsList) {
			currentVolume += thing.getVolume();
		}
		return currentVolume;
	}

}
