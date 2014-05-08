package model.enemies;

import model.ActiveUnit;
import model.Game;
import model.mapitem.Road;
import model.runes.Projectile;
import model.runes.Slime;

public abstract class EnemyUnit implements ActiveUnit {

	protected Road roadToNotice;
	protected Game gameToNotice;

	protected String n = new String();

	protected int health;
	protected int tickDivider;
	protected int counter;
	
	protected Object view;
	
	public void setView(Object v) {
		view = v;
	}
	
	public Object getView() {
		return view;
	}

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
		return n;
	}

	public int ProtoType_getCounter() {
		return counter;
	}

	public void ProtoType_setName(String name) {
		n = name;
	}

	public int getParameters() {
		return health;
	}
}
