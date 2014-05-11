package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Game;
import model.runes.DwarfRune;
import model.runes.ElfRune;
import model.runes.HobbitRune;
import model.runes.ManRune;
import model.runes.RangeRune;
import model.runes.ReloadRune;
import model.runes.Rune;
import common.Common;
import control.Control;
import control.Control.ClickState;

/**
 * 
 * A játék paneljának objektuma
 * 
 */
public class GameView extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Felsõ réteg a kirajzolásban
	 */
	private Image bottomLayer;

	/**
	 * Tárolva az egyes modellbeli objektumok kirajzolásért felelõs párjai
	 */
	private List<ViewBase> views;

	private Control control;

	private Game game;

	private StatusPanel statusPanel = new StatusPanel();
	private Image gameOverScreen;

	/**
	 * Konstruktor, eseménykezelõ objektum hozzáadása
	 * 
	 * @param control
	 *            Control
	 */
	public GameView(Control c, Game g) {
		views = new ArrayList<ViewBase>();

		game = g;
		control = c;

		addMouseListener(c);
		addMouseMotionListener(c);

		try {
			gameOverScreen = ImageIO.read(new File("textures//gameover.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Új View hozzáadása
	 * 
	 * @param view
	 *            ViewBase
	 */
	public void addView(ViewBase view) {
		views.add(view);
	}

	/**
	 * Kirajzolásért felelõs függvény, minden tárolt View draw függvényét
	 * meghívja.Valamint az alsó réteget kirajzolja
	 * 
	 * @param graphics
	 *            Graphics
	 */
	@Override
	public void paintComponent(Graphics graphics) {

		if (game.isGameOver()) {
			graphics.drawImage(gameOverScreen, 0, 0, null);
			return;
		}

		statusPanel.setMagitzka(game.getMagitzka());
		statusPanel.setLife(game.getLife());
		statusPanel.repaint();

		if (bottomLayer == null) {
			initBottomLayer();
		}

		Graphics g = bottomLayer.getGraphics();

		for (ViewBase view : views) {
			view.draw(g);
		}

		graphics.drawImage(bottomLayer, 0, 0, null);
		int x = control.getMouseX();
		int y = control.getMouseY();
		if (control.getState() == Control.ClickState.tower) {

			if (game.checkTower(x, y)) {
				graphics.setColor(Color.GREEN);
				graphics.fillRect(y * Common.tileWidth, x * Common.tileWidth,
						Common.tileWidth, Common.tileWidth);
			} else {
				graphics.setColor(Color.RED);
				graphics.fillRect(y * Common.tileWidth, x * Common.tileWidth,
						Common.tileWidth, Common.tileWidth);
			}
		} else if (control.getState() == Control.ClickState.swamp) {

			if (game.checkSwamp(x, y)) {
				graphics.setColor(Color.GREEN);
				graphics.fillRect(y * Common.tileWidth, x * Common.tileWidth,
						Common.tileWidth, Common.tileWidth);
			} else {
				graphics.setColor(Color.RED);
				graphics.fillRect(y * Common.tileWidth, x * Common.tileWidth,
						Common.tileWidth, Common.tileWidth);
			}
		} else if (control.getState() != ClickState.none) {

			// /RUNES
			Rune rune = new Rune();
			ClickState clickState = control.getState();
			switch (clickState) {
			case man: {
				rune = new ManRune();
				break;
			}
			case hobbit: {
				rune = new HobbitRune();
				break;
			}
			case elf: {
				rune = new ElfRune();
				break;
			}
			case dwarf: {
				rune = new DwarfRune();
				break;
			}
			case reload: {
				rune = new ReloadRune();
				break;
			}
			case range: {
				rune = new RangeRune();
				break;
			}
			default:
				break;
			}
			if (game.checkRune(x, y, rune)) {
				graphics.setColor(Color.GREEN);
				graphics.fillRect(y * Common.tileWidth, x * Common.tileWidth,
						Common.tileWidth, Common.tileWidth);
			} else {
				graphics.setColor(Color.RED);
				graphics.fillRect(y * Common.tileWidth, x * Common.tileWidth,
						Common.tileWidth, Common.tileWidth);
			}
		}
		
		if (game.isGameOver()) {
			graphics.drawImage(gameOverScreen, 0, 0, null);
			return;
		}

	}

	/**
	 * Inicializálja az alsó réteget a megjelenítésben
	 */
	private void initBottomLayer() {
		bottomLayer = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_RGB);

		Graphics g = bottomLayer.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	public StatusPanel getStatusPanel() {
		return statusPanel;
	}

}
