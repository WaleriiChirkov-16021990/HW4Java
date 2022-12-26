package com.wch.waveAlgorithm.Project;

import com.wch.waveAlgorithm.Abstract.Fields;
import com.wch.waveAlgorithm.Interface.Fillable;

import java.util.Random;

public class MyGameField extends Fields implements Fillable {
	
	public MyGameField(int rows, int columns) {
		super(rows, columns);
		super.setNewField();
		this.fillContourField();
		this.fillGameField();
		this.fillingExit(4);
	}
	
	public MyGameField() {
		super(4,6);
		super.setNewField();
		this.fillContourField();
		this.fillGameField();
		this.fillingExit(1);
	}
	
	@Override
	protected void printField() {
		for (int i = 0; i < getField().length ; i++) {
			for (int j = 0; j < getField()[i].length ; j++) {
				System.out.print(getField()[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	@Override
	protected void fillContourField(){
		for (int i = 0; i < getField().length ; i++) {
			for (int j = 0; j < getField()[i].length ; j++) {
				if(i == 0 || i == getField().length - 1 || j == 0 || j == getField()[i].length - 1){
					getField()[i][j] = 1;
				}
			}
		}
	}
	
	@Override
	protected void fillGameField() {
		Random rnd = new Random();
		for (int i = 0; i < getField().length ; i++) {
			int first = rnd.nextInt(getField()[i].length * 3/4);
			int size = rnd.nextInt(getField()[i].length/3);
			int second = rnd.nextInt(getField()[i].length/3, getField()[i].length);
			int sizeSecond = rnd.nextInt(getField()[i].length/5);
			for (int j = 0; j < getField()[i].length ; j++) {
				if (getField()[i][j] != 1){
					if (j == first) getField()[i][j] = 1;
					else if(j < first+size && j > first) getField()[i][j] = 1;
					else if(j == second) getField()[i][j] = 1;
					else if(j>second && j < second+sizeSecond) getField()[i][j] = 1;
				}
			}
		}
	}
	
	
	@Override
	public void fillingExit(int count) {
		Random rnd = new Random();
		int first;
		int second;
		if(count >= getField().length * getField()[0].length/4){
			count = getField().length * getField()[0].length / 6;
			if(count < 1) count = 1;
		}
		while (count > 0){
			first = rnd.nextInt(getField().length);
			second = rnd.nextInt(getField().length);
			if (getField()[first][second] != 1 && getField()[first][second] != 2){
				getField()[first][second] = 2;
				count--;
			}
		}
	}
}
