package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.Control;

/**
 * 
 * A játék menüjét megvalósító objektum
 * 
 */
public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Az egyes gombok a menüpanelen
	 */

	private JButton towerButton;
	private JButton swampButton;
	private JButton elfRuneButton;
	private JButton manRuneButton;
	private JButton dwarfRuneButton;
	private JButton hobbitRuneButton;
	private JButton rangeRuneButton;
	private JButton reloadRuneButton;

	/**
	 * Konstruktor, inicializálja a gombok mûködését,tulajdonságait.
	 * 
	 * @param control
	 *            Control - eseményvezérlõ objektum átadása
	 */
	public MenuPanel(Control control) {
		setLayout(new GridLayout(0, 1));
		setBackground(Color.BLACK);

		setMaximumSize(new Dimension(240, 540));
		
		towerButton = new JButton(new ImageIcon("textures//towerbutton.png"));
		towerButton.setBorderPainted(false);
		towerButton.setContentAreaFilled(false);
		towerButton.setOpaque(false);
		towerButton.setActionCommand("tower");
		towerButton.addActionListener(control);
		add(towerButton);

		swampButton = new JButton(new ImageIcon("textures//swampbutton.png"));
		swampButton.setBorderPainted(false);
		swampButton.setContentAreaFilled(false);
		swampButton.setOpaque(false);
		swampButton.setActionCommand("swamp");
		swampButton.addActionListener(control);
		add(swampButton);

		elfRuneButton = new JButton(new ImageIcon("textures//elfrunebutton.png"));
		elfRuneButton.setBorderPainted(false);
		elfRuneButton.setContentAreaFilled(false);
		elfRuneButton.setOpaque(false);
		elfRuneButton.setActionCommand("elfrune");
		elfRuneButton.addActionListener(control);
		add(elfRuneButton);

		manRuneButton = new JButton(new ImageIcon("textures//manrunebutton.png"));
		manRuneButton.setBorderPainted(false);
		manRuneButton.setContentAreaFilled(false);
		manRuneButton.setOpaque(false);
		manRuneButton.setActionCommand("manrune");
		manRuneButton.addActionListener(control);
		add(manRuneButton);

		dwarfRuneButton = new JButton(new ImageIcon("textures//dwarfrunebutton.png"));
		dwarfRuneButton.setBorderPainted(false);
		dwarfRuneButton.setContentAreaFilled(false);
		dwarfRuneButton.setOpaque(false);
		dwarfRuneButton.setActionCommand("dwarfrune");
		dwarfRuneButton.addActionListener(control);
		add(dwarfRuneButton);

		hobbitRuneButton = new JButton(new ImageIcon("textures//hobbitrunebutton.png"));
		hobbitRuneButton.setBorderPainted(false);
		hobbitRuneButton.setContentAreaFilled(false);
		hobbitRuneButton.setOpaque(false);
		hobbitRuneButton.setActionCommand("hobbitrune");
		hobbitRuneButton.addActionListener(control);
		add(hobbitRuneButton);

		rangeRuneButton = new JButton(new ImageIcon("textures//rangerunebutton.png"));
		rangeRuneButton.setBorderPainted(false);
		rangeRuneButton.setContentAreaFilled(false);
		rangeRuneButton.setOpaque(false);
		rangeRuneButton.setActionCommand("rangerune");
		rangeRuneButton.addActionListener(control);
		add(rangeRuneButton);

		reloadRuneButton = new JButton(new ImageIcon("textures//reloadrunebutton.png"));
		reloadRuneButton.setBorderPainted(false);
		reloadRuneButton.setContentAreaFilled(false);
		reloadRuneButton.setOpaque(false);
		reloadRuneButton.setActionCommand("reloadrune");
		reloadRuneButton.addActionListener(control);
		add(reloadRuneButton);
	}
	
	
}
