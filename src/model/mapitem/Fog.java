package model.mapitem;

import model.ActiveUnit;

public class Fog implements ActiveUnit {

	Tile tileToNotify;

	public int getDistanceReduction() {
		return 0;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

}
