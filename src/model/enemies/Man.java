package model.enemies;

import model.Game;
import model.runes.Projectile;
import model.runes.Slime;
import view.ViewFactory;

import common.Common;

public class Man extends EnemyUnit {

	public Man(Game g) {
		gameToNotice = g;
		health = Common.lifeMan;
		tickDivider = Common.tickMan;
		counter = 0;
	}

	public Man(Man m) {
		this(m.gameToNotice);
		m.health *= 0.5;
		this.gameToNotice = m.gameToNotice;
		this.health = m.health;
	}

	public void gotHit(Projectile p) {
		if (p.isSplitter() && health > 1) {
			Man newHalf = new Man(this);
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