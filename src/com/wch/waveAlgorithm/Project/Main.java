package com.wch.waveAlgorithm.Project;

import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		MyGameField gameField2 = new MyGameField(20,30);
		gameField2 .printField();
		MemoryPoint memoryPoint = new MemoryPoint();
		DataBase dataBase = new DataBase();
		ClassicStepper classicStepper = new ClassicStepper(gameField2,memoryPoint,dataBase);
		classicStepper.setRndStartPoint();
		classicStepper.setSteppers();
		gameField2 .printField();
		FindShortWayClassic findShortWayClassic = new FindShortWayClassic();
		findShortWayClassic.setClassicStepper(classicStepper);
		findShortWayClassic.waveScan();
		gameField2 .printField();
		LinkedList<int[]> revWay = findShortWayClassic.getShortWay();
		revWay.forEach(System.out::println);
	}
}