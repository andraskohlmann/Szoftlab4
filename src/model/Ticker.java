package model;

import java.util.ArrayList;
import java.util.List;

import model.enemies.EnemyUnit;

public class Ticker {

	private List<ActiveUnit> unitList = new ArrayList<ActiveUnit>();
	private List<ActiveUnit> removable = new ArrayList<ActiveUnit>();
	private List<ActiveUnit> toAdd = new ArrayList<ActiveUnit>();

	public void tick() {
		for (ActiveUnit unit : unitList) {
			unit.tick();
		}
		
		unitList.removeAll(removable);
		removable.clear();
		
		unitList.addAll(toAdd);
		toAdd.clear();
	}

	public void remove(List<EnemyUnit> unitList) {
		this.unitList.removeAll(unitList);
	}

	public void remove(ActiveUnit e) {
		removable.add(e);
	}

	public void addUnit(ActiveUnit e) {
		unitList.add(e);
	}

	public void concurrentAddUnit(EnemyUnit enemyUnit) {
		toAdd.add(enemyUnit);
	}

}
