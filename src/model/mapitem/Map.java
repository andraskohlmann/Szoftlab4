package model.mapitem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.enemies.EnemyUnit;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.runes.Rune;
import control.SkeletonUI;

public class Map {

	private Field field;
	private Road road;
	private Tile tiles[][] = null;
	private String Skeleton_answer;
	private FinishedRoad finishedRoad;

	public void Skeleton_FieldSetter(Field f) {
		field = f;
	}

	public void Skeleton_RoadSetter(Road r) {
		road = r;
	}

	public void Skeleton_FinishedRoadSetter(FinishedRoad f) {
		finishedRoad = f;
	}

	public boolean checkTower(int x, int y) {
		return tiles[x][y].checkTower();
	}

	public void putTower(int x, int y, Tower t) {
		SkeletonUI.enterFunction(this, "putTower", x, y, t);
		field.putTower(t);
		SkeletonUI.leaveFunction();
	}

	public boolean checkRune(int x, int y) {
		SkeletonUI.enterFunction(this, "checkRune", x, y);

		Skeleton_answer = SkeletonUI.stringQuestion(
				"Is that tile a Field or a Road?", "F", "R");
		boolean available = false;

		if (Skeleton_answer.equals("F"))
			available = field.checkRune();
		else
			available = road.checkRune();

		SkeletonUI.leaveFunction(available);
		return available;

	}

	public void putRune(int x, int y, Rune r) {
		SkeletonUI.enterFunction(this, "putRune", x, y, r);

		if (Skeleton_answer.equals("F"))
			field.putRune(r);
		else
			road.putRune(r);

		SkeletonUI.leaveFunction();
	}

	public boolean checkSwamp(int x, int y) {
		SkeletonUI.enterFunction(this, "checkSwamp", x, y);

		boolean available = false;

		Skeleton_answer = SkeletonUI
				.stringQuestion(
						"Is that tile a Field or a Road? you want to put a Swamp on it",
						"F", "R");

		if (Skeleton_answer.equals("F"))
			available = field.checkSwamp();
		else
			available = road.checkSwamp();

		SkeletonUI.leaveFunction(available);
		return available;
	}

	public void putSwamp(int x, int y, Swamp s) {
		SkeletonUI.enterFunction(this, "putSwamp", x, y, s);
		road.putSwamp(s);
		SkeletonUI.leaveFunction();
	}

	public void setConnections(String lines[]) {
		boolean found = false;
		int x = 0, y = 0;
		
		for (int i = 0; i < lines.length; i++) {
			for (int j = 0; j < lines[i].length(); j++) {
				if (lines[i].charAt(j) == '-') {
					x = i; y = j; found = true; break;
				}
			}
			if (found) break;
		}
		
		findNext(x, y, 0, lines);
	}
	
