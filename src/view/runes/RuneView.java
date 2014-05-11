package view.runes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.runes.Rune;
import view.RelativeViewBase;

/**
 * 
 * �ltal�nos Rune megjelen�t�s��rt felel�s objektum,megval�s�tja a
 * RelativeViewBase interf�szt
 * 
 */
public class RuneView implements RelativeViewBase {
	
	protected static BufferedImage dwarf;
	protected static BufferedImage elf;
	protected static BufferedImage hobbit;
	protected static BufferedImage man;
	protected static BufferedImage reload;
	protected static BufferedImage range;
	
	/**
	 * Megval�s�tand� Rune t�rol�sa
	 */
	private Rune rune;

	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            Rune - megval�s�tand� objektum be�ll�t�sa
	 */
	public RuneView(Rune r) {
		rune = r;
		
		try {
			dwarf = ImageIO.read(new File("textures//dwarfrune.png"));
			elf = ImageIO.read(new File("textures//elfrune.png"));
			hobbit = ImageIO.read(new File("textures//hobbitrune.png"));
			man = ImageIO.read(new File("textures//manrune.png"));
			reload = ImageIO.read(new File("textures//reloadrune.png"));
			range = ImageIO.read(new File("textures//rangerune.png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Getter f�ggv�ny a t�rolt Rune objektumra
	 * 
	 * @return rune Rune
	 */
	public Rune getRune() {
		return rune;
	}
	
	/**
	 * Abstract met�dus a r�n�k kirajzol�s�hoz
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 * 			  int - x koordin�ta
	 * @param y
	 * 			  int - y koordin�ta
	 *            
	 */
	protected void drawRune(Graphics g, int x, int y) {}

	/**
	 * Kirajzolja a Rune-t a param�terben megkapott x,y koordin�t�kra
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 *            int - x koordin�ta
	 * @param y
	 *            int - y koordin�ta
	 */
	public void draw(Graphics g, int x, int y) {
		drawRune(g, x, y);
	}
}
