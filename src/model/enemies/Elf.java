package model.enemies;

import common.Common;

import model.Game;
import model.runes.Projectile;
import model.runes.Slime;

public class Elf extends EnemyUnit {

	public Elf(Game g) {
		gameToNotice = g;
		health = Common.lifeElf;
		tickDivider = Common.tickElf;
		counter = 0;
	}

	public Elf(Elf e) {
		this(e.gameToNotice);
		e.health *= 0.5;
		this.gameToNotice = e.gameToNotice;
		this.health = e.health;
	}

	public void gotHit(Projectile p) {
		if (p.isSplitter()) {
			Elf newHalf = new Elf(this);

			roadToNotice.addUnit(newHalf);

			gameToNotice.addUnit(newHalf);
		} else {
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