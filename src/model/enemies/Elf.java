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
		health -= p.damageMe(this);
		
		if (health <= 0) {
			roadToNotice.deadNotice(this);
			gameToNotice.notifyIfDead(this);
		}
	}

	public void gotSlowed(Slime s) {
		SkeletonUI.enterFunction(this, "gotSlowed", s);

		SkeletonUI.leaveFunction();
	}
}