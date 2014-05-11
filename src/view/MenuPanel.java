package view;

import java.awt.GridLayout;

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

	/**
	 * Konstruktor, inicializ�lja a gombok m�k�d�s�t,tulajdons�gait.
	 * 
	 * @param control
	 *            Control - esem�nyvez�rl� objektum �tad�sa
	 */
	public MenuPanel(Control control) {
		setLayout(new GridLayout(0, 1));

		towerButton = new JButton("Tower");
		towerButton.setActionCommand("tower");
		towerButton.addActionListener(control);
		add(towerButton);

		swampButton = new JButton("Swamp");
		swampButton.setActionCommand("swamp");
		swampButton.addActionListener(control);
		add(swampButton);

		elfRuneButton = new JButton("ElfRune");
		elfRuneButton.setActionCommand("elfrune");
		elfRuneButton.addActionListener(control);
		add(elfRuneButton);

		manRuneButton = new JButton("ManRune");
		manRuneButton.setActionCommand("manrune");
		manRuneButton.addActionListener(control);
		add(manRuneButton);

		dwarfRuneButton = new JButton("DwarfRune");
		dwarfRuneButton.setActionCommand("dwarfrune");
		dwarfRuneButton.addActionListener(control);
		add(dwarfRuneButton);

		hobbitRuneButton = new JButton("HobbitRune");
		hobbitRuneButton.setActionCommand("hobbitrune");
		hobbitRuneButton.addActionListener(control);
		add(hobbitRuneButton);

		rangeRuneButton = new JButton("RangeRune");
		rangeRuneButton.setActionCommand("rangerune");
		rangeRuneButton.addActionListener(control);
		add(rangeRuneButton);

		reloadRuneButton = new JButton("ReloadRune");
		reloadRuneButton.setActionCommand("reloadrune");
		reloadRuneButton.addActionListener(control);
		add(reloadRuneButton);
	}
}
