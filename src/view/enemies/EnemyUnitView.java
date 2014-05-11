package view.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.enemies.EnemyUnit;
import view.RelativeViewBase;

/**
 * 
 * Általános EnemyUnitView osztály mely felelõssége a különbözõ játékban
 * szereplõ ellenséges egységek megjelenítésének menedzselése.
 * 
 */
public abstract class EnemyUnitView implements RelativeViewBase {
	/**
	 * Kirajzolandó ellenséges egység
	 */
	private EnemyUnit enemyUnit;
	protected static BufferedImage dwarf;
	protected static BufferedImage elf;
	protected static BufferedImage hobbit;
	protected static BufferedImage man;

	/**
	 * Konstruktor
	 * 
	 * @param e
	 *            EnemyUnit
	 */
	public EnemyUnitView(EnemyUnit e) {
		enemyUnit = e;
		
		try {
			dwarf = ImageIO.read(new File("textures//dwarf.png"));
			elf = ImageIO.read(new File("textures//elf.png"));
			hobbit = ImageIO.read(new File("textures//hobbit.png"));
			man = ImageIO.read(new File("textures//man.png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Abstract metódus az egységek kirajzolásához
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 * 			  int - x koordináta
	 * @param y
	 * 			  int - y koordináta
	 *            
	 */
	protected abstract void drawUnit(Graphics g, int x, int y);

	/**
	 * Abstract metódus az egyes egységek maximum életének lekérdezésére
	 * 
	 * @return
	 */
	protected abstract int getMaxLife();

	/**
	 * Az egyes ellenséges egységek kirajzolásáért felelõs függvény, valamint az
	 * egységek életét megjelenítõ kis csík kirajzolását is végzi.
	 * 
	 * @param x
	 *            int - x koordináta
	 * @param y
	 *            int - y koordináta
	 * @param g
	 *            Graphics -
	 */
	public final void draw(Graphics g, int x, int y) {
		int health = enemyUnit.getParameters();

		drawUnit(g, x, y);
		g.setColor(Color.GREEN);
		g.fillRect(x + 5, y + 1, (int) (10 * (double) health / getMaxLife()), 3);
		g.setColor(Color.RED);
		g.fillRect(x + 15
				- (int) (10 * (double) (getMaxLife() - health) / getMaxLife()),
				y + 1,
				(int) (10 * (double) (getMaxLife() - health) / getMaxLife()), 3);
		g.setColor(Color.BLACK);
		g.drawRect(x + 5, y + 1, 10, 3);
	}
}
