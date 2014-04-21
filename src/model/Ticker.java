package model;

import java.util.ArrayList;
import java.util.List;

import model.enemies.EnemyUnit;
import control.SkeletonUI;

public class Ticker {

	private List<ActiveUnit> unitList = new ArrayList<ActiveUnit>();

	public void tick() {
		for (ActiveUnit unit : unitList) {
			unit.tick();
		}
	}

	public void remove(List<EnemyUnit> unitList) {
		SkeletonUI.enterFunction(this, "remove", unitList);

		SkeletonUI.leaveFunction();
	}

	public void remove(EnemyUnit e) {
		SkeletonUI.enterFunction(this, "remove", e);
		unitList.remove(e);
		SkeletonUI.leaveFunction();
	}

	public void Skeleton_remove(ActiveUnit e) {
		unitList.remove(e);
	}

	public void Skeleton_addUnit(ActiveUnit a) {
		unitList.add(a);
	}

	public void addUnit(EnemyUnit e) {
		SkeletonUI.enterFunction(this, "addUnit", e);
		unitList.add(e);
		SkeletonUI.leaveFunction();
	}

}
