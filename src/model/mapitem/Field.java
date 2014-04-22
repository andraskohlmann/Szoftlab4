package model.mapitem;

import model.friendly.Tower;
import model.runes.Rune;

public class Field extends Tile {
	private Tower tower;

	public void Skeleton_TowerSetter(Tower t) {
		tower = t;
	}

	public boolean checkTower() {
		if (tower == null)
			return true;
		return false;
	}

	public void putRune(Rune r) {
		tower.putRune(r);
		addTower(r.getDistance(), tower);
	}

	public void putTower(Tower t) {
		tower = t;
	}

	public boolean checkRune(Rune r) {
		if (tower != null)
			return tower.checkRune(r);
		return false;
	}

	public void addFog(Fog f) {
		if (tower == null)
			return;
		removeTower(tower.getRune().getDistance(), tower);
		addTower(tower.getRune().getDistance() - f.getDistanceReduction(),
				tower);
		f.setTile(this);
		super.addFog(f);
	}

	public void removeFog(Fog f) {
		removeTower(tower.getRune().getDistance() - f.getDistanceReduction(),
				tower);
		addTower(tower.getRune().getDistance(), tower);
		super.removeFog(f);
	}

	public boolean hasTower() {
		if (tower != null)
			return true;
		else
			return false;

	}

	public Tower Prototype_getTower() {
		return tower;
	}
}
