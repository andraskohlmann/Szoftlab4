package model.mapitem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.enemies.EnemyUnit;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.runes.Rune;
import control.ProtoManager;

public class Map {

	private Tile tiles[][] = null;
	private FinishedRoad finishedRoad;

	public boolean checkTower(int x, int y) {
		return tiles[x][y].checkTower();
	}

	public void putTower(int x, int y, Tower t) {
		tiles[x][y].putTower(t);
	}

	public boolean checkRune(int x, int y) {
		return tiles[x][y].checkRune();
	}

	public void putRune(int x, int y, Rune r) {
		tiles[x][y].putRune(r);
	}

	public boolean checkSwamp(int x, int y) {
		return tiles[x][y].checkSwamp();
	}

	public void putSwamp(int x, int y, Swamp s) {
		tiles[x][y].putSwamp(s);
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
		for (int i = 0; i < lines.length; i++) {
			for (int j = 0; j < lines[i].length(); j++) {
				if (!tiles[i][j].nextRoad.isEmpty()) {
					Set<Road> roadSet = new HashSet<Road>(tiles[i][j].nextRoad);
					tiles[i][j].nextRoad.removeAll(tiles[i][j].nextRoad);
					tiles[i][j].nextRoad.addAll(roadSet);
					//for (int k = 0; k < tiles[i][j].nextRoad.size(); k++)
					//	System.out.println("tile " + i + " " + j + ": " + k);
				}
			}
		}
		ProtoManager.print("Map loaded.");
	}
	
	private boolean findNext(int i, int j, int prev, String lines[]) {
		boolean dotFound = false;
		int numberOfDots = 0;
		if (j < lines[i].length() - 1 && prev != 1) {
			if (lines[i].charAt(j+1) == '.') {
				dotFound = true;
				numberOfDots++;
			}
			if (lines[i].charAt(j+1) == 'A') {
				tiles[i][j].addNextRoad((Road)tiles[i][j+1]); //System.out.println("Next road to " + i + ":" + j + " right end");
				return true;
			}
		}
		if (i < lines.length - 1 && prev != 2) {
			if (lines[i+1].charAt(j) == '.') {
				dotFound = true;
				numberOfDots++;
			}
			if (lines[i+1].charAt(j) == 'A') {
				tiles[i][j].addNextRoad((Road)tiles[i+1][j]); //System.out.println("Next road to " + i + ":" + j + " down end");
				return true;
			}
		}
		if (j > 0 && prev != 3) {
			if (lines[i].charAt(j-1) == '.') {
				dotFound = true;
				numberOfDots++;
			}
			if (lines[i].charAt(j-1) == 'A') {
				tiles[i][j].addNextRoad((Road)tiles[i][j-1]); //System.out.println("Next road to " + i + ":" + j + " left end");
				return true;
			}
		}
		if (i > 0 && prev != 4) {
			if (lines[i-1].charAt(j) == '.') {
				dotFound = true;
				numberOfDots++;
			}
			if (lines[i-1].charAt(j) == 'A') {
				tiles[i][j].addNextRoad((Road)tiles[i-1][j]); //System.out.println("Next road to " + i + ":" + j + " up end");
				return true;
			}
		}
		
		int numberOfDotsVisited = 0;
		if (j < lines[i].length() - 1 && prev != 1) {
			if (lines[i].charAt(j+1) == '.') {
				tiles[i][j].addNextRoad((Road)tiles[i][j+1]); //System.out.println("Next road to " + i + ":" + j + " right dot");
				if (findNext(i, j+1, 3, lines)) numberOfDotsVisited++;
			}
			if (lines[i].charAt(j+1) == ' ' && !dotFound) {
				tiles[i][j].addNextRoad((Road)tiles[i][j+1]); //System.out.println("Next road to " + i + ":" + j + " right space");
				if (findNext(i, j+1, 3, lines)) return true;
			}
		}
		if (i < lines.length - 1 && prev != 2) {
			if (lines[i+1].charAt(j) == '.') {
				tiles[i][j].addNextRoad((Road)tiles[i+1][j]); //System.out.println("Next road to " + i + ":" + j + " down dot");
				if (findNext(i+1, j, 4, lines)) numberOfDotsVisited++;
			}
			if (lines[i+1].charAt(j) == ' ' && !dotFound) {
				tiles[i][j].addNextRoad((Road)tiles[i+1][j]); //System.out.println("Next road to " + i + ":" + j + " down space");
				if (findNext(i+1, j, 4, lines)) return true;
			}
		}
		if (j > 0 && prev != 3) {
			if (lines[i].charAt(j-1) == '.') {
				tiles[i][j].addNextRoad((Road)tiles[i][j-1]); //System.out.println("Next road to " + i + ":" + j + " left dot");
				if (findNext(i, j-1, 1, lines)) numberOfDotsVisited++;
			}
			if (lines[i].charAt(j-1) == ' ' && !dotFound) {
				tiles[i][j].addNextRoad((Road)tiles[i][j-1]); //System.out.println("Next road to " + i + ":" + j + " left space");
				if (findNext(i, j-1, 1, lines)) return true;
			}
		}
		if (i > 0 && prev != 4) {
			if (lines[i-1].charAt(j) == '.') {
				tiles[i][j].addNextRoad((Road)tiles[i-1][j]); //System.out.println("Next road to " + i + ":" + j + " up dot");
				if (findNext(i-1, j, 2, lines)) numberOfDotsVisited++;
			}
			if (lines[i-1].charAt(j) == ' ' && !dotFound) {
				tiles[i][j].addNextRoad((Road)tiles[i-1][j]); //System.out.println("Next road to " + i + ":" + j + " up space");
				if (findNext(i-1, j, 2, lines)) return true;
			}
		}
		if (numberOfDots == numberOfDotsVisited) return true;
		return false;
	}

	public List<EnemyUnit> getFinishedUnits() {
		return finishedRoad.getFinishedUnits();
	}

	public void deleteFinishedUnits() {
		finishedRoad.deleteFinishedUnits();
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
				else if (lines[i].charAt(j) == 'A') {
					tiles[i][j] = new FinishedRoad();
					finishedRoad = (FinishedRoad)tiles[i][j];
				}
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
	
	public Tile[][] Prototype_getTiles()
	{
		return tiles;
	}
}

