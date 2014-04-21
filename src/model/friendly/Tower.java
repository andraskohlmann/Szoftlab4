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

	private int tickDivider;
	private int counter;

	public Tower() {
		tickDivider = 10;
		counter = 0;
	}

	@Override
	public void tick() {
		counter++;
		if (counter == tickDivider) {
			counter = 0;

			/* következõ célpont kiválasztása */
			if (lastTarget == null || !enemyUnits.contains(lastTarget)) {
				if (enemyUnits.size() > 0) {
					lastTarget = enemyUnits.get(0);
				} else {
					lastTarget = null;
				}
			}

			/* ha van végülis lehetséges célpont */
			if (lastTarget != null) {
				Projectile projectile = new Projectile();
				rune.modifyProjectile(projectile);

				lastTarget.gotHit(projectile);
			}
		}
	}

	@Override
	public boolean checkRune() {
		// TODO Auto-generated method stub
		SkeletonUI.enterFunction(this, "checkRune");

		String answer = SkeletonUI
				.stringQuestion(
						"What kind of rune is in the tower? (Default, dWarf, Elf, Man, Hobbit, Range, reLoad) \n"
								+ "/Rune can be put only to tower with default rune./",
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
		enemyUnits.add(enemyUnit);
	}

	@Override
	public void removeUnit(EnemyUnit e) {
		enemyUnits.remove(e);
	}

	public void Skeleton_addUnit(EnemyUnit enemyUnit) {
		enemyUnits.add(enemyUnit);
	}

	public void Skeleton_addRune(Rune r) {
		rune = r;
	}
	
	public Rune getRune() {
		return rune;
	}
}
