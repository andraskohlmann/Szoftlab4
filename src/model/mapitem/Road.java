package model.mapitem;

import java.util.ArrayList;
import java.util.List;

import view.View;
import view.mapitem.RoadView;

import model.enemies.EnemyUnit;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.runes.Rune;
import control.ProtoManager;
import control.RandomStates;

public class Road extends Tile {

	private List<EnemyUnit> enemyList = new ArrayList<EnemyUnit>();
	private Swamp swamp;
	private List<Tower> towersToNotify = new ArrayList<Tower>();
    private View view;
	
    public Road()
    {
    	
    }
    public Road(RoadView v)
    {
    	view = v;
    }
	public boolean checkSwamp() {
		if (swamp == null)
			return true;
		return false;
	}

	public void addTower(int distance, Tower t) {
		if (!towersToNotify.contains(t)) {
			towersToNotify.add(t);
			super.addTower(distance, t);
		}
	}

	public void removeTower(int distance, Tower t) {
		towersToNotify.remove(t);
		super.removeTower(distance, t);
	}

	public void putRune(Rune r) {
		swamp.putRune(r);
		view.notifyView();
	}

	public void deadNotice(EnemyUnit e) {
		for (Tower t : towersToNotify)
			t.removeUnit(e);

		if (swamp != null) {
			swamp.removeUnit(e);
		}

		enemyList.remove(e);
		
		view.notifyView();
		
	}

	public boolean checkRune(Rune r) {
		if (checkSwamp())
			return false;
		return swamp.checkRune(r);
	}

	public void putSwamp(Swamp s) {
		swamp = s;
		view.notifyView();
	}

	public void addUnit(EnemyUnit e) {
		enemyList.add(e);

		for (Tower t : towersToNotify) {
			t.addUnit(e);
		}

		if (swamp != null) {
			swamp.addUnit(e);
		}

		e.setRoad(this);
		view.notifyView();
	}

	public void stepMe(EnemyUnit enemyUnit) {

		enemyList.remove(enemyUnit);

		for (Tower t : towersToNotify) {
			t.removeUnit(enemyUnit);
		}

		if (swamp != null) {
			swamp.removeUnit(enemyUnit);
		}

		int which = (ProtoManager.randomRouting == RandomStates.on) ? ProtoManager
				.randomInt(nextRoad.size()) : 0;

		nextRoad.get(which).addUnit(enemyUnit);
		view.notifyView();
	}

	public void addNextRoad(Road next) {
		nextRoad.add(next);
	}

	public boolean hasNext() {
		if (nextRoad.isEmpty())
			return false;
		return true;
	}

	public boolean hasSwamp() {
		if (swamp != null)
			return true;
		else
			return false;

	}

	public Swamp Prototype_getSwamp() {
		return swamp;
	}

	public List<EnemyUnit> ProtoType_getList() {
		return enemyList;
	}
}
