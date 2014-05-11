package model.mapitem;

import common.Common;

import model.ActiveUnit;
import model.Game;

public class Fog implements ActiveUnit {

	private Tile tileToNotify;
	private Game gameToNotify;

	private int timeToLeave;
	
	private Object view;
	
	public void setView(Object v) {
		view = v;
	}
	
	public Object getView() {
		return view;
	}

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
