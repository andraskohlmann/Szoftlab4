package model.friendly;

import java.util.ArrayList;
import java.util.List;

import model.ActiveUnit;
import model.enemies.EnemyUnit;
import model.runes.Rune;
import model.runes.Slime;

import common.Common;

public class Swamp implements ActiveUnit, FriendlyUnit {

	private List<EnemyUnit> enemyUnits = new ArrayList<EnemyUnit>();
	private Rune rune;
	private int tickDivider = Common.swamp_counter;
	private int counter;
	private boolean isUpgraded;

	private Object view;

	public void setView(Object v) {
		view = v;
	}

	public Object getView() {
		return view;
	}

	public Swamp() {
		tickDivider = 10;
		counter = 0;
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
	public boolean checkRune(Rune r) {
		if (!r.availableForSwamp())
			return false;
		return !isUpgraded;
	}

	@Override
	public void putRune(Rune r) {
		rune = r;
		isUpgraded = true;
	}

	public void putFirstRune(Rune r) {
		rune = r;
		isUpgraded = false;
	}

	@Override
	public void addUnit(EnemyUnit enemyUnit) {
		enemyUnits.add(enemyUnit);
	}

	@Override
	public void removeUnit(EnemyUnit e) {
		enemyUnits.remove(e);
	}
	public Rune getRune() {
		return rune;
	}

}
