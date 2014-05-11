package common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.EnemyType;
import model.Game;

public class Strategy implements ActionListener {

	private Game game;
	private int ticks = 0;

	public Strategy(Game g) {
		game = g;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		ticks++;
		
		game.tick();
	
		if (ticks > 10 && ticks % 50 == 0) {
			game.addUnit(EnemyType.elf);
		}
	}
}
