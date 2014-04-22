package model.enemies;

import model.ActiveUnit;
import model.Game;
import model.mapitem.Road;
import model.runes.Projectile;
import model.runes.Slime;

public abstract class EnemyUnit implements ActiveUnit {
	protected Road roadToNotice;
	protected Game gameToNotice;
    protected String n;
	protected int health;
	protected String name;
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

	public int ProtoType_getHealth() {
		return health;
	}

	public String ProtoType_getName() {
		return name;
	}

	public int ProtoType_getCounter() {
		return counter;
	}
	public void ProtoType_setName(String name){
		n = name; 
	}
}
