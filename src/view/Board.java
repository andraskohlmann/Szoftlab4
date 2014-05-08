package view;

import javax.swing.JFrame;

import model.Game;
import control.EnemyType;
import control.RuneType;

public class Board extends JFrame {

	private static final long serialVersionUID = 1L;

	public Board() {
		setSize(600, 600);
		setResizable(false);
		setTitle("Tower Defense");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(100, 50);
	}

	public static void main(String[] args) {
		Board board = new Board();
		Game game = new Game();
		game.loadMap("3a.map");
		board.add(game.getView());

		game.putTower(6, 3, "Segglyuk");
		game.putSwamp(1, 2, "PICSA");
		
		game.addUnit(EnemyType.elf, "Buzikám");
		
		game.putRune(6, 3, RuneType.Range);
		game.putRune(1, 2, RuneType.Dwarf);
		

		board.setVisible(true);
		
		for (int i = 0; i < 1000; i++) {
			game.tick();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
