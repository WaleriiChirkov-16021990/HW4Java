package com.wch.waveAlgorithm.Project;

import com.wch.waveAlgorithm.Abstract.Stepper;
import com.wch.waveAlgorithm.Interface.WalkingAble;

public class AdvanceStepper extends Stepper implements WalkingAble {
	@Override
	public int[][] getSteppers() {
		return new int[0][];
	}
	
	@Override
	public int getSizeStep() {
		return 0;
	}
	
	@Override
	public void setSteppers(int[][] newStepper) {
	
	}
	
	@Override
	public void setSteppers() {
	
	}
	
	@Override
	public void setSizeStep(int size) {
	
	}
	
	//готовлю реализацию
}
