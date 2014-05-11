package model.enemies;

import model.Game;
import model.runes.Projectile;
import model.runes.Slime;
import view.ViewFactory;

import common.Common;

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
		if (p.isSplitter() && health > 1) {
			System.out.println("SPLIT");
			Elf newHalf = new Elf(this);
			newHalf.setView(ViewFactory.createView(newHalf));

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