package com.wch.waveAlgorithm.Project;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 *
 */
public class FindShortWayClassic {
	private ClassicStepper classicStepper;
	private LinkedList<int[]> shortWay = new LinkedList<>();
	private LinkedList<int[]> finish = new LinkedList<>();
	private int minValue;
	
	/**
	 *
	 * @return
	 */
	public int getMinValue() {
		return minValue;
	}
	
	/**
	 *
	 * @param minValue
	 */
	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	
	/**
	 *
	 * @param finish
	 */
	public void setFinish(LinkedList<int[]> finish) {
		this.finish = finish;
	}
	
	/**
	 *
	 * @return
	 */
	public LinkedList<int[]> getFinish() {
		return finish;
	}
	
	/**
	 *
	 * @return
	 */
	public LinkedList<int[]> getShortWay() {
		return shortWay;
	}
	
	/**
	 *
	 */
	public FindShortWayClassic() {
	}
	
	/**
	 *
	 * @param classicStepper
	 */
	public FindShortWayClassic(ClassicStepper classicStepper) {
		this.classicStepper = classicStepper;
	}
	
	/**
	 *
	 * @return
	 */
	public ClassicStepper getClassicStepper() {
		return classicStepper;
	}
	
	/**
	 *
	 * @param classicStepper
	 */
	public void setClassicStepper(ClassicStepper classicStepper) {
		this.classicStepper = classicStepper;
	}
	
	/**
	 *Метод нахождения самого короткого пути, методов возврата от финиша к старту
	 * @param finishe
	 */
	public void  getReverseWay(int [] finishe){
	if(finishe != null) {
		int[] point = finishe.clone();
		LinkedList<int[]> shortWay = new LinkedList<>();
		shortWay.push(finishe);
		int number = 1;
		while (number >= 1) {
			number = classicStepper.getGameField().getField()[point[0]][point[1]];
			if (number == 1) break;
			for (int[] a : classicStepper.getSteppers()
			) {
				if (classicStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] == number - 1) {
					shortWay.push(new int[]{point[0] + a[0], point[1] + a[1]});
					point = new int[]{point[0] + a[0], point[1] + a[1]};
				}
			}
		}
		this.setShortWay(shortWay);
	} else {
		System.out.println("На сгенерированном поле нет способа добраться до выхода из этой точки");
		}
	}
	
	/**
	 *Метод классического волнового алгоритма
	 */
	public void waveScan(){
		int count = 2;
		int[] point;
		LinkedList<int[]> temp = new LinkedList<>();
		LinkedList<int[]> fin = new LinkedList<>();
		int[] start = classicStepper.getStartPoint();
		Deque<int[]> points = new LinkedList<>();
		points.push(start);
		boolean flag = true;
		while (flag && count < 600){
			while (!points.isEmpty()){
				point = points.pollFirst();
				for (int[] a: classicStepper.getStepper()
				     ) {
					if (classicStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] == 0){
						classicStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] = count;
						temp.addLast(new int[]{point[0] + a[0],point[1] + a[1]});
					}
					else if (classicStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] ==-2) {
						fin.addFirst(new int[]{point[0] + a[0], point[1] + a[1]});
						classicStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] = count;
					}
				}
			}
			if(temp.isEmpty()) break;
			else {
				count++;
				for (int[] b: temp
			         ) {
					points.push(b);
				}
			}
			temp.clear();
		}
		this.setFinish(fin);
	}
	
	/**
	 *
	 * @param shortWay
	 */
	public void setShortWay(LinkedList<int[]> shortWay) {
		this.shortWay = shortWay;
	}
	
	/**
	 * метод нахождения минимального значения, вокруг указанной точки на игровом поле
	 * @param point
	 */
	public void getMinItem(int[] point){
		int min = 0;
		for (int[] s: classicStepper.getStepper()
		     ) {
			if (classicStepper.getGameField().getField()[point[0] + s[0]][point[1] + s[1]] != -1){
				if (s[0] == -1){
					min = classicStepper.getGameField().getField()[point[0] + s[0]][point[1] + s[1]];
//							new int[]point[0] + s[0]][point[1] + s[1]];
				} else {
					if (min > classicStepper.getGameField().getField()[point[0] + s[0]][point[1] + s[1]]){
						min = classicStepper.getGameField().getField()[point[0] + s[0]][point[1] + s[1]];
					}
				}
			}
		}
		this.setMinValue(min);
	}
	
	/**
	 *  .toString()
	 * @return
	 */
	@Override
	public String toString() {
		return "FindShortWayClassic{" +
				"shortWay=" + shortWay +
				'}';
	}
}
