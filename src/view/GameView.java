package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

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
 * A j�t�k panelj�nak objektuma
 * 
 */
public class GameView extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * Fels� r�teg a kirajzol�sban
	 */
	private Image bottomLayer;
	/**
	 * T�rolva az egyes modellbeli objektumok kirajzol�s�rt felel�s p�rjai
	 */
	private List<ViewBase> views;

	private Control control;

	private Game game;
	

	/**
	 * Konstruktor, esem�nykezel� objektum hozz�ad�sa
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
	}

	/**
	 * �j View hozz�ad�sa
	 * 
	 * @param view
	 *            ViewBase
	 */
	public void addView(ViewBase view) {
		views.add(view);
	}

	/**
	 * Kirajzol�s�rt felel�s f�ggv�ny, minden t�rolt View draw f�ggv�ny�t
	 * megh�vja.Valamint az als� r�teget kirajzolja
	 * 
	 * @param graphics
	 *            Graphics
	 */
	@Override
	public void paintComponent(Graphics graphics) {
		
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
	}

	/**
	 * Inicializ�lja az als� r�teget a megjelen�t�sben
	 */
	private void initBottomLayer() {
		bottomLayer = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_RGB);

		Graphics g = bottomLayer.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	public int getMagitzka()
	{
		System.out.println(game.getMagitzka());
		return game.getMagitzka();
	}

}
