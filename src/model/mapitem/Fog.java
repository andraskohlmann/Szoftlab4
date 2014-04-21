package model.mapitem;

import model.ActiveUnit;

public class Fog implements ActiveUnit {

	private Tile tileToNotify;
	
	private int timeToLeave;

	public int getDistanceReduction() {
		return 0;
	}

	@Override
	public void tick() {
		timeToLeave--;
		if (timeToLeave == 0) {
			tileToNotify.removeFog(this);
		}
	}

}
