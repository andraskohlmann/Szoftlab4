package model.mapitem;

import java.util.ArrayList;
import java.util.List;

import model.enemies.EnemyUnit;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.runes.Rune;
import control.ProtoManager;
import control.SkeletonUI;

public class Road extends Tile {

	private List<EnemyUnit> enemyList = new ArrayList<EnemyUnit>();
	private Swamp swamp;
	private List<Tower> towersToNotify = new ArrayList<Tower>();
	private List<Road> nextRoad = new ArrayList<Road>();

	public void Skeleton_SwampSetter(Swamp s) {
		swamp = s;
	}

	public void Skeleton_addTower(Tower t) {
		towersToNotify.add(t);
	}

	public boolean checkSwamp() {
		if (swamp == null)
			return true;
		return false;
	}

	public void addTower(int distance, Tower t) {

	}

	public void putRune(Rune r) {
		swamp.putRune(r);
	}

	public void deadNotice(EnemyUnit e) {
		for (Tower t : towersToNotify)
			t.removeUnit(e);

		if (swamp != null) {
			swamp.removeUnit(e);
		}

		enemyList.remove(e);
	}

	public boolean checkRune() {
		if (!checkSwamp())
			return false;
		return swamp.checkRune();
	}

	public void putSwamp(Swamp s) {
		swamp = s;
	}

	public void addUnit(EnemyUnit e) {
		SkeletonUI.enterFunction(this, "addUnit", e);

		enemyList.add(e);

		if (SkeletonUI
				.booleanQuestion("Are there any towers to notify on the new road?"))
			for (Tower t : towersToNotify)
				t.addUnit(e);

		if (SkeletonUI.booleanQuestion("Is there a swamp on the new road?"))
			swamp.addUnit(e);

		e.setRoad(this);

		SkeletonUI.leaveFunction();
	}

	public void stepMe(EnemyUnit enemyUnit) {

		enemyList.remove(enemyUnit);

		for (Tower t : towersToNotify) {
			t.removeUnit(enemyUnit);
		}

		if (swamp != null) {
			swamp.removeUnit(enemyUnit);
		}

		int which = ProtoManager.randomRouting ? ProtoManager
				.randomInt(nextRoad.size()) : 0;

		nextRoad.get(which).addUnit(enemyUnit);
	}

	public void Skeleton_addNextRoad(Road next) {
	}

	public boolean hasNext() {
		if (nextRoad.isEmpty())
			return false;
		return true;
	}
}
