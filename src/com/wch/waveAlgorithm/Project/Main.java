package com.wch.waveAlgorithm.Project;

public class Main {
	public static void main(String[] args) {
		MyGameField gameField2 = new MyGameField(10,10); // Create myField
		DataBase dataBase = new DataBase();
		ClassicStepper classicStepper = new ClassicStepper(gameField2,dataBase);
		classicStepper.setRndStartPoint();
		classicStepper.setSteppers();
		classicStepper.setDataBase(dataBase);
		classicStepper.getDataBase().getMapsCollections().add(classicStepper.getGameField()); // добавляем сненерированное поле, из классического степпера в БД
		new Printer().getInfo();
		new Printer().printField(gameField2);
		FindShortWayClassic findShortWayClassic = new FindShortWayClassic();
		findShortWayClassic.setClassicStepper(classicStepper);
		findShortWayClassic.waveScan(); // запускаем волновой алгоритм
		Printer.classicFieldFill();
		new Printer().printField(gameField2);
		findShortWayClassic.getReverseWay(findShortWayClassic.getFinish().peekFirst());  //ищем обратный путь от первого найденного выхода
		if(findShortWayClassic.getShortWay().size() >= 1) {
			Printer.NotEmptyClassic();
			new Printer().printArrayDouble(findShortWayClassic.getShortWay());  //если путь найдем, печатаем его по точкам
		}
		

		MyGameField gameField = new MyGameField(10, 10);
		AdvanceStepper advanceStepper = new AdvanceStepper(gameField, dataBase);
		advanceStepper.setRndStartPoint();
		advanceStepper.setSteppers();
		advanceStepper.setDataBase(dataBase);
		advanceStepper.getDataBase().getMapsCollections().add(classicStepper.getGameField());
		new Printer().getInfo();
		new Printer().printField(gameField);
		FindShortWayAdvance findShortWayAdvance = new FindShortWayAdvance();
		findShortWayAdvance.setAdvanceStepper(advanceStepper);
		findShortWayAdvance.advanceWaveScan(); // запускаем продвинутутое сканирование волновым алгоритмом
		Printer.advanceFieldFill();
		new Printer().printField(gameField);
		findShortWayAdvance.getReverseWay(findShortWayAdvance.getFinish().peekFirst());  //ищем обратный путь от первого найденного выхода
		if(findShortWayAdvance.getShortWay().size() >= 1) {
			Printer.NotEmptyAdvance();
			new Printer().printArrayDouble(findShortWayAdvance.getShortWay());  //если путь найдем, печатаем его по точкам
		}
	}
}
