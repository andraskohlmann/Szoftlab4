package model.friendly;

import model.ActiveUnit;
import model.enemies.EnemyUnit;
import model.runes.Rune;

public interface FriendlyUnit extends ActiveUnit {
	public boolean checkRune(Rune r);

	public void putRune(Rune r);

	public void addUnit(EnemyUnit enemyUnit);

	public void removeUnit(EnemyUnit enemyUnit);
}
