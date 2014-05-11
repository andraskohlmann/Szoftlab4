package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.Control;

/**
 * 
 * A j�t�k men�j�t megval�s�t� objektum
 * 
 */
public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Az egyes gombok a men�panelen
	 */

	private JButton towerButton;
	private JButton swampButton;
	private JButton elfRuneButton;
	private JButton manRuneButton;
	private JButton dwarfRuneButton;
	private JButton hobbitRuneButton;
	private JButton rangeRuneButton;
	private JButton reloadRuneButton;
	
	private BufferedImage towerButtonImage;

	/**
	 * Konstruktor, inicializ�lja a gombok m�k�d�s�t,tulajdons�gait.
	 * 
	 * @param control
	 *            Control - esem�nyvez�rl� objektum �tad�sa
	 */
	public MenuPanel(Control control) {
		setLayout(new GridLayout(0, 1));
		setBackground(Color.BLACK);
		
		towerButton = new JButton(new ImageIcon("textures//towerbutton.png"));
		towerButton.setBorderPainted(false);
		towerButton.setContentAreaFilled(false);
		towerButton.setFocusPainted(false);
		towerButton.setOpaque(false);
		towerButton.setActionCommand("tower");
		towerButton.addActionListener(control);
		add(towerButton);

		swampButton = new JButton(new ImageIcon("textures//swampbutton.png"));
		swampButton.setBorderPainted(false);
		swampButton.setContentAreaFilled(false);
		swampButton.setFocusPainted(false);
		swampButton.setOpaque(false);
		swampButton.setActionCommand("swamp");
		swampButton.addActionListener(control);
		add(swampButton);

		elfRuneButton = new JButton(new ImageIcon("textures//elfrunebutton.png"));
		elfRuneButton.setBorderPainted(false);
		elfRuneButton.setContentAreaFilled(false);
		elfRuneButton.setFocusPainted(false);
		elfRuneButton.setOpaque(false);
		elfRuneButton.setActionCommand("elfrune");
		elfRuneButton.addActionListener(control);
		add(elfRuneButton);

		manRuneButton = new JButton(new ImageIcon("textures//manrunebutton.png"));
		manRuneButton.setBorderPainted(false);
		manRuneButton.setContentAreaFilled(false);
		manRuneButton.setFocusPainted(false);
		manRuneButton.setOpaque(false);
		manRuneButton.setActionCommand("manrune");
		manRuneButton.addActionListener(control);
		add(manRuneButton);

		dwarfRuneButton = new JButton(new ImageIcon("textures//dwarfrunebutton.png"));
		dwarfRuneButton.setBorderPainted(false);
		dwarfRuneButton.setContentAreaFilled(false);
		dwarfRuneButton.setFocusPainted(false);
		dwarfRuneButton.setOpaque(false);
		dwarfRuneButton.setActionCommand("dwarfrune");
		dwarfRuneButton.addActionListener(control);
		add(dwarfRuneButton);

		hobbitRuneButton = new JButton(new ImageIcon("textures//hobbitrunebutton.png"));
		hobbitRuneButton.setBorderPainted(false);
		hobbitRuneButton.setContentAreaFilled(false);
		hobbitRuneButton.setFocusPainted(false);
		hobbitRuneButton.setOpaque(false);
		hobbitRuneButton.setActionCommand("hobbitrune");
		hobbitRuneButton.addActionListener(control);
		add(hobbitRuneButton);

		rangeRuneButton = new JButton(new ImageIcon("textures//rangerunebutton.png"));
		rangeRuneButton.setBorderPainted(false);
		rangeRuneButton.setContentAreaFilled(false);
		rangeRuneButton.setFocusPainted(false);
		rangeRuneButton.setOpaque(false);
		rangeRuneButton.setActionCommand("rangerune");
		rangeRuneButton.addActionListener(control);
		add(rangeRuneButton);

		reloadRuneButton = new JButton(new ImageIcon("textures//reloadrunebutton.png"));
		reloadRuneButton.setBorderPainted(false);
		reloadRuneButton.setContentAreaFilled(false);
		reloadRuneButton.setFocusPainted(false);
		reloadRuneButton.setOpaque(false);
		reloadRuneButton.setActionCommand("reloadrune");
		reloadRuneButton.addActionListener(control);
		add(reloadRuneButton);
	}
	
	
}
