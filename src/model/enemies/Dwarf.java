package model.enemies;

import model.Common;
import model.Game;
import model.mapitem.Road;
import model.runes.Projectile;
import model.runes.Slime;

public class Dwarf extends EnemyUnit {

	public Dwarf(Road r, Game g) {
		roadToNotice = r;
		gameToNotice = g;
	}

	public Dwarf(Game g) {
		gameToNotice = g;
		health = Common.lifeDwarf;
		tickDivider = Common.tickDwarf;
		counter = 0;
	}

	public Dwarf() {
	}
	
	public Dwarf(Dwarf d) {
		this(d.gameToNotice);
		d.health *= 0.5;
		this.gameToNotice = d.gameToNotice;
		this.health = d.health;
	}

	public void gotHit(Projectile p) {
		if (p.isSplitter()) {
			Dwarf newHalf = new Dwarf(this);
			
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