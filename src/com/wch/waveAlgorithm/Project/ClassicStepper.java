package com.wch.waveAlgorithm.Project;

import com.wch.waveAlgorithm.Abstract.Stepper;
import com.wch.waveAlgorithm.Interface.WalkingAble;

import java.util.*;

public class ClassicStepper extends Stepper implements WalkingAble {
	private int[] up;
	private int[] right;
	private int[] down;
	private int[] left;
	private int[][] Stepper ;
	private MyGameField gameField;
	private Deque<int[]> deque;
	private DataBase dataBase;
	private int[] startPoint;
	public ClassicStepper() {
		setUp(new int[]{-getStep(),0});
		setRight(new int[]{0,getStep()});
		setDown(new int[]{getStep(),0});
		setLeft(new int[]{0,-getStep()});
		this.deque =  new LinkedList<>();
		this.dataBase = new DataBase();
	}
	
	public ClassicStepper(MyGameField gameField, DataBase dataBase) {
		this.gameField = gameField;
		this.dataBase = dataBase;
		setUp(new int[]{-getStep(),0});
		setRight(new int[]{0,getStep()});
		setDown(new int[]{getStep(),0});
		setLeft(new int[]{0,-getStep()});
		this.deque =  new LinkedList<>();
	}
	
	public ClassicStepper(int[] up, int[] right, int[] down, int[] left) {
		setSizeStep(1);
		this.up = up;
		this.right = right;
		this.down = down;
		this.left = left;
		this.deque =  new LinkedList<>();
		this.dataBase = new DataBase();
	}
	
	public void setRndStartPoint(int[] startPoint) {
		this.startPoint = startPoint;
	}
	
	
	public int[][] getStepper() {
		return Stepper;
	}
	
	public void setStepper(int[][] stepper) {
		Stepper = stepper;
	}
	
	public MyGameField getGameField() {
		return gameField;
	}
	
	public void setGameField(MyGameField gameField) {
		this.gameField = gameField;
	}
	
	public Deque<int[]> getDeque() {
		return deque;
	}
	
	public void setDeque(Deque<int[]> deque) {
		this.deque = deque;
	}
	
	public DataBase getDataBase() {
		return dataBase;
	}
	
	public void setDataBase(DataBase dataBase) {
		this.dataBase = dataBase;
	}
	
	public int[] getUp() {
		return up;
	}
	
	public int[] getRight() {
		return right;
	}
	
	public int[] getDown() {
		return down;
	}
	
	public int[] getLeft() {
		return left;
	}
	
	public void setUp(int[] up) {
		this.up = up;
	}
	
	public void setRight(int[] right) {
		this.right = right;
	}
	
	public void setDown(int[] down) {
		this.down = down;
	}
	
	public void setLeft(int[] left) {
		this.left = left;
	}
	@Override
	public int[][] getSteppers() {
		return this.Stepper;
	}
	@Override
	public int getSizeStep() {
		return super.getStep();
	}
	@Override
	public void setSteppers(int[][] newStepper) {
		if(newStepper == null) this.setSteppers();
		else {
			this.Stepper = newStepper;
		}
	}
	@Override
	public void setSteppers() {
		this.setSteppers(new int[][]{getUp(),getRight(),getDown(),getLeft()});
	}
	public int[] getStartPoint() {
		return startPoint;
	}
	@Override
	public void setSizeStep(int size) {
		super.setStep(size);
	}
	public void setRndStartPoint(){
		Random random = new Random();
		int size = this.getGameField().getField().length;
		int size2 = this.getGameField().getField()[0].length;
		int count = 10000;
		while (true && count > 0){
			int rows = random.nextInt(0,size);
			int columns = random.nextInt(0, size2);
			if(getGameField().getField()[rows][columns] != -2 &&
				getGameField().getField()[rows][columns] != -1){
				getGameField().getField()[rows][columns] = 1;
				this.startPoint = new int[]{rows,columns};
				break;
			}
			count--;
		}
	}
}