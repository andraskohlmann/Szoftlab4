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

	@Override
	public void tick() {
		SkeletonUI.enterFunction(this, "tick");

		if (SkeletonUI.booleanQuestion("Are there any units in the swamp?")) {

			Slime s = new Slime();
			SkeletonUI.addObject(s, "s", true);
			rune.modifySlime(s);

			enemyUnits.get(0).gotSlowed(s);
		}

		SkeletonUI.leaveFunction();
	}

	@Override
	public boolean checkRune() {
		// TODO Auto-generated method stub
		SkeletonUI.enterFunction(this, "checkRune");

		String answer = SkeletonUI
				.stringQuestion(
						"What kind of rune is in the swamp? (Default, dWarf, Elf, Man, Hobbit) \n" +
						"/Rune can be put only to swamp with default rune./",
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
		SkeletonUI.enterFunction(this, "addUnit", enemyUnit);
		enemyUnits.add(enemyUnit);
		SkeletonUI.leaveFunction();
	}

	@Override
	public void removeUnit(EnemyUnit e) {
		// Ez nem baj, ha meg van implementálva - Kohlmann
		SkeletonUI.enterFunction(this, "removeUnit", e);

		SkeletonUI.leaveFunction();
	}

	public void Skeleton_addUnit(EnemyUnit e) {
		enemyUnits.add(e);
	}

	public void Skeleton_addRune(Rune r) {
		rune = r;
	}
}
