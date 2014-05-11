package model.mapitem;

import java.util.ArrayList;
import java.util.List;

import model.friendly.Swamp;
import model.friendly.Tower;
import model.runes.Rune;

public abstract class Tile {

	private List<Tile> neighbours;
	protected List<Road> nextRoad = new ArrayList<Road>();

	protected Fog fog;

	public void addNextRoad(Road next) {
		nextRoad.add(next);
	}

	public boolean checkTower() {
		return false;
	}

	public void putTower(Tower t) {
		return;
	}

	public boolean checkRune(Rune r) {
		return false;
	}

	public void addFog(Fog f) {
		fog = f;
		fog.setTile(this);
	}

	public void removeFog(Fog f) {
		fog = null;
	}

	public boolean hasFog() {
		return fog != null;
	}

	public Fog getFog() {
		return fog;
	}

	public abstract void putRune(Rune r);

	public boolean checkSwamp() {
		return false;
	}

	public void putSwamp(Swamp s) {
		return;
	}

	public void addTower(int distance, Tower t) {
		if (distance < 1)
			return;
		for (Tile neighbour : neighbours) {
			neighbour.addTower(distance - 1, t);
		}
	}

	public void removeTower(int distance, Tower t) {
		if (distance < 1)
			return;
		for (Tile neighbour : neighbours) {
			neighbour.removeTower(distance - 1, t);
		}
	}

	public void addNeighbours(List<Tile> neighbourList) {
		neighbours = neighbourList;
	}

	public void setSucceedingRoads(List<Tile> nextRoads) {

	}

}