	private boolean findNext(int i, int j, int prev, String lines[]) {
		boolean dotFound = false;
		if (j < lines[i].length() - 1 && prev != 3) {
			if (lines[i].charAt(j+1) == '.') dotFound = true;
			if (lines[i].charAt(j+1) == 'A') {
				tiles[i][j].addNextRoad((Road)tiles[i][j+1]);
				return true;
			}
		}
		if (i < lines.length - 1 && prev != 4) {
			if (lines[i+1].charAt(j) == '.') dotFound = true;
			if (lines[i+1].charAt(j) == 'A') {
				tiles[i][j].addNextRoad((Road)tiles[i+1][j]);
				return true;
			}
		}
		if (j > 0 && prev != 1) {
			if (lines[i].charAt(j-1) == '.') dotFound = true;
			if (lines[i].charAt(j-1) == 'A') {
				tiles[i][j].addNextRoad((Road)tiles[i][j-1]);
				return true;
			}
		}
		if (i > 0 && prev != 2) {
			if (lines[i-1].charAt(j) == '.') dotFound = true;
			if (lines[i-1].charAt(j) == 'A') {
				tiles[i][j].addNextRoad((Road)tiles[i-1][j]);
				return true;
			}
		}
		
		// !!!
		if (j < lines[i].length() - 1 && prev != 1) {
			if (lines[i].charAt(j+1) == '.') {
				tiles[i][j].addNextRoad((Road)tiles[i][j+1]);
				if (findNext(i, j+1, 3, lines)) return true;
			}
			if (lines[i].charAt(j+1) == ' ' && !dotFound) {
				tiles[i][j].addNextRoad((Road)tiles[i][j+1]);
				if (findNext(i, j+1, 3, lines)) return true;
			}
		}
		if (i < lines.length - 1 && prev != 2) {
			if (lines[i+1].charAt(j) == '.') {
				tiles[i][j].addNextRoad((Road)tiles[i+1][j]);
				if (findNext(i+1, j, 2, lines)) return true;
			}
			if (lines[i+1].charAt(j) == ' ' && !dotFound) {
				tiles[i][j].addNextRoad((Road)tiles[i+1][j]);
				if (findNext(i+1, j, 2, lines)) return true;
			}
		}
		if (j > 0 && prev != 1) {
			if (lines[i].charAt(j-1) == '.') {
				tiles[i][j].addNextRoad((Road)tiles[i][j-1]);
				if (findNext(i, j-1, 1, lines)) return true;
			}
			if (lines[i].charAt(j-1) == ' ') {
				tiles[i][j].addNextRoad((Road)tiles[i][j-1]);
				if (findNext(i, j-1, 1, lines)) return true;
			}
		}
		if (i > 0 && prev != 2) {
			if (lines[i-1].charAt(j) == '.') {
				tiles[i][j].addNextRoad((Road)tiles[i-1][j]);
				if (findNext(i-1, j, 2, lines)) return true;
			}
			if (lines[i-1].charAt(j) == ' ') {
				tiles[i][j].addNextRoad((Road)tiles[i-1][j]);
				if (findNext(i-1, j, 2, lines)) return true;
			}
		}
		return false;
	}

	public List<EnemyUnit> getFinishedUnits() {
		return finishedRoad.getFinishedUnits();
	}

	public void deleteFinishedUnits() {
		finishedRoad.deleteFinishedUnits();
	}

	public void addUnit(EnemyUnit e) {
		SkeletonUI.enterFunction(this, "addUnit", e);
		road.addUnit(e);
		SkeletonUI.leaveFunction();
	}

	public Map(String filename) {
		buildMap(filename);
	}
	
	private void buildMap(String filename) {
		String lines[] = null;
		int numberOfColumns = 0;
		int numberOfRows = 0;
		int k = 0;
		boolean firstLine = true;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				if (firstLine) {
					String numbers[] = line.split("×");
					numberOfColumns = Integer.parseInt(numbers[0]);
					numberOfRows = Integer.parseInt(numbers[1]);
					firstLine = false; 
					lines = new String[numberOfRows];
				}
				else lines[k++] = line;
			}
			br.close();
		} catch (IOException ioe) {			
		
		}
		
		tiles = new Tile[numberOfRows][numberOfColumns];	
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				if (lines[i].charAt(j) == '#') tiles[i][j] = new Field();
				else if (lines[i].charAt(j) == '-') tiles[i][j] = new Road();
				else if (lines[i].charAt(j) == ' ') tiles[i][j] = new Road();
				else if (lines[i].charAt(j) == '.') tiles[i][j] = new Road();
				else if (lines[i].charAt(j) == 'A') tiles[i][j] = new FinishedRoad();
			}
		}
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				List<Tile> neighbours = new ArrayList<Tile>();
				if (i > 0) neighbours.add(tiles[i-1][j]);
				if (i < numberOfRows - 1) neighbours.add(tiles[i+1][j]);
				if (j > 0) neighbours.add(tiles[i][j-1]);
				if (j < numberOfColumns) neighbours.add(tiles[i][j+1]);
				tiles[i][j].addNeighbours(neighbours);
			}
		}
		setConnections(lines);
	}
	
}

