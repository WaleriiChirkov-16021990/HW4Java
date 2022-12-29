package com.wch.waveAlgorithm.Project;

import java.util.*;

public class FindShortWayClassic {
	private ClassicStepper classicStepper;
	private LinkedList<int[]> shortWay = new LinkedList<>();
	private LinkedList<int[]> finish = new LinkedList<>();
	
	public void setFinish(LinkedList<int[]> finish) {
		this.finish = finish;
	}
	
	public LinkedList<int[]> getFinish() {
		return finish;
	}
	
	public LinkedList<int[]> getShortWay() {
		return shortWay;
	}
	
	public FindShortWayClassic() {
	}
	
	public FindShortWayClassic(ClassicStepper classicStepper) {
		this.classicStepper = classicStepper;
	}
	
	public ClassicStepper getClassicStepper() {
		return classicStepper;
	}
	
	public void setClassicStepper(ClassicStepper classicStepper) {
		this.classicStepper = classicStepper;
	}
	
	private void   getReverseWay(int[] finishe){
		int[] point = finishe.clone();
		int number = 1;
		while(number >= 1){
			number = classicStepper.getGameField().getField()[point[0]][point[1]];
			for (int[] a: classicStepper.getSteppers()
			     ) {
				if(classicStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] == number - 1){
					this.shortWay.push(new int[]{point[0] + a[0],point[1] + a[1]});
					point = new int[]{point[0] + a[0],point[1] + a[1]};
				}
			}
		}
	}
	public void waveScan(){
		int count = 1;
		int[] point;
		LinkedList<int[]> temp = new LinkedList<>();
		int[] start = classicStepper.getStartPoint();
		Deque<int[]> points = new LinkedList<>();
		points.push(start);
		boolean flag = true;
		while (flag){
			while (!points.isEmpty()){
				point = points.pollFirst();
				for (int[] a: classicStepper.getStepper()
				     ) {
					if (classicStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] == 0){
						classicStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] = count;
						temp.addLast(new int[]{point[0] + a[0],point[1] + a[1]});
					} else if (classicStepper.getGameField().getField()[point[0] + a[0]][point[1] + a[1]] == -2) {
						this.finish.addLast(new int[] {point[0] + a[0], point[1] + a[1]});
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
		getReverseWay(getFinish().getFirst());
	}
	
	public void setShortWay(LinkedList<int[]> shortWay) {
		this.shortWay = shortWay;
	}
	
	@Override
	public String toString() {
		return "FindShortWayClassic{" +
				"shortWay=" + shortWay +
				'}';
	}
}
