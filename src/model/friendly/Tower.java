package model.friendly;

import java.util.ArrayList;
import java.util.List;

import model.ActiveUnit;
import model.enemies.EnemyUnit;
import model.runes.Projectile;
import model.runes.Rune;

public class Tower implements ActiveUnit, FriendlyUnit {

	private List<EnemyUnit> enemyUnits = new ArrayList<EnemyUnit>();
	private Rune rune;
	private EnemyUnit lastTarget;
	private String name = new String();
	private int tickDivider;
	private int counter;
	private boolean isUpgraded;

	public Tower() {
		tickDivider = 10;
		counter = 0;
		isUpgraded = false;
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
	public boolean checkRune(Rune r) {
		return !isUpgraded;
	}

	@Override
	public void putRune(Rune r) {
		rune = r;
		isUpgraded = true;
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

	public String ProtoType_getName() {
		return name;
	}
	
	public void ProtoType_setName(String n) {
		name = n;
	}

	public String ProtoType_getRune() {
		Class<?> cl = rune.getClass();

		return cl.getName();
	}

	public int ProtoType_getRuneDistance() {
		return rune.getDistance();
	}

	public int ProtoType_getCounter() {
		return counter;
	}
}
