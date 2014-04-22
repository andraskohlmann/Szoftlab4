package model.mapitem;

import java.util.ArrayList;
import java.util.List;

import model.enemies.EnemyUnit;

public class FinishedRoad extends Road {

	List<EnemyUnit> unitList = new ArrayList<EnemyUnit>();

	@Override
	public void addUnit(EnemyUnit e) {
		unitList.add(e);
	}

	public List<EnemyUnit> getFinishedUnits() {
		return unitList;
	}

	public void deleteFinishedUnits() {
		unitList.clear();
	}
	
}
