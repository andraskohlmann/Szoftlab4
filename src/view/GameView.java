package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import control.Control;

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

	/**
	 * Konstruktor, eseménykezelõ objektum hozzáadása
	 * 
	 * @param control
	 *            Control
	 */
	public GameView(Control control) {
		views = new ArrayList<ViewBase>();

		addMouseListener(control);
		// board.addMouseMotionListener(control);
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
		if (bottomLayer == null) {
			initBottomLayer();
		}

		Graphics g = bottomLayer.getGraphics();

		for (ViewBase view : views) {
			view.draw(g);
		}

		graphics.drawImage(bottomLayer, 0, 0, null);

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

}
