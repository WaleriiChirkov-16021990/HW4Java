package com.wch.waveAlgorithm.Project;

import com.wch.waveAlgorithm.Abstract.Stepper;
import com.wch.waveAlgorithm.Interface.WalkingAble;

//готовлю реализацию, в задании была только классика.

import java.util.Deque;
import java.util.Random;

/**
 *
 */
public class AdvanceStepper extends Stepper implements WalkingAble {
	private MyGameField gameField;
	private Deque<int[]> deque;
	private DataBase dataBase;
	private int[] startPoint;
	private int[][] steppers;
	private int[][] advannceSteps = new int[][] {{-1,1},{1,1},{1,-1},{-1,-1}};
	
	/**
	 *
	 * @param gameField
	 * @param dataBase
	 */
	public AdvanceStepper(MyGameField gameField, DataBase dataBase) {
		this.gameField = gameField;
		this.dataBase = dataBase;
	}
	
	public AdvanceStepper() {
	}
	
	/**
	 *
	 * @return
	 */
	public int[][] getAdvannceSteps() {
		return advannceSteps;
	}
	
	/**
	 *
	 * @param advannceSteps
	 */
	public void setAdvannceSteps(int[][] advannceSteps) {
		this.advannceSteps = advannceSteps;
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public int[][] getSteppers() {
		return steppers;
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public int getSizeStep() {
		return super.getStep();
	}
	
	/**
	 *
	 * @param newStepper
	 */
	@Override
	public void setSteppers(int[][] newStepper) {
		if(newStepper == null) this.setSteppers();
		else {
			this.steppers = newStepper;
		}
	}
	
	/**
	 *
	 */
	@Override
	public void setSteppers() {
		this.setSteppers(new int[][]{{-1,0},{0,1},{1,0},{0,-1}});
	}
	
	/**
	 *
	 * @param size
	 */
	@Override
	public void setSizeStep(int size) {
		if(size >= 1){
			super.setStep(size);
		} else super.setStep(1);
	}
	
	/**
	 *
	 * @return
	 */
	public MyGameField getGameField() {
		return gameField;
	}
	
	/**
	 *
	 * @param gameField
	 */
	public void setGameField(MyGameField gameField) {
		this.gameField = gameField;
	}
	
	/**
	 *
	 * @return
	 */
	public Deque<int[]> getDeque() {
		return deque;
	}
	
	/**
	 *
	 * @param deque
	 */
	public void setDeque(Deque<int[]> deque) {
		this.deque = deque;
	}
	
	/**
	 *
	 * @return
	 */
	public DataBase getDataBase() {
		return dataBase;
	}
	
	/**
	 *
	 * @param dataBase
	 */
	public void setDataBase(DataBase dataBase) {
		this.dataBase = dataBase;
	}
	
	/**
	 *
	 * @return
	 */
	public int[] getStartPoint() {
		return startPoint;
	}
	
	/**
	 *
	 * @param startPoint
	 */
	public void setStartPoint(int[] startPoint) {
		this.startPoint = startPoint;
	}
	
	/**
	 *
	 */
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
	
	
	
	
	//готовлю реализацию, в задании была только классика.
}
