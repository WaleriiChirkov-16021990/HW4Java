package com.wch.waveAlgorithm.Project;

public class Main {
	public static void main(String[] args) {
		MyGameField gameField2 = new MyGameField(2,2);
		DataBase dataBase = new DataBase();
		ClassicStepper classicStepper = new ClassicStepper(gameField2,dataBase);
		classicStepper.setRndStartPoint();
		classicStepper.setSteppers();
		classicStepper.setDataBase(dataBase);
		classicStepper.getDataBase().getMapsCollections().add(classicStepper.getGameField());
		System.out.println("\nСгенерированное игровое поле: \n0 - пустые поля \n-1 - преграда \n-2 - выходы-порталы \n1- точка старта");
		new Printer().printField(gameField2);
		FindShortWayClassic findShortWayClassic = new FindShortWayClassic();
		findShortWayClassic.setClassicStepper(classicStepper);
		findShortWayClassic.waveScan();
		System.out.println("Поле отсканированное волновым алгоритмом");
		new Printer().printField(gameField2);
		findShortWayClassic.getReverseWay(findShortWayClassic.getFinish().getFirst());
		System.out.println("Путь от точки старта до точки ближайшего выхода.");
		new Printer().printArrayDouble(findShortWayClassic.getShortWay());
		
		
		MyGameField gameField = new MyGameField(10, 10);
		AdvanceStepper advanceStepper = new AdvanceStepper(gameField, dataBase);
		advanceStepper.setRndStartPoint();
		advanceStepper.setSteppers();
		advanceStepper.setDataBase(dataBase);
		advanceStepper.getDataBase().getMapsCollections().add(classicStepper.getGameField());
		System.out.println("\nСгенерированное игровое поле: \n0 - пустые поля \n-1 - преграда \n-2 - выходы-порталы \n1- точка старта");
		new Printer().printField(gameField);
		FindShortWayAdvance findShortWayAdvance = new FindShortWayAdvance();
		findShortWayAdvance.setAdvanceStepper(advanceStepper);
		findShortWayAdvance.advanceWaveScan();
		System.out.println("Поле отсканированное волновым алгоритмом");
		new Printer().printField(gameField);
		
	}
}
