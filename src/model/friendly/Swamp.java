package model.friendly;

import java.util.ArrayList;
import java.util.List;

import model.ActiveUnit;
import model.Common;
import model.enemies.EnemyUnit;
import model.runes.Rune;
import model.runes.Slime;

public class Swamp implements ActiveUnit, FriendlyUnit {

	private List<EnemyUnit> enemyUnits = new ArrayList<EnemyUnit>();
	private Rune rune;

	private int tickDivider = Common.swamp_counter;
	private int counter;
	private boolean isUpgraded;
	
	public Swamp() {
		isUpgraded = false;
	}

	@Override
	public void tick() {
		counter++;
		if (counter == tickDivider) {
			counter = 0;

			if (enemyUnits.size() > 0) {

				Slime slime = new Slime();
				rune.modifySlime(slime);

				for (EnemyUnit enemy : enemyUnits) {
					enemy.gotSlowed(slime);
				}

			}
		}
	}

	@Override
	public boolean checkRune() {
		return !isUpgraded;
	}

	@Override
	public void putRune(Rune r) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addUnit(EnemyUnit enemyUnit) {
		enemyUnits.add(enemyUnit);
	}

	@Override
	public void removeUnit(EnemyUnit e) {
		enemyUnits.remove(e);
	}

	public void Skeleton_addUnit(EnemyUnit e) {
		enemyUnits.add(e);
	}

}
