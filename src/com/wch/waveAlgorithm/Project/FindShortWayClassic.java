package com.wch.waveAlgorithm.Project;

import java.util.Deque;
import java.util.LinkedList;

public class FindShortWayClassic {
	private ClassicStepper classicStepper;
	private Deque<int[]> shortWay;
	
	public FindShortWayClassic() {
	}
	
	public FindShortWayClassic(ClassicStepper classicStepper, Deque<int[]> shortWay) {
		this.classicStepper = classicStepper;
		this.shortWay = shortWay;
	}
	
	public ClassicStepper getClassicStepper() {
		return classicStepper;
	}
	
	public void setClassicStepper(ClassicStepper classicStepper) {
		this.classicStepper = classicStepper;
	}
	
	public Deque<int[]> getShortWay() {
		int[][] pots = classicStepper.getGameField().getField();
		return shortWay;
	}
	
	public void setShortWay(Deque<int[]> shortWay) {
		this.shortWay = shortWay;
	}
	
}
