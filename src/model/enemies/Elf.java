package model.enemies;

import model.Common;
import model.Game;
import model.mapitem.Road;
import model.runes.Projectile;
import model.runes.Slime;

public class Elf extends EnemyUnit {

	public Elf(Road r, Game g) {
		roadToNotice = r;
		gameToNotice = g;
	}

	public Elf(Game g) {
		gameToNotice = g;
		health = Common.lifeDwarf;
		tickDivider = Common.tickDwarf;
		counter = 0;
	}

	public Elf() {
	}
	
	public Elf(Elf e) {
		e.health *= 0.5;
		this.gameToNotice = e.gameToNotice;
		this.health = e.health;
	}

	public void gotHit(Projectile p) {
		if (p.isSplitter()) {
			Elf newHalf = new Elf();
			
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