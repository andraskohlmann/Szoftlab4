package model.friendly;

import java.util.ArrayList;
import java.util.List;

import model.ActiveUnit;
import model.enemies.EnemyUnit;
import model.runes.Projectile;
import model.runes.Rune;
import control.SkeletonUI;

public class Tower implements ActiveUnit, FriendlyUnit {

	private List<EnemyUnit> enemyUnits = new ArrayList<EnemyUnit>();
	private Rune rune;
	private EnemyUnit lastTarget;

	@Override
	public void tick() {
		SkeletonUI.enterFunction(this, "tick");

		if (SkeletonUI.booleanQuestion("Is the tower ready to shoot?")) {
			if (SkeletonUI.booleanQuestion("Does the tower see the previous target?")) {
	
				lastTarget = enemyUnits.get(0);
				
				Projectile p = new Projectile();
				SkeletonUI.addObject(p, "p", true);
				rune.modifyProjectile(p);
	
				lastTarget.gotHit(p);
			}
			else if (SkeletonUI.booleanQuestion("Does it see any target?")) {
				
				Projectile p = new Projectile();
				SkeletonUI.addObject(p, "p", true);
				rune.modifyProjectile(p);
				
				enemyUnits.get(0).gotHit(p);
			}
		}
		
		SkeletonUI.leaveFunction();
	}

	@Override
	public boolean checkRune() {
		// TODO Auto-generated method stub
		SkeletonUI.enterFunction(this, "checkRune");

		String answer = SkeletonUI
				.stringQuestion(
						"What kind of rune is in the tower? (Default, dWarf, Elf, Man, Hobbit, Range, reLoad) \n" +
						"/Rune can be put only to tower with default rune./",
						"D", "W", "E", "M", "H", "R", "L");

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
		// TODO Auto-generated method stub
		SkeletonUI.enterFunction(this, "removeUnit", e);

		SkeletonUI.leaveFunction();
	}

	public void Skeleton_addUnit(EnemyUnit enemyUnit) {
		enemyUnits.add(enemyUnit);
	}

	public void Skeleton_addRune(Rune r) {
		rune = r;
	}
}
