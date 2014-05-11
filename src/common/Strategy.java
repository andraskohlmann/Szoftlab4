package common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.EnemyType;
import model.Game;

public class Strategy implements ActionListener {

	private Game game;
	private int ticks = 0;
	private int currentDelay = firstDelay;
	private int currentWave = firstWave;
	private int currentRep = firstRep;
	private int waves = 0;
	private int fogNumber = 0;

	private static final int second = 50;
	private static final int firstDelay = 5;
	private static final int firstWave = 10;
	private static final int firstRep = 130;

	private static final int addDelay = 1;
	private static final int addWave = 10;
	private static final int subRep = 10;

	private static final int maxWaves = 12;

	public Strategy(Game g) {
		game = g;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		ticks++;
		game.tick();

		if (waves > maxWaves) {
			return;
		}

		if (ticks > currentDelay * second) {
			if (ticks % currentRep == 0) {
				addRandomunit();
			}
			if (ticks > currentWave * second) {
				ticks = 0;
				currentDelay += addDelay;
				currentWave += addWave;
				currentRep -= subRep;
				waves++;
			}
		}
		
		
		fogNumber++;
		if (fogNumber > Common.fog_timetoleave / Common.fog_simultaniousfognumber) {
			game.putFog(Randomizer.randomInt(game.getMap().getWidth()), Randomizer.randomInt(game.getMap().getHeight()));
			fogNumber = 0;
		}
		
	}

	private void addRandomunit() {
		if (waves == 3) {
			game.addUnit(EnemyType.man);
		} else if (waves == 5) {
			game.addUnit(EnemyType.hobbit);
		} else if (waves == 7) {
			game.addUnit(EnemyType.dwarf);
		} else if (waves == 9) {
			game.addUnit(EnemyType.elf);
		} else {
			switch (Randomizer.randomInt(4)) {
			case 0:
				game.addUnit(EnemyType.dwarf);
				break;
			case 1:
				game.addUnit(EnemyType.elf);
				break;
			case 2:
				game.addUnit(EnemyType.hobbit);
				break;
			case 3:
				game.addUnit(EnemyType.man);
				break;
			default:
				break;
			}
		}
	}
}
