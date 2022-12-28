package com.wch.waveAlgorithm.Project;

import com.wch.waveAlgorithm.Abstract.Stepper;
import com.wch.waveAlgorithm.Interface.WalkingAble;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class ClassicStepper extends Stepper implements WalkingAble {
	private int[] up;
	private int[] right;
	private int[] down;
	private int[] left;
	private int[][] Stepper = { {getUp()[0],getUp()[1]},
								{getRight()[0],getRight()[1]},
								{getDown()[0],getDown()[1]},
								{getLeft()[0], getLeft()[1]}
								};
	private MyGameField gameField;
	
	private Deque<int[]> deque;
	private MemoryPoint memoryPoint;
	private DataBase dataBase;
	
	private int[] startPoint;
	
	public ClassicStepper() {
		setSizeStep(1);
		setUp(new int[]{-getStep(),0});
		setRight(new int[]{0,getStep()});
		setDown(new int[]{getStep(),0});
		setLeft(new int[]{0,-getStep()});
		this.deque = (Deque<int[]>) new ArrayList<int[]>();
		this.memoryPoint = new MemoryPoint();
		this.dataBase = new DataBase();
	}
	
	public ClassicStepper(int[] up, int[] right, int[] down, int[] left) {
		setSizeStep(1);
		this.up = up;
		this.right = right;
		this.down = down;
		this.left = left;
		this.deque = (Deque<int[]>) new ArrayList<int[]>();
		this.memoryPoint = new MemoryPoint();
		this.dataBase = new DataBase();
		this.setRndStartPoint();
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
	
	public MemoryPoint getMemoryPoint() {
		return memoryPoint;
	}
	
	public void setMemoryPoint(MemoryPoint memoryPoint) {
		this.memoryPoint = memoryPoint;
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
			this.getSteppers()[0] = newStepper[0];
			this.getSteppers()[1] = newStepper[1];
			this.getSteppers()[2] = newStepper[2];
			this.getSteppers()[3] = newStepper[3];
		}
	}
	
	@Override
	public void setSteppers() {
		this.getSteppers()[0] = getUp();
		this.getSteppers()[1] = getRight();
		this.getSteppers()[2] = getDown();
		this.getSteppers()[3] = getLeft();
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
		int count = 10000;
		while (true && count > 0){
			int rows = random.nextInt(getGameField().getField().length);
			int columns = random.nextInt(getGameField().getField()[0].length);
			if(getGameField().getField()[rows][columns] != -2 &&
				getGameField().getField()[rows][columns] != -1){
				this.setRndStartPoint(new int[]{rows,columns});
				break;
			}
			count--;
		}
	}
}
