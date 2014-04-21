package model.runes;

import model.enemies.Dwarf;
import model.enemies.Elf;
import model.enemies.Hobbit;
import model.enemies.Man;

public class Projectile {

	private int dmgToDwarf = 0;
	private int dmgToHobbit = 0;
	private int dmgToElf = 0;
	private int dmgToMan = 0;

	private boolean isSplitter = false;

	public int damageMe(Dwarf d) {
		return dmgToDwarf;
	}

	public int damageMe(Hobbit h) {
		return dmgToHobbit;
	}

	public int damageMe(Elf e) {
		return dmgToElf;
	}

	public int damageMe(Man m) {
		return dmgToMan;
	}

	public void setDamage(Rune r) {
		dmgToDwarf = r.dmgDwarf;
		dmgToHobbit = r.dmgHobbit;
		dmgToElf = r.dmgElf;
		dmgToMan = r.dmgMan;
	}

	public boolean isSplitter() {
		return isSplitter;
	}
}