package model.friendly;

import java.util.ArrayList;
import java.util.List;

import model.ActiveUnit;
import model.enemies.EnemyUnit;
import model.runes.Rune;
import model.runes.Slime;
import control.SkeletonUI;

public class Swamp implements ActiveUnit, FriendlyUnit {

	private List<EnemyUnit> enemyUnits = new ArrayList<EnemyUnit>();
	private Rune rune;

	private int tickDivider;
	private int counter;

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
		// TODO Auto-generated method stub
		SkeletonUI.enterFunction(this, "checkRune");

		String answer = SkeletonUI.stringQuestion(
				"What kind of rune is in the swamp? (Default, dWarf, Elf, Man, Hobbit) \n"
						+ "/Rune can be put only to swamp with default rune./",
				"D", "W", "E", "M", "H");

		boolean available = (answer.equals("D"));

		SkeletonUI.leaveFunction(available);
		return available;
	}

	@Override
	public void putRune(Rune r) {
		// TODO Auto-generated method stub
		SkeletonUI.enterFunction(this, "putRune", r);

		SkeletonUI.leaveFunction();
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

	public void Skeleton_addRune(Rune r) {
		rune = r;
	}
}
