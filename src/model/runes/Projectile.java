package model.runes;

import control.ProtoManager;
import control.RandomStates;
import model.enemies.Dwarf;
import model.enemies.Elf;
import model.enemies.Hobbit;
import model.enemies.Man;

public class Projectile {

	private int dmgToDwarf = 0;
	private int dmgToHobbit = 0;
	private int dmgToElf = 0;
	private int dmgToMan = 0;

	private boolean isSplitter;
	
	public Projectile() {
		if (ProtoManager.randomSplitting == RandomStates.random) {
			isSplitter = ProtoManager.randomBoolean(10);
		} else if (ProtoManager.randomSplitting == RandomStates.on) {
			isSplitter = true;
		} else {
			isSplitter = false;
		}
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