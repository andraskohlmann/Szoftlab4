package model;

import java.util.ArrayList;
import java.util.List;

import model.enemies.EnemyUnit;
import control.SkeletonUI;
import model.friendly.Tower;

public class Ticker {

	private List<ActiveUnit> unitList = new ArrayList<ActiveUnit>();

	public void tick() {
		SkeletonUI.enterFunction(this, "tick");			
		
		unitList.get(0).tick();
		
        SkeletonUI.leaveFunction();
	}

	public void remove(List<EnemyUnit> unitList) {
		SkeletonUI.enterFunction(this, "remove", unitList);

		SkeletonUI.leaveFunction();
	}
	
	public void Skeleton_addUnit(ActiveUnit a) {
		unitList.add(a);
	}
	
}
