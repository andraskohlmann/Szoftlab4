package view.mapitem;

import java.awt.Graphics;

import view.View;
import view.ViewBase;

/**
 * 
 * �ltal�nos kirajzol�s�rt felel�s objektum, mely sz�rmazik a ViewBase
 * oszt�lyb�l, �s implement�lja a View interf�szt. Felel�ss�ge a Road,Field
 * objektumok egybefog�sa, k�z�s kezelhet�s�g�nek biztos�t�sa. Tov�bb� a
 * modellbeli objektumok jelezhetnek neki amennyiben v�ltoz�st t�rt�nt �s
 * �jrarajzol�s sz�ks�ges.
 * 
 */
public abstract class TileViewBase extends ViewBase implements View {
	/**
	 * Amennyiben �jrarajzol�s sz�ks�ges, �gy a v�ltoz� �rt�ke igazba billen
	 */
	private boolean needToRepaint;

	/**
	 * Konstruktor
	 * 
	 * @param x
	 *            int - x koordin�ta
	 * @param y
	 *            int - y koordin�ta
	 */
	public TileViewBase(int x, int y) {
		super(x, y);

		needToRepaint = true;
	}

	/**
	 * A f�ggv�ny megh�v�s�val jelezhet� a modellbeli v�ltoz�s, �gy a kirajzol�s
	 * sz�ks�gess�ge.
	 */
	@Override
	public void notifyView() {
		needToRepaint = true;
	}

	/**
	 * Kirajzol�st v�gz� f�ggv�ny, megh�vja a lesz�rmazott oszt�lyokban
	 * megval�s�tott paintMe f�ggv�nyt.
	 * 
	 * @param g
	 *            Graphics -
	 */
	@Override
	public void draw(Graphics g) {
		if (needToRepaint) {
			paintMe(g);

			needToRepaint = false;
		}
	}

	/**
	 * Abstract met�dus mely az egyes lesz�rmazott objektumok implement�lnak. A
	 * lesz�rmazott objektumok kirajzol�s�t val�s�tjuk meg vele
	 * 
	 * @param g
	 *            Graphics
	 */
	protected abstract void paintMe(Graphics g);

}
