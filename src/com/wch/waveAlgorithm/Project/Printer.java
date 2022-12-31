package com.wch.waveAlgorithm.Project;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * класс вывода данных
 */
public class Printer {
	
	public void printArrayDouble(LinkedList<int[]> array){
		for (int[] a:
				array) {
			System.out.println(Arrays.toString(a));
		}
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
