package com.wch.waveAlgorithm.Project;

import java.util.ArrayList;

public class DataBase {
	private ArrayList<MemoryPoint> dataBase;
	private int[] firstFinish;
	
	public DataBase(ArrayList<MemoryPoint> dataBase) {
		this.dataBase = dataBase;
	}
	public DataBase() {
	}
	
	public ArrayList<MemoryPoint> getDataBase() {
		return dataBase;
	}
	
	public void setDataBase(ArrayList<MemoryPoint> dataBase) {
		this.dataBase = dataBase;
	}
	
	public int[] getFirstFinish() {
		return firstFinish;
	}
	
	public void setFirstFinish(int[] firstFinish) {
		this.firstFinish = firstFinish;
	}
}
