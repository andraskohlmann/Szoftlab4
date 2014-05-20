package model.mapitem;

import java.util.ArrayList;
import java.util.List;

import model.enemies.EnemyUnit;
import model.runes.Rune;

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
	
	public boolean checkSwamp() {
		return false;
	}

	@Override
	public boolean checkRune(Rune r) {
		return false;
	}

}
