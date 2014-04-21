package model.enemies;

import model.ActiveUnit;
import model.Game;
import model.mapitem.Road;
import model.runes.Projectile;
import model.runes.Slime;

public abstract class EnemyUnit implements ActiveUnit {
	protected Road roadToNotice;
	protected Game gameToNotice;
	
	protected int health;
	
	protected int tickDivider;
	protected int counter;

	public abstract void gotHit(Projectile p);

	public abstract void gotSlowed(Slime s);
	
	public void setRoad(Road r) {
		roadToNotice = r;
	}
	
	public void setGame(Game game) {
		gameToNotice = game;
	}

	public void tick() {
		counter++;
		if (counter == tickDivider) {
			counter = 0;
			
			roadToNotice.stepMe(this);
		}
	}
}
