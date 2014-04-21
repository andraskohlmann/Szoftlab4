package model.enemies;

import model.Common;
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
		health = Common.lifeDwarf;
		tickDivider = Common.tickDwarf;
		counter = 0;
	}

	public Hobbit() {
	}
	
	public Hobbit(Hobbit h) {
		this(h.gameToNotice);
		h.health *= 0.5;
		this.gameToNotice = h.gameToNotice;
		this.health = h.health;
	}

	public void gotHit(Projectile p) {
		if (p.isSplitter()) {
			Hobbit newHalf = new Hobbit(this);
			
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