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
 * �ltal�nos EnemyUnitView oszt�ly mely felel�ss�ge a k�l�nb�z� j�t�kban
 * szerepl� ellens�ges egys�gek megjelen�t�s�nek menedzsel�se.
 * 
 */
public abstract class EnemyUnitView implements RelativeViewBase {
	/**
	 * Kirajzoland� ellens�ges egys�g
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
	 * Abstract met�dus az egys�gek kirajzol�s�hoz
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 * 			  int - x koordin�ta
	 * @param y
	 * 			  int - y koordin�ta
	 *            
	 */
	protected abstract void drawUnit(Graphics g, int x, int y);

	/**
	 * Abstract met�dus az egyes egys�gek maximum �let�nek lek�rdez�s�re
	 * 
	 * @return
	 */
	protected abstract int getMaxLife();

	/**
	 * Az egyes ellens�ges egys�gek kirajzol�s��rt felel�s f�ggv�ny, valamint az
	 * egys�gek �let�t megjelen�t� kis cs�k kirajzol�s�t is v�gzi.
	 * 
	 * @param x
	 *            int - x koordin�ta
	 * @param y
	 *            int - y koordin�ta
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
