package view;

import javax.swing.JFrame;

import model.Game;

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

		board.setVisible(true);
	}
}
