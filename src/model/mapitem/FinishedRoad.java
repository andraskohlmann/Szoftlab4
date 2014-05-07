package model.mapitem;

import java.util.ArrayList;
import java.util.List;

import view.View;
import view.mapitem.FinishedRoadView;

import model.enemies.EnemyUnit;

public class FinishedRoad extends Road {
    private View view;
	List<EnemyUnit> unitList = new ArrayList<EnemyUnit>();
    public FinishedRoad(FinishedRoadView v)
    {
    	view  = v;
    }
	@Override
	public void addUnit(EnemyUnit e) {
		unitList.add(e);
		view.notifyView();
	}

	public List<EnemyUnit> getFinishedUnits() {
		return unitList;
	}

	public void deleteFinishedUnits() {
		unitList.clear();
		view.notifyView();
	}

}
