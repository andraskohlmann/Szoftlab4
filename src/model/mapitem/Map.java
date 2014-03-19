package model.mapitem;

import java.util.List;

import control.SkeletonUI;

import model.enemies.EnemyUnit;
import model.friendly.Swamp;
import model.friendly.Tower;
import model.runes.Rune;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Map.java
//  @ Date : 2014.03.19.
//  @ Author : 
//
//

public class Map {

	private Field field;
	private Road road;

	public void Skeleton_FieldSetter(Field f) {
		field = f;
	}

	public void Skeleton_RoadSetter(Road r) {
		road = r;
	}

	public boolean checkTower(int x, int y) {
		return false;

	}

	public void putTower(int x, int y, Tower t) {

	}

	public boolean checkRune(int x, int y) {
		SkeletonUI.enterFunction(this, "checkRune", x, y);

		String answer = SkeletonUI.stringQuestion(
				"Is that tile a Field or a Road?", "F", "R");
		boolean available = false;

		if (answer == "F")
			available = field.checkRune();
		else
			available = road.checkRune();

		SkeletonUI.leaveFunction(available);
		return available;

	}

	public void putRune(int x, int y, Rune r) {
		SkeletonUI.enterFunction(this, "putRune", x, y, r);

		SkeletonUI.leaveFunction();
	}

	public boolean checkSwamp(int x, int y) {
		boolean available;
		SkeletonUI.enterFunction(this, "checkSwamp", x, y);
		if (SkeletonUI
				.stringQuestion(
						"Is it a Road or a Field you want to put a Swamp on it? (Road, Field)?",
						"R", "S").equals("R"))
			available = road.checkSwamp();
		else
			available = field.checkSwamp();

		SkeletonUI.leaveFunction(available);
		return available;
	}

	public void putSwamp(int x, int y, Swamp s) {

	}

	public void setConnections() {

	}

	public List<EnemyUnit> getFinishedUnits() {
		return null;

	}

	public void deleteFinishedUnits() {

	}

	public void addUnit(EnemyUnit e) {

	}
}
