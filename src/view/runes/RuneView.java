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
 * Általános Rune megjelenítéséért felelõs objektum,megvalósítja a
 * RelativeViewBase interfészt
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
	 * Megvalósítandó Rune tárolása
	 */
	private Rune rune;

	/**
	 * Konstruktor
	 * 
	 * @param r
	 *            Rune - megvalósítandó objektum beállítása
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
	 * Getter függvény a tárolt Rune objektumra
	 * 
	 * @return rune Rune
	 */
	public Rune getRune() {
		return rune;
	}
	
	/**
	 * Abstract metódus a rúnák kirajzolásához
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 * 			  int - x koordináta
	 * @param y
	 * 			  int - y koordináta
	 *            
	 */
	protected void drawRune(Graphics g, int x, int y) {}

	/**
	 * Kirajzolja a Rune-t a paraméterben megkapott x,y koordinátákra
	 * 
	 * @param g
	 *            Graphics
	 * @param x
	 *            int - x koordináta
	 * @param y
	 *            int - y koordináta
	 */
	public void draw(Graphics g, int x, int y) {
		drawRune(g, x, y);
	}
}
