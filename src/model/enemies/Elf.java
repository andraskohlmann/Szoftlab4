package model.enemies;

import model.Game;
import model.mapitem.Road;
import model.runes.Projectile;
import model.runes.Slime;
import control.SkeletonUI;


public class Elf extends EnemyUnit {

	public Elf(Road r, Game g) {
		roadToNotice = r;
		gameToNotice = g;
	}

	public Elf(Game g) {
		gameToNotice = g;
	}

	public Elf() {
	}

	public void gotHit(Projectile p) {
		SkeletonUI.enterFunction(this, "gotHit", p);

		p.damageMe(this);

		if (SkeletonUI.booleanQuestion("Is the enemy unit dead?")) {
			roadToNotice.deadNotice(this);
			gameToNotice.notifyIfDead(this);
		}

		SkeletonUI.leaveFunction();
	}

	public void gotSlowed(Slime s) {
		SkeletonUI.enterFunction(this, "gotSlowed", s);

		SkeletonUI.leaveFunction();
	}
}