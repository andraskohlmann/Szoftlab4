package model.runes;

import control.SkeletonUI;
import model.enemies.Dwarf;
import model.enemies.Elf;
import model.enemies.Hobbit;
import model.enemies.Man;

public class Projectile {
	public int damageMe(Dwarf d) {
		SkeletonUI.enterFunction(this, "damageMe", d);

		SkeletonUI.leaveFunction(0);
		return 0;
	}

	public int damageMe(Hobbit h) {
		SkeletonUI.enterFunction(this, "damageMe", h);

		SkeletonUI.leaveFunction(0);
		return 0;
	}

	public int damageMe(Elf e) {
		SkeletonUI.enterFunction(this, "damageMe", e);

		SkeletonUI.leaveFunction(0);
		return 0;
	}

	public int damageMe(Man m) {
		SkeletonUI.enterFunction(this, "damageMe", m);

		SkeletonUI.leaveFunction(0);
		return 0;

	}

	public void setDamage(Rune r) {
		SkeletonUI.enterFunction(this, "setDamage");

		SkeletonUI.leaveFunction(0);

	}
}