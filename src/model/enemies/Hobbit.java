package model.enemies;

import model.Game;
import model.mapitem.Road;
import model.runes.Projectile;
import model.runes.Slime;

public class Hobbit extends EnemyUnit {

	public Hobbit(Road r, Game g) {
		roadToNotice = r;
		gameToNotice = g;
	}

	public Hobbit(Game g) {
		gameToNotice = g;
	}

	public Hobbit() {
	}

	public void gotHit(Projectile p) {
		if (p.isSplitter()) {
			Hobbit newHalf = new Hobbit();
			
			roadToNotice.addUnit(newHalf);
			
			gameToNotice.addUnit(newHalf);
		}
		else {
			health -= p.damageMe(this);

			if (health <= 0) {
				roadToNotice.deadNotice(this);
				gameToNotice.notifyIfDead(this);
			}
		}
	}

	public void gotSlowed(Slime s) {
		counter -= s.slowMe(this);
	}
}