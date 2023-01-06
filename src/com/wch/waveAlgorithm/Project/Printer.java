package com.wch.waveAlgorithm.Project;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * класс вывода данных
 */
public class Printer {
	
	public void getInfo(){
		System.out.println("\nСгенерированное игровое поле: \n 0 - пустые поля \n-1 - преграда \n-2 - выходы-порталы \n 1- точка старта");
	}
	
	public void printArrayDouble(LinkedList<int[]> array){
		for (int[] a:
				array) {
			System.out.println(Arrays.toString(a));
		}
	}
	
	
	public static void advanceFieldFill(){
		System.out.println("Поле отсканированное продвинутым волновым алгоритмом");
	}
	
	public static void classicFieldFill(){
		System.out.println("Поле отсканированное классическим волновым алгоритмом");
	}
	
	public static void NotEmptyClassic(){
		System.out.println("Путь от точки старта до точки ближайшего выхода классическим методом.");
	}
	
	public static void NotEmptyAdvance(){
		System.out.println("Продвинутый путь от точки старта до точки ближайшего выхода.");
	}
	
	/**
	 * Вывод поля в консоль, из экземпляра MyGameField
	 * @param gameField2 - экземпляр MyGameField
	 */
	public void printField(MyGameField gameField2) {
		for (int i = 0; i < gameField2.getField().length ; i++) {
			for (int j = 0; j < gameField2.getField()[i].length ; j++) {
				System.out.print(gameField2.getField()[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}


}
