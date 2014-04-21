package model.enemies;

import model.Game;
import model.mapitem.Road;
import model.runes.Projectile;
import model.runes.Slime;

public class Man extends EnemyUnit {

	public Man(Road r, Game g) {
		roadToNotice = r;
		gameToNotice = g;
	}

	public Man(Game g) {
		gameToNotice = g;
	}

	public Man() {
	}

	public void gotHit(Projectile p) {
		health -= p.damageMe(this);

		if (health <= 0) {
			roadToNotice.deadNotice(this);
			gameToNotice.notifyIfDead(this);
		}
	}

	public void gotSlowed(Slime s) {
		counter -= s.slowMe(this);
	}
}