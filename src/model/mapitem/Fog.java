package model.mapitem;

import model.ActiveUnit;
import model.Common;
import model.Game;

public class Fog implements ActiveUnit {

	private Tile tileToNotify;
	private Game gameToNotify;

	private int timeToLeave;

	public Fog(Game game, int ttl) {
		gameToNotify = game;
		timeToLeave = ttl;
	}

	public int getDistanceReduction() {
		return Common.fog_distancereduction;
	}

	@Override
	public void tick() {
		timeToLeave--;
		if (timeToLeave == 0) {
			tileToNotify.removeFog(this);
			gameToNotify.removeFog(this);
		}
	}

	public void setTile(Tile tile) {
		tileToNotify = tile;
	}

}
