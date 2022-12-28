package com.wch.waveAlgorithm.Project;

public class Main {
	public static void main(String[] args) {
		MyGameField gameField = new MyGameField(3,4);
		gameField.printField();
		MyGameField gameField2 = new MyGameField(20,30);
		gameField2 .printField();
		ClassicStepper classicStepper = new ClassicStepper();
		DataBase dataBase = new DataBase();
		MemoryPoint memoryPoint = new MemoryPoint();
//		classicStepper.setGameField(gameField);
		classicStepper.setGameField(gameField2);
		classicStepper.setSteppers();
	}
}