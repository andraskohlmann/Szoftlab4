package model.runes;

import model.enemies.Dwarf;
import model.enemies.Elf;
import model.enemies.Hobbit;
import model.enemies.Man;

import common.Common;
import common.Randomizer;

public class Projectile {

	private int dmgToDwarf = 0;
	private int dmgToHobbit = 0;
	private int dmgToElf = 0;
	private int dmgToMan = 0;

	private boolean isSplitter;

	public Projectile() {
		isSplitter = Randomizer.randomBoolean(Common.splitChance);
	}

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

	public void setDamage(int d, int h, int e, int m) {
		dmgToDwarf = d;
		dmgToHobbit = h;
		dmgToElf = e;
		dmgToMan = m;
	}

	public boolean isSplitter() {
		return isSplitter;
	}
}